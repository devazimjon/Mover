package uz.devazimjon.sample.mover.movie.list.ui

import uz.devazimjon.sample.mover.core.domain.FilterOrder
import uz.devazimjon.sample.mover.core.domain.ProgressBarState
import uz.devazimjon.sample.mover.core.domain.Queue
import uz.devazimjon.sample.mover.core.domain.UIComponent
import uz.devazimjon.sample.mover.core.domain.UIComponentState
import uz.devazimjon.sample.mover.movie.domain.Movie

data class MovieListState(
    val movies: List<Movie> = listOf(),
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val filteredMovies: List<Movie> = listOf(),
    val filteredDialogState: UIComponentState = UIComponentState.Hide,
    val filterOrder: FilterOrder = FilterOrder.Descending,
    val movieName: String = "",
    val errorQueue : Queue<UIComponent> = Queue(mutableListOf())
)