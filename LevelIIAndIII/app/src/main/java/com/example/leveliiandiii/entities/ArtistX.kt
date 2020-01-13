package com.example.leveliiandiii.entities


import com.google.gson.annotations.SerializedName

data class ArtistX(
    @SerializedName("image")
    val image: List<ImageX>,
    @SerializedName("listeners")
    val listeners: String,
    @SerializedName("mbid")
    val mbid: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("streamable")
    val streamable: String,
    @SerializedName("url")
    val url: String
)