package com.example.leveliiandiii.app.utils

import androidx.room.TypeConverter
import com.example.leveliiandiii.entities.ImageX
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.lang.reflect.Type

class DataConverterArtist : Serializable {
    @TypeConverter // note this annotation
    fun fromOptionValuesList(optionValues: List<ImageX?>?): String? {
        if (optionValues == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<ImageX?>?>() {}.type
        return gson.toJson(optionValues, type)
    }

    @TypeConverter // note this annotation
    fun toOptionValuesList(optionValuesString: String?): List<ImageX>? {
        if (optionValuesString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<ImageX?>?>() {}.type
        return gson.fromJson<List<ImageX>>(optionValuesString, type)
    }
}