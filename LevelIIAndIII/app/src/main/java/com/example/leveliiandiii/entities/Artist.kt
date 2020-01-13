package com.example.leveliiandiii.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Artist(
    @SerializedName("mbid")
    @ColumnInfo(name = "mbidArtist") val mbid: String,
    @SerializedName("name")
    @PrimaryKey @ColumnInfo(name = "nameArtist") val name: String,
    @SerializedName("url")
    @ColumnInfo(name = "urlArtist") val url: String
)