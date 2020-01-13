package com.example.leveliiandiii.app.utils

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.leveliiandiii.entities.ArtistXDB
import com.example.leveliiandiii.entities.TrackXDB
import com.example.leveliiandiii.interfaces.ArtistXDao
import com.example.leveliiandiii.interfaces.TrackXDao

@Database(entities = [ArtistXDB::class, TrackXDB::class], version = 1)
@TypeConverters(value = [DataConverter::class, DataConverterArtist::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun artistXDao(): ArtistXDao
    abstract fun trackXDao(): TrackXDao
}