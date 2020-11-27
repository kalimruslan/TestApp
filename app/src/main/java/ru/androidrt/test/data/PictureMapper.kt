package ru.androidrt.test.data

import ru.androidrt.test.data.model.PicturesResponse
import ru.androidrt.test.domain.model.Picture
import javax.inject.Inject

class PictureMapper @Inject constructor() {

    fun fromApiToModel(picturesResponse: PicturesResponse) : List<Picture>{
        return picturesResponse.hits.map { fromApiToModel(it) }
    }

    private fun fromApiToModel(hit: PicturesResponse.Hit) : Picture{
        return Picture(
            id = hit.id,
            pageUrl = hit.pageURL,
            tags = hit.tags,
            previewURL = hit.previewURL,
            largeImageURL = hit.largeImageURL,
            user = hit.user
        )
    }
}