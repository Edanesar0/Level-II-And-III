package com.example.leveliiandiii.interfaces

import androidx.room.*
import com.example.leveliiandiii.entities.ArtistXDB

@Dao
interface ArtistXDao {
    @Query("SELECT * FROM artistxdb")
    fun getAll(): List<ArtistXDB>

    @Query("SELECT * FROM artistxdb WHERE name IN (:name)")
    fun findByName(name: String?): List<ArtistXDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg artistX: ArtistXDB)

    @Delete
    fun delete(artistX: ArtistXDB)
}