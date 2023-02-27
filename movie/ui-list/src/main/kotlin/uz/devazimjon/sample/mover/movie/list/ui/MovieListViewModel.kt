package uz.devazimjon.sample.mover.movie.list.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.devazimjon.sample.mover.core.domain.DataState
import uz.devazimjon.sample.mover.core.domain.Queue
import uz.devazimjon.sample.mover.core.domain.UIComponent
import uz.devazimjon.sample.mover.core.domain.UIComponentState
import uz.devazimjon.sample.mover.core.util.Logger
import uz.devazimjon.sample.mover.movie.interactors.FilterMovies
import uz.devazimjon.sample.mover.movie.interactors.GetMovies

@HiltViewModel
class MovieListViewModel(
    private val getMovies: GetMovies,
    private val filterMovies: FilterMovies,
    private val logger: Logger
) : ViewModel() {

    val state: MutableState<MovieListState> = mutableStateOf(MovieListState())

    init {
        onTriggerEvent(MovieListEvents.GetMovies)
    }

    fun onTriggerEvent(event: MovieListEvents) {
        when (event) {
            is MovieListEvents.ChangeMovieName -> {
                updateMovieName(event.name)
            }
            is MovieListEvents.FilterMovies -> {
                filterMovies()
            }
            is MovieListEvents.GetMovies -> {
                getMovies()
            }
            is MovieListEvents.OnRemoveHeadFromQueue -> {
                removeHeadMessage()
            }
            is MovieListEvents.UpdateFilterDialogState -> {
                updateFilterDialogState(event.state)
            }
            is MovieListEvents.UpdateMovieName -> {
                updateMovieName(event.name)
            }
        }
    }

    private fun updateFilterDialogState(filterDialogState: UIComponentState) {
        state.value = state.value.copy(filteredDialogState = filterDialogState)
    }

    private fun updateMovieName(name: String) {
        state.value = state.value.copy(
            movieName = name
        )
    }

    private fun filterMovies() = with(state.value) {
        val filteredMovies = filterMovies.execute(
            list = movies,
            name = movieName,
            filterOrder = filterOrder
        )
        state.value = copy(filteredMovies = filteredMovies)
    }


    private fun getMovies() {
        getMovies.execute()
            .flowOn(Dispatchers.IO)
            .onEach { dataState ->
                when (dataState) {
                    is DataState.Data -> {
                        state.value = state.value.copy(movies = dataState.data ?: listOf())
                    }
                    is DataState.Loading -> {
                        state.value =
                            state.value.copy(progressBarState = dataState.progressBarState)
                    }
                    is DataState.Response -> {
                        when (val uiComponent = dataState.uiComponent) {
                            is UIComponent.None -> {
                                logger.log("getMovies: ${uiComponent.message}")
                            }
                            else -> {
                                appendToMessageQueue(uiComponent)
                            }
                        }
                    }
                }
            }
            .flowOn(Dispatchers.Main)
            .launchIn(viewModelScope)
    }

    private fun appendToMessageQueue(uiComponent: UIComponent) {
        val queue = state.value.errorQueue
        queue.add(uiComponent)
        state.value = state.value.copy(errorQueue = Queue(mutableListOf())) // force recompose
        state.value = state.value.copy(errorQueue = queue)
    }

    private fun removeHeadMessage() {
        runCatching {
            val queue = state.value.errorQueue
            queue.remove()
            state.value = state.value.copy(errorQueue = Queue(mutableListOf())) // force recompose
            state.value = state.value.copy(errorQueue = queue)
        }.getOrNull()
    }
}
