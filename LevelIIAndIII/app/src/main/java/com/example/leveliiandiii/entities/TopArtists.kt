package com.example.leveliiandiii.entities


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "TopArtists")
data class TopArtists(
    @SerializedName("topartists")
    val topartists: TopartistsX
)