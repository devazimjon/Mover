plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.Movie.datasource))
    implementation(project(Modules.Movie.domain))

    implementation(KotlinX.coroutinesCore)

    testImplementation(project(Modules.Movie.datasourceTest))
    testImplementation(Junit.junit4)
    testImplementation(Ktor.ktorClientMock)
    testImplementation(Ktor.clientSerialization)
}
