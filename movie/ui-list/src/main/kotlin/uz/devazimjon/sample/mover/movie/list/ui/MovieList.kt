package uz.devazimjon.sample.mover.movie.list.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import coil.ImageLoader
import uz.devazimjon.sample.mover.components.DefaultScreenUi


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

        }
    }
}