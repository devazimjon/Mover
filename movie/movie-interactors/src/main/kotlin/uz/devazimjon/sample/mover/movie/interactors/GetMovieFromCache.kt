package uz.devazimjon.sample.mover.movie.interactors

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.devazimjon.sample.mover.core.domain.DataState
import uz.devazimjon.sample.mover.core.domain.ProgressBarState
import uz.devazimjon.sample.mover.core.domain.UIComponent
import uz.devazimjon.sample.mover.core.util.UseCase
import uz.devazimjon.sample.mover.movie.datasource.cache.MovieCache
import uz.devazimjon.sample.mover.movie.domain.Movie

class GetMovieFromCache(
    private val movieCache: MovieCache
) : UseCase<Flow<DataState<Movie>>> {

    fun execute(id: Long): Flow<DataState<Movie>> = flow {
        emit(DataState.Loading(progressBarState = ProgressBarState.Loading))
        runCatching {
            val movie = movieCache.getMovie(id)
            requireNotNull(movie) { "That hero does not exist in the cache." }
        }.fold(
            onSuccess = { movie ->
                emit(DataState.Data(movie))
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
