package com.example.soccerleagueorganizer.data.remote

import com.example.soccerleagueorganizer.utils.BaseDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: APIService
) : BaseDataSource() {
    suspend fun getTeams() = getResult {apiService.getTeams()}
}