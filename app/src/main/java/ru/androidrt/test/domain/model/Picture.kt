package ru.androidrt.test.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Picture (
    val id: Int,
    val pageUrl: String,
    val tags: String,
    val previewURL: String,
    val largeImageURL: String,
    val user: String
) : Similirable<Picture>, Parcelable{
    override fun areItemsTheSame(other: Picture): Boolean {
        return other.id == this.id
    }

    override fun areContentsTheSame(other: Picture): Boolean {
        return other == this
    }
}