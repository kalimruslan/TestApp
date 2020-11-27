package ru.androidrt.test.presentation.pictures

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_picture.view.imageViewPicture
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.androidrt.test.R
import ru.androidrt.test.domain.model.Picture
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class PictureViewHolder(
    parent: ViewGroup,
    private val lifecycleCoroutineScope: LifecycleCoroutineScope?,
    private val onPictureClick: (Picture) -> Unit
) :
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_picture, parent, false)) {
    fun bind(picture: Picture) = with(itemView) {
        picture.apply {
            lifecycleCoroutineScope?.launch {
                val result = downloadImage(previewURL)
                imageViewPicture.setImageBitmap(result)
            }

            setOnClickListener { onPictureClick.invoke(this) }
        }
    }

    private suspend fun downloadImage(imageUrl: String): Bitmap? {
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