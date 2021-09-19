package com.example.soccerleagueorganizer.utils.room

import androidx.room.TypeConverter
import com.example.soccerleagueorganizer.data.entity.Match
import com.google.gson.Gson

class Converter {
    @TypeConverter
    fun listToJson(value: List<Match>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<Match>::class.java).toList()
}