package ru.androidrt.test.presentation.picture

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.androidrt.test.domain.PicturesInteracts
import javax.inject.Inject

class PictureDetailViewModel @Inject constructor(private val interactor: PicturesInteracts): ViewModel() {
    private val _bitmapDownloadMutableLiveData = MutableLiveData<Bitmap>()
    val bitmapDownloadedLiveData: LiveData<Bitmap> = _bitmapDownloadMutableLiveData

    fun downloadPicture(url: String){
        viewModelScope.launch {
            val bitmap = interactor.download(url)
            _bitmapDownloadMutableLiveData.postValue(bitmap)
        }
    }
}