package uz.devazimjon.sample.mover.core.domain

sealed interface UIComponent {

    data class Dialog(
        val title: String,
        val description: String,
    ) : UIComponent

    data class None(
        val message: String,
    ) : UIComponent
}
