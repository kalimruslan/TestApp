package ru.androidrt.test.domain.model

interface Similirable<T> {
    fun areItemsTheSame(other: T): Boolean
    fun areContentsTheSame(other: T): Boolean
}