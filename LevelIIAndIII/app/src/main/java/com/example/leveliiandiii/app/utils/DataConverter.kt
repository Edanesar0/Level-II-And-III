package com.example.leveliiandiii.app.utils

import androidx.room.TypeConverter
import com.example.leveliiandiii.entities.Image
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.lang.reflect.Type

class DataConverter : Serializable {
    @TypeConverter // note this annotation
    fun fromOptionValuesList(optionValues: List<Image?>?): String? {
        if (optionValues == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Image?>?>() {}.type
        return gson.toJson(optionValues, type)
    }

    @TypeConverter // note this annotation
    fun toOptionValuesList(optionValuesString: String?): List<Image>? {
        if (optionValuesString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Image?>?>() {}.type
        return gson.fromJson<List<Image>>(optionValuesString, type)
    }
}