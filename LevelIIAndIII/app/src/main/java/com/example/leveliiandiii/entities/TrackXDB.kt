package com.example.leveliiandiii.entities


import androidx.room.*
import com.example.leveliiandiii.app.utils.DataConverter
import com.google.gson.annotations.SerializedName

@Entity
data class TrackXDB(
    @Embedded var artist: Artist?,
    @SerializedName("@attr") @Embedded var attr: AttrX?,
    @PrimaryKey var name: String,
    @ColumnInfo(name = "duration") var duration: String?,
    @TypeConverters(DataConverter::class) @ColumnInfo(name = "image") var image: List<Image>?,
    @ColumnInfo(name = "listeners") var listeners: String?,
    @ColumnInfo(name = "mbid") var mbid: String?,
    @Embedded var streamable: Streamable?,
    @ColumnInfo(name = "url") var url: String?
)