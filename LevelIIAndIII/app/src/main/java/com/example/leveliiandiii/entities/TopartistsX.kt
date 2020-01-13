package com.example.leveliiandiii.entities


import com.google.gson.annotations.SerializedName

data class TopartistsX(
    @SerializedName("artist")
    val artist: List<ArtistX>,
    @SerializedName("@attr")
    val attr: AttrXX
)