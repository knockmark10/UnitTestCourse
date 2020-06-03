package com.markoid.cleanbase.movies.data.net.entities

import com.google.gson.annotations.SerializedName

data class MoviesItem(

    @SerializedName("code")
    val _code: String? = null,

    @SerializedName("name")
    val _name: String? = null,

    @SerializedName("duration")
    val _duration: String? = null,

    @SerializedName("rating")
    val _rating: String? = null,

    @SerializedName("synopsis")
    val _synopsis: String? = null

) {

    val name: String
        get() = _name ?: ""

    val duration: String
        get() = _duration ?: ""

    val rating: String
        get() = _rating ?: ""

    val synopsis: String
        get() = _synopsis ?: ""

}