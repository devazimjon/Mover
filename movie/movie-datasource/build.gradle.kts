plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id(SqlDelight.plugin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(project(Modules.movie_domain))
    implementation(Ktor.core)
    implementation(Ktor.clientSerialization)
    implementation(Ktor.android)
    implementation(SqlDelight.runtime)
}

//sqldelight {
//    database("MovieDatabase") {
//        packageName = "uz.devazimjon.sample.mover.movie_datasource.cache"
//        sourceFolders = listOf("sqldelight")
//    }
//}
