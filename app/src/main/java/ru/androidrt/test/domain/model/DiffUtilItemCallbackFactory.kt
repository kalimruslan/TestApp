package ru.androidrt.test.domain.model

import androidx.recyclerview.widget.DiffUtil

class DiffUtilItemCallbackFactory {
    fun <T : Similirable<T>> create(): DiffUtil.ItemCallback<T> {
        return object : DiffUtil.ItemCallback<T>() {
            override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.areItemsTheSame(newItem)
            override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem.areContentsTheSame(newItem)
        }
    }
}