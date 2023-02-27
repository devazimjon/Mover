package uz.devazimjon.sample.mover.di

import android.app.Application
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.devazimjon.sample.mover.movie.interactors.MovieInteractors
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class MovieInteractorsModule {

//    @Singleton
//    @Provides
//    fun sqlDriver(app: Application) : SqlDriver{
//        return AndroidSqliteDriver(
//            schema = MovieInteractors.SCHEME,
//            context = app,
//            name = MovieInteractors.Factory
//        )
//    }

    @Singleton
    @Provides
    fun movieListInteractor(): MovieInteractors {
        return MovieInteractors.create()
    }
}
