package ru.androidrt.test.domain

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import ru.androidrt.test.data.LoadableResult
import ru.androidrt.test.domain.model.Picture
import ru.androidrt.test.domain.model.PictureWithBitmap
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import javax.inject.Inject


class PicturesInteracts @Inject constructor(private val repository: PicturesRepository) {

    suspend fun getPictures(): LoadableResult<List<Picture>> {
        return repository.getPictures()
    }

    suspend fun download(imageUrl: String): Bitmap? {
        var bitmap: Bitmap? = null
        withContext(Dispatchers.IO){
            bitmap = try {
                val url = URL(imageUrl)
                val connection: HttpURLConnection = url
                    .openConnection() as HttpURLConnection
                connection.doInput = true
                connection.connect()
                val input: InputStream = connection.inputStream
                BitmapFactory.decodeStream(input)
            } catch (e: IOException) {
                e.printStackTrace()
                null
            }
        }
        return bitmap
    }
}