package com.example.leveliiandiii.entities


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class Streamable(
    @SerializedName("fulltrack")
    val fulltrack: String,
    @SerializedName("#text")
    val text: String
)