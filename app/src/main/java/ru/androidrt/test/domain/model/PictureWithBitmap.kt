package ru.androidrt.test.domain.model

import android.graphics.Bitmap

data class PictureWithBitmap(
    val bitmap: Bitmap?
) : Similirable<PictureWithBitmap>{
    override fun areItemsTheSame(other: PictureWithBitmap): Boolean {
        return true
    }

    override fun areContentsTheSame(other: PictureWithBitmap): Boolean {
        return other == this
    }
}
