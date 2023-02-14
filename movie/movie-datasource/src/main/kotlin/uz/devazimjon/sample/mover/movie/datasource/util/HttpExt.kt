package uz.devazimjon.sample.mover.movie.datasource.util

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json

internal fun httpClient(): HttpClient {
    return HttpClient(Android) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(json)
        }
    }
}

private val json = Json {
    ignoreUnknownKeys = true
}