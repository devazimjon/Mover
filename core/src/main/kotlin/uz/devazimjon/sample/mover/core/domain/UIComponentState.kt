package uz.devazimjon.sample.mover.core.domain

sealed interface UIComponentState {

    object Show : UIComponentState

    object Hide : UIComponentState
}
