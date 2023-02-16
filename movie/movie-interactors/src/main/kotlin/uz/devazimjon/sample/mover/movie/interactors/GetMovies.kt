package uz.devazimjon.sample.mover.movie.interactors

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.devazimjon.sample.mover.core.domain.DataState
import uz.devazimjon.sample.mover.core.domain.ProgressBarState
import uz.devazimjon.sample.mover.core.domain.UIComponent
import uz.devazimjon.sample.mover.core.util.UseCase
import uz.devazimjon.sample.mover.movie.datasource.cache.MovieCache
import uz.devazimjon.sample.mover.movie.datasource.network.MovieService
import uz.devazimjon.sample.mover.movie.domain.Movie

class GetMovies(
    private val cache: MovieCache,
    private val service: MovieService,
) : UseCase<Flow<DataState<List<Movie>>>> {

    fun execute(): Flow<DataState<List<Movie>>> = flow {
        emit(DataState.Loading(progressBarState = ProgressBarState.Loading))

        runCatching {
            service.getMovies()
        }.fold(
            onSuccess = { movies ->
                cache.insert(movies)
                val cachedMovies = cache.getMovies()
                emit(DataState.Data(cachedMovies))
            },
            onFailure = {
                emit(
                    DataState.Response(
                        uiComponent = UIComponent.Dialog(
                            title = "Network Data Error",
                            description = it.message ?: "Unknown error"
                        )
                    )
                )
            }
        )
        emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
    }
}
