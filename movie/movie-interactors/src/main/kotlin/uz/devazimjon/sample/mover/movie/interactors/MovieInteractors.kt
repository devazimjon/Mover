package uz.devazimjon.sample.mover.movie.interactors

import com.squareup.sqldelight.db.SqlDriver
import uz.devazimjon.sample.mover.movie.datasource.cache.MovieCache
import uz.devazimjon.sample.mover.movie.datasource.network.MovieService

interface MovieInteractors {

    val getMovies: GetMovies

    val filterMovies: FilterMovies

    val getMovieFromCache: GetMovieFromCache

    companion object Factory {

        fun create(): MovieInteractors {
            val movieCache = MovieCache()
            return object : MovieInteractors {
                override val getMovies = GetMovies(
                    cache = movieCache,
                    service = MovieService()
                )
                override val filterMovies = FilterMovies()
                override val getMovieFromCache = GetMovieFromCache(movieCache)
            }
        }
    }
}
