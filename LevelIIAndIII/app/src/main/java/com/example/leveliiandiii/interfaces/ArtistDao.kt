package com.example.leveliiandiii.interfaces

import androidx.room.*
import com.example.leveliiandiii.entities.ArtistDB

@Dao
interface ArtistDao {
    @Query("SELECT * FROM artistdb")
    fun getAll(): List<ArtistDB>

    @Query("SELECT * FROM artistdb WHERE name IN (:name)")
    fun findByName(name: String): List<ArtistDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg artists: ArtistDB)

    @Delete
    fun delete(artist: ArtistDB)
}