package uz.devazimjon.sample.mover.core.domain

sealed interface FilterOrder {

    object Ascending: FilterOrder

    object Descending: FilterOrder
}