package com.example.soccerleagueorganizer.utils.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.soccerleagueorganizer.data.entity.Match

@Entity
data class Week(
    @PrimaryKey var weekId: Int,
    @ColumnInfo(name = "Matches") var matchesInWeek: List<Match>
)