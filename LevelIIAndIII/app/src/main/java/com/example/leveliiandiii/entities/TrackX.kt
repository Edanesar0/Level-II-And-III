package com.example.leveliiandiii.entities


import com.google.gson.annotations.SerializedName

data class TrackX(
    @SerializedName("artist")
    val artist: Artist,
    @SerializedName("@attr")
    val attr: AttrX,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("image")
    val image: List<Image>,
    @SerializedName("listeners")
    val listeners: String,
    @SerializedName("mbid")
    val mbid: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("streamable")
    val streamable: Streamable,
    @SerializedName("url")
    val url: String
)