package com.example.leveliiandiii.interfaces

import androidx.room.*
import com.example.leveliiandiii.entities.TrackXDB

@Dao
interface TrackXDao {
    @Query("SELECT * FROM trackxdb")
    fun getAll(): List<TrackXDB>

    @Query("SELECT * FROM trackxdb WHERE rank IN (:name)")
    fun findByName(name: String?): List<TrackXDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg trackX: TrackXDB)

    @Delete
    fun delete(trackX: TrackXDB)
}