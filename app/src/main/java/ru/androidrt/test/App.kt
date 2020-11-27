package ru.androidrt.test

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.androidrt.test.di.component.DaggerApplicationComponent

class App: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent
            .factory()
            .create(this)
    }
}