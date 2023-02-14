package uz.devazimjon.sample.mover.core.domain

sealed interface ProgressBarState {

    object Loading : ProgressBarState

    object Idle : ProgressBarState
}