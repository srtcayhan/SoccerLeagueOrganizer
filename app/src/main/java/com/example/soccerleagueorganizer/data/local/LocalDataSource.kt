package com.example.soccerleagueorganizer.data.local

import com.example.soccerleagueorganizer.utils.room.Week
import com.example.soccerleagueorganizer.utils.room.WeekDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    val weekDao: WeekDao
) {

    fun listWeek(): List<Week> = weekDao.listWeek()

    fun addWeek(week: Week) {
        weekDao.addWeek(week)
    }

    fun getWeekById(weekId : Int): Week {
        return weekDao.getWeekById(weekId)
    }
}