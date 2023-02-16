package uz.devazimjon.sample.mover.movie.datasource.cache

import uz.devazimjon.sample.mover.movie.domain.Movie

interface MovieCache {

    fun getMovie(id: Long): Movie?

    fun getMovies(): List<Movie>

    fun insert(list: List<Movie>)

    companion object {
        operator fun invoke(): MovieCache {
            return MovieCacheImpl()
        }
    }
}