package com.example.leveliiandiii.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.leveliiandiii.app.utils.DataConverterArtist

@Entity
data class ArtistXDB(
    @PrimaryKey val name: String,
    @TypeConverters(DataConverterArtist::class) @ColumnInfo(name = "image") val image: List<ImageX>,
    @ColumnInfo(name = "listeners") val listeners: String?,
    @ColumnInfo(name = "mbid") val mbid: String?,
    @ColumnInfo(name = "streamable") val streamable: String?,
    @ColumnInfo(name = "url") val url: String?


)