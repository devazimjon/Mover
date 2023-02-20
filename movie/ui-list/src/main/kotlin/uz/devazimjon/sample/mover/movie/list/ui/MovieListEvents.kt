package uz.devazimjon.sample.mover.movie.list.ui

sealed interface MovieListEvents {

    object GetMovies : MovieListEvents

    class FilterMovies(val name: String) : MovieListEvents

    object OnRemoveHeadFromQueue: MovieListEvents
}
