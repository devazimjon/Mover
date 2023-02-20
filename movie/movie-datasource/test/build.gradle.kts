plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("kotlinx-serialization")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(project(Modules.Movie.datasource))
    implementation(project(Modules.Movie.domain))

    implementation(Ktor.ktorClientMock)
    implementation(Ktor.clientSerialization)
}
