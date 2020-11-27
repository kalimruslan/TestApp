package ru.androidrt.test.domain

import ru.androidrt.test.data.LoadableResult
import ru.androidrt.test.domain.model.Picture

interface PicturesRepository {
    suspend fun getPictures(): LoadableResult<List<Picture>>
}