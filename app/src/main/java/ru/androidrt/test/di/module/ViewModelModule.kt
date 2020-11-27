package ru.androidrt.test.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.androidrt.test.di.utils.ViewModelFactory
import ru.androidrt.test.di.utils.ViewModelKey
import ru.androidrt.test.presentation.picture.PictureDetailViewModel
import ru.androidrt.test.presentation.pictures.PicturesViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PicturesViewModel::class)
    abstract fun providePicturesViewModel(viewModel: PicturesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PictureDetailViewModel::class)
    abstract fun providePictureViewModel(viewModel: PictureDetailViewModel): ViewModel
}