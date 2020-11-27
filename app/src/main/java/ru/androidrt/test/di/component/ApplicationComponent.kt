package ru.androidrt.test.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.androidrt.test.App
import ru.androidrt.test.di.module.ApplicationModule
import ru.androidrt.test.di.module.FragmentModule
import ru.androidrt.test.di.module.NetworkModule
import ru.androidrt.test.di.module.RepositoryModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    NetworkModule::class,
    FragmentModule::class,
    RepositoryModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: App): ApplicationComponent
    }
}