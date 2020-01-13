package com.example.leveliiandiii.entities


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class AttrX(
    @SerializedName("rank")
    val rank: String
)