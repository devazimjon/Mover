package uz.devazimjon.sample.mover.di

import android.app.Application
import coil.Coil
import coil.ImageLoader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CoilModule {

    @Provides
    @Singleton
    fun imageLoader(app: Application): ImageLoader {
        return ImageLoader.Builder(app)
//            .placeholder(R.drawable.)
            .availableMemoryPercentage(0.25) // Don't know what is recommended?
            .crossfade(true)
            .build()
    }
}