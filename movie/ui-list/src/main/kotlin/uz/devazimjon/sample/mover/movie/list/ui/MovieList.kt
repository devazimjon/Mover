package uz.devazimjon.sample.mover.movie.list.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import uz.devazimjon.sample.mover.components.DefaultScreenUi
import uz.devazimjon.sample.mover.core.domain.UIComponentState
import uz.devazimjon.sample.mover.movie.list.components.MovieListItem
import uz.devazimjon.sample.mover.movie.list.components.MovieListToolbar

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun MovieList(
    state: MovieListState,
    events: (MovieListEvents) -> Unit,
    navigateToMovieDetail: (id: Long) -> Unit,
    imageLoader: ImageLoader
) {
    DefaultScreenUi(
        queue = state.errorQueue,
        onRemoveHeadFromQueue = { events(MovieListEvents.OnRemoveHeadFromQueue) },
        progressBarState = state.progressBarState
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .clickable {
                        events(MovieListEvents.UpdateFilterDialogState(UIComponentState.Hide))
                    }
            ) {
                MovieListToolbar(
                    movieName = state.movieName,
                    onMovieNameChanged = {
                        events(MovieListEvents.UpdateMovieName(name = it))
                    },
                    onSearch = {
//                        events(MovieListEvents.FilterMovies)
                    },
                    onOpenFilter = {
                        events(MovieListEvents.UpdateFilterDialogState(UIComponentState.Show))
                    }
                )
                AnimatedVisibility(visible = state.movies.isNotEmpty()) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp)
                    ) {
                        items(state.movies) { movie ->
                            MovieListItem(
                                movie = movie,
                                onClick = navigateToMovieDetail,
                                imageLoader = imageLoader
                            )
                        }
                    }
                }
            }
        }
    }
}
