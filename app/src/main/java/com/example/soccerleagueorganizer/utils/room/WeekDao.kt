package com.example.soccerleagueorganizer.utils.room

import androidx.room.*

@Dao
interface WeekDao {
    @Query("SELECT * FROM week")
    fun listWeek(): List<Week>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addWeek(week: Week)

    @Query("SELECT * FROM week WHERE weekId=:weekId LIMIT 1")
    fun getWeekById(weekId: Int): Week

}