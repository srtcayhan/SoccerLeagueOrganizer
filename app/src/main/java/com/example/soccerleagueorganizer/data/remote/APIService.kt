package com.example.soccerleagueorganizer.data.remote

import com.example.soccerleagueorganizer.data.entity.Team
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("Teams")
    suspend fun getTeams(): Response<List<Team>>
}