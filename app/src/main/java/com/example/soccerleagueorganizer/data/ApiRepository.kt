package com.example.soccerleagueorganizer.data

import com.example.soccerleagueorganizer.data.remote.RemoteDataSource
import com.example.soccerleagueorganizer.utils.performNetworkOperation
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private var remoteDataSource: RemoteDataSource
) {

    fun getTeams() = performNetworkOperation {
        remoteDataSource.getTeams()
    }
}