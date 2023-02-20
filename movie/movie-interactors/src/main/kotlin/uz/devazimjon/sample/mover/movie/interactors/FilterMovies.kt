package uz.devazimjon.sample.mover.movie.interactors

import uz.devazimjon.sample.mover.core.domain.FilterOrder
import uz.devazimjon.sample.mover.core.util.UseCase
import uz.devazimjon.sample.mover.movie.domain.Movie

class FilterMovies : UseCase<List<Movie>> {

    fun execute(
        list: List<Movie>,
        name: String,
        filterOrder: FilterOrder
    ): List<Movie> {
        val result = list.filter {
            it.name.lowercase().contains(name.lowercase())
        }.toMutableList()

        when (filterOrder) {
            FilterOrder.Ascending -> {
                result.sortBy { it.name }
            }
            FilterOrder.Descending -> {
                result.sortByDescending { it.name }
            }
        }
        return result
    }
}
