package uz.devazimjon.sample.mover.movie.datasource.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import uz.devazimjon.sample.mover.core.util.mapper.mapIn
import uz.devazimjon.sample.mover.movie.datasource.network.mapper.toMovie
import uz.devazimjon.sample.mover.movie.datasource.network.model.MovieResponse
import uz.devazimjon.sample.mover.movie.domain.Movie

internal class MovieServiceImpl(private val httpClient: HttpClient) : MovieService {

    override suspend fun getMovies(): List<Movie> {
        return httpClient.get<List<MovieResponse>>(MOVIE_LIST)
            .mapIn { toMovie() }
    }

    private companion object {
        const val BASE_URL = "https://api.themoviedb.org/3"
        const val MOVIE_LIST = "$BASE_URL/movie/latest"
    }
}
