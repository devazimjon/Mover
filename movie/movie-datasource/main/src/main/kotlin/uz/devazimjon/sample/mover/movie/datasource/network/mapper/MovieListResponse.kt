package uz.devazimjon.sample.mover.movie.datasource.network.mapper

import uz.devazimjon.sample.mover.core.util.mapper.mapper
import uz.devazimjon.sample.mover.movie.datasource.network.model.MovieResponse
import uz.devazimjon.sample.mover.movie.domain.Movie

internal fun MovieResponse.toMovie() = mapper {
    Movie(
        id = 1,
        name = "",
        description = "",
        image = ""
    )
}
