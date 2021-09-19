package com.example.soccerleagueorganizer.data

import com.example.soccerleagueorganizer.data.local.LocalDataSource
import com.example.soccerleagueorganizer.data.remote.RemoteDataSource
import com.example.soccerleagueorganizer.utils.performNetworkOperation
import com.example.soccerleagueorganizer.utils.room.Week
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private var remoteDataSource: RemoteDataSource,
    private var localDataSource: LocalDataSource
) {

    fun getTeams() = performNetworkOperation {
        remoteDataSource.getTeams()
    }

    fun listWeek(): List<Week> {
        return localDataSource.listWeek()
    }

    fun addWeek(week: Week){
        localDataSource.addWeek(week)
    }
    fun getWeekById(weekId : Int): Week {
        return localDataSource.getWeekById(weekId)
    }
}