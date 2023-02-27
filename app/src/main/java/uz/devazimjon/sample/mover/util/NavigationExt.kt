package uz.devazimjon.sample.mover.util

import androidx.navigation.NavType
import androidx.navigation.compose.navArgument

fun IntNavType(name: String) = navArgument(name) { type = NavType.IntType }