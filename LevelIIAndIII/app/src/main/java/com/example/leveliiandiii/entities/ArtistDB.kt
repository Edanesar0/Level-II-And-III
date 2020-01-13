package com.example.leveliiandiii.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArtistDB(
    @ColumnInfo(name = "mbid") val mbid: String,
    @PrimaryKey val name: String,
    @ColumnInfo(name = "url") val url: String
)