package uz.devazimjon.sample.mover.movie.list.ui

import uz.devazimjon.sample.mover.core.domain.UIComponentState

sealed interface MovieListEvents {

    object GetMovies : MovieListEvents

    class FilterMovies(val name: String) : MovieListEvents

    object OnRemoveHeadFromQueue : MovieListEvents

    class UpdateFilterDialogState(val state: UIComponentState) : MovieListEvents
}
