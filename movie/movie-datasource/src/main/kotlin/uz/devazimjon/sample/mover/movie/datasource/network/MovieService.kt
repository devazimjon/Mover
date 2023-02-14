package uz.devazimjon.sample.mover.movie.datasource.network

import uz.devazimjon.sample.mover.movie.datasource.network.model.MovieResponse
import uz.devazimjon.sample.mover.movie.datasource.util.httpClient

interface MovieService {

    suspend fun getMovies(): List<MovieResponse>

    companion object {
        operator fun invoke(): MovieService {
            return MovieServiceImpl(httpClient())
        }
    }
}
