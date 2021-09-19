package com.example.soccerleagueorganizer.ui.home

import com.example.soccerleagueorganizer.data.entity.Match
import com.example.soccerleagueorganizer.data.entity.Team

fun listMatches(TeamList: List<Team>) : ArrayList<ArrayList<Match>>{
    val listTeam = ArrayList(TeamList)
    if (listTeam.size % 2 != 0) {
        listTeam.add(Team(name="dummy")) // If odd number of teams add a dummy
    }
    val weeks: Int = listTeam.size - 1 // Weeks needed to complete tournament
    val halfSize: Int = listTeam.size / 2
    val teams = arrayListOf<Team>()

    teams.addAll(listTeam)
    teams.removeAt(0)
    // Add teams to List and remove the first team
    val teamsSize: Int = teams.size

    val fixture = ArrayList<ArrayList<Match>>()
    for (week in 0 until weeks) {
        val fixtureMatch = ArrayList<Match>()
        val teamIdx = week % teamsSize
        fixtureMatch.add(Match(teams[teamIdx],listTeam[0]))
        for (idx in 1 until halfSize) {
            val firstTeam = (week + idx) % (teamsSize)
            val secondTeam = (week + teamsSize - idx) % (teamsSize)
            fixtureMatch.add(Match(teams[firstTeam],teams[secondTeam]))
        }
        fixture.add(fixtureMatch)
    }
    return fixture
}

fun listSecondHalf(TeamList: List<Team>) : ArrayList<ArrayList<Match>>{
    val listTeam = ArrayList(TeamList)
    if (listTeam.size % 2 != 0) {
        listTeam.add(Team(name="dummy"))
    }
    val weeks: Int = listTeam.size - 1
    val halfSize: Int = listTeam.size / 2
    val teams = arrayListOf<Team>()

    teams.addAll(listTeam)
    teams.removeAt(0)
    val teamsSize: Int = teams.size

    val fixture = ArrayList<ArrayList<Match>>()
    for (week in 0 until weeks) {
        val fixtureMatch = ArrayList<Match>()
        val teamIdx = week % teamsSize
        fixtureMatch.add(Match(listTeam[0],teams[teamIdx]))
        for (idx in 1 until halfSize) {
            val firstTeam = (week + idx) % (teamsSize)
            val secondTeam = (week + teamsSize - idx) % (teamsSize)
            fixtureMatch.add(Match(teams[secondTeam],teams[firstTeam]))
        }
        fixture.add(fixtureMatch)
    }
    return fixture
}
