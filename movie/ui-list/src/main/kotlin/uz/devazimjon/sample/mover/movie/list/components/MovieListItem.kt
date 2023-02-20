package uz.devazimjon.sample.mover.movie.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberImagePainter
import uz.devazimjon.sample.mover.R
import uz.devazimjon.sample.mover.movie.domain.Movie

@Composable
fun MovieListItem(
    movie: Movie,
    onClick: (Long) -> Unit,
    imageLoader: ImageLoader
) {
    Surface(
        modifier = Modifier.fillMaxWidth()
            .padding(bottom = 8.dp)
            .background(MaterialTheme.colors.surface)
            .clickable {
                onClick(movie.id)
            },
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val painter = rememberImagePainter(
                movie.image,
                imageLoader = imageLoader,
                builder = {
                    placeholder(if (isSystemInDarkTheme()) R.drawable.black_background else R.drawable.white_background)
                }
            )
            Image(
                modifier = Modifier
                    .width(120.dp)
                    .height(70.dp),
                painter = painter,
                contentDescription = movie.name,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.fillMaxWidth(0.8f)
                    .padding(start = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                        .testTag("MOVIE_NAME"),
                    text = movie.name,
                    style = MaterialTheme.typography.h4,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier
                        .testTag("MOVIE_DESCRIPTION_NAME"),
                    text = movie.description,
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}
