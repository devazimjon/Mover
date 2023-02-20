package uz.devazimjon.sample.mover.movie.list.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.devazimjon.sample.mover.movie.interactors.FilterMovies
import uz.devazimjon.sample.mover.movie.interactors.GetMovies
import uz.devazimjon.sample.mover.movie.interactors.MovieInteractors
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MovieListModule {

    @Provides
    @Singleton
    fun provideGetMovies(
        movieInteractors: MovieInteractors
    ): GetMovies = movieInteractors.getMovies

    @Provides
    @Singleton
    fun provideFilterMovies(
        movieInteractors: MovieInteractors
    ): FilterMovies = movieInteractors.filterMovies
}