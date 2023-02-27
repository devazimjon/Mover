package uz.devazimjon.sample.mover.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.navArgument
import uz.devazimjon.sample.mover.util.IntNavType

sealed class Screen(val route: String, val arguments: List<NamedNavArgument>) {

    object MovieList : Screen(
        route = "MovieList",
        arguments = emptyList()
    )

    object MovieDetail : Screen(
        route = "MovieDetail",
        arguments = listOf(IntNavType("movieId"))
    )
}