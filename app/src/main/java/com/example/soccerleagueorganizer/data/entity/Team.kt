package com.example.soccerleagueorganizer.data.entity

data class Team(
    val code: String,
    val country: String,
    val founded: Int,
    val is_national: Boolean,
    val logo: String,
    val name: String,
    val team_id: Int,
    val venue_address: String,
    val venue_capacity: Int,
    val venue_city: String,
    val venue_name: String,
    val venue_surface: String
)