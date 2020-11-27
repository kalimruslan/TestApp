package ru.androidrt.test.presentation.pictures

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.androidrt.test.data.LoadableResult
import ru.androidrt.test.domain.PicturesInteracts
import ru.androidrt.test.domain.model.Picture
import javax.inject.Inject

class PicturesViewModel @Inject constructor(private val interactor: PicturesInteracts) : ViewModel() {

    private val _allPicturesMutableLiveData: MutableLiveData<LoadableResult<List<Picture>>> = MutableLiveData()
    val allPicturesLiveData: LiveData<LoadableResult<List<Picture>>> = _allPicturesMutableLiveData

    fun getPicturesData() {
        viewModelScope.launch {
            val result = interactor.getPictures()

            _allPicturesMutableLiveData.value = result
        }
    }

}