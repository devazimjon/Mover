package uz.devazimjon.sample.mover.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.devazimjon.sample.mover.core.util.Logger
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun logger(): Logger {
        return Logger.createDebug("AppDebug")
    }
}
