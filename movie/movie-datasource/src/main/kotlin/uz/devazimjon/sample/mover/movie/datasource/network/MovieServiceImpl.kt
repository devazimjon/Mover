package uz.devazimjon.sample.mover.movie.datasource.network

import io.ktor.client.HttpClient
import uz.devazimjon.sample.mover.movie.datasource.network.model.MovieResponse

internal class MovieServiceImpl(private val httpClient: HttpClient) : MovieService {

    override suspend fun getMovies(): List<MovieResponse> {
        return listOf()
//        return httpClient.get<List<MovieResponse>>(MOVIE_LIST).map { it.toMovie() }
    }

    private companion object {
        const val BASE_URL = "https://api.themoviedb.org/3"
        const val MOVIE_LIST = "$BASE_URL/movie/latest"
    }
}
