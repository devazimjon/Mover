package uz.devazimjon.sample.mover.core.util

@Suppress("Unused")
class Logger internal constructor(
    private val tag: String,
    private val isDebug: Boolean
) {

    fun log(message: String) {
        if (!isDebug) {
            // cannot log in release
        } else {
            printLog(tag, message)
        }
    }

    private fun printLog(tag: String, message: String) {
        println("$tag: $message")
    }

    companion object {
        fun createDebug(className: String): Logger {
            return Logger(
                tag = className,
                isDebug = true
            )
        }

        fun createRelease(className: String): Logger {
            return Logger(
                tag = className,
                isDebug = false
            )
        }
    }
}
