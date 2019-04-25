package com.bruno.movieapp.clean_movies_kotlin_app.movies_list.data.mapper

interface Mapper<E, D> {

    fun mapFromEntity(type: E): D

    fun mapToEntity(type: D): E

}