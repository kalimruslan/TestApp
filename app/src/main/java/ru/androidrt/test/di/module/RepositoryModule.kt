package ru.androidrt.test.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.androidrt.test.data.PictureRepositoryImpl
import ru.androidrt.test.domain.PicturesRepository

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun providePictureRepository(repository: PictureRepositoryImpl) : PicturesRepository
}