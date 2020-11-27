package ru.androidrt.test.data

import ru.androidrt.test.domain.PicturesRepository
import ru.androidrt.test.domain.model.Picture
import java.lang.Exception
import javax.inject.Inject

class PictureRepositoryImpl @Inject constructor(
    private val api: Api,
    private val pictureMapper: PictureMapper
) : PicturesRepository {
    override suspend fun getPictures(): LoadableResult<List<Picture>> {
        LoadableResult.loading<List<Picture>>()
        return try {
            val result = api.getPictures("19236245-57ec6303b0a37fe4e1aa0ac92")
            LoadableResult.success(pictureMapper.fromApiToModel(result))
        }
        catch (e: Exception){
            LoadableResult.failure(e)
        }
    }
}