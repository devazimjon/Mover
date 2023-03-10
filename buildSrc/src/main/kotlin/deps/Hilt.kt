private const val hiltVersion = "2.42"

object Hilt {
    const val android = "com.google.dagger:hilt-android:$hiltVersion"
    const val compiler = "com.google.dagger:hilt-compiler:$hiltVersion"

    const val hiltAndroid = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"
}

object HiltTest {
    const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:$hiltVersion"
}
