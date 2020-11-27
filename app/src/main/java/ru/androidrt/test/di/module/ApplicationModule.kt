package ru.androidrt.test.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.androidrt.test.App
import ru.androidrt.test.domain.model.DiffUtilItemCallbackFactory

@Module
class ApplicationModule {
    @Provides
    fun provideContext(app: App): Context {
        return app.applicationContext
    }

    @Provides
    fun provideDiffUtilItemCallbackFactory(): DiffUtilItemCallbackFactory {
        return DiffUtilItemCallbackFactory()
    }
}