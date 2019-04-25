package com.bruno.movieapp.clean_movies_kotlin_app.movies_list.cache.mapper

interface EntityMapper<T, V> {

    fun mapFromCached(type: T): V

    fun mapToCached(type: V): T

}