package ru.androidrt.test.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout) {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callOperations()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLayoutSetup()
        onBindViewModel()
    }

    // настройка вьюшек, листенеры и т.д.
    abstract fun onLayoutSetup()

    // Подписка к изменеиям livedata
    abstract fun onBindViewModel()

    // Получение всяких данных из репозиторий
    abstract fun callOperations()

    protected infix fun <T> LiveData<T>.observe(block: (T) -> Unit) {
        observe(this@BaseFragment.viewLifecycleOwner, { t -> block.invoke(t) })
    }

    @MainThread
    inline fun <reified VM : ViewModel> Fragment.appViewModels() =
        createViewModelLazy(VM::class, { this.viewModelStore }, { viewModelFactory })
}