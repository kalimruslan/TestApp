package ru.androidrt.test.presentation.pictures

import android.view.ViewGroup
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.recyclerview.widget.ListAdapter
import ru.androidrt.test.domain.model.DiffUtilItemCallbackFactory
import ru.androidrt.test.domain.model.Picture
import javax.inject.Inject

class PicturesAdapter @Inject constructor(
    diffUtilItemCallbackFactory: DiffUtilItemCallbackFactory
) : ListAdapter<Picture, PictureViewHolder>(diffUtilItemCallbackFactory.create()) {

    var lifecycleCoroutineScope: LifecycleCoroutineScope? = null
    var onPictureClick: (Picture) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        return PictureViewHolder(parent, lifecycleCoroutineScope, onPictureClick)
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}