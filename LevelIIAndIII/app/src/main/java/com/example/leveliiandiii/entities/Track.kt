package com.example.leveliiandiii.entities


import com.google.gson.annotations.SerializedName

data class Track(
    @SerializedName("tracks")
    val tracks: Tracks
)