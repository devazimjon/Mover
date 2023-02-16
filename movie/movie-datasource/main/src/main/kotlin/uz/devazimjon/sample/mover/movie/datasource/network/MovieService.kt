package uz.devazimjon.sample.mover.movie.datasource.network

import uz.devazimjon.sample.mover.movie.datasource.util.httpClient
import uz.devazimjon.sample.mover.movie.domain.Movie

interface MovieService {

    suspend fun getMovies(): List<Movie>

    companion object {
        operator fun invoke(): MovieService {
            return MovieServiceImpl(httpClient())
        }
    }
}
