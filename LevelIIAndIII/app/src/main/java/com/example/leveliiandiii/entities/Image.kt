package com.example.leveliiandiii.entities


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class Image(
    @SerializedName("size")
    val size: String,
    @SerializedName("#text")
    val text: String?
)