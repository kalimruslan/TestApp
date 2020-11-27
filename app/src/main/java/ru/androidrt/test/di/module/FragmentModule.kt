package ru.androidrt.test.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.androidrt.test.presentation.picture.PictureDetailFragment
import ru.androidrt.test.presentation.pictures.PicturesFragment

@Module(includes = [ViewModelModule::class])
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun picturesFragment(): PicturesFragment

    @ContributesAndroidInjector
    abstract fun pictureFragment(): PictureDetailFragment
}