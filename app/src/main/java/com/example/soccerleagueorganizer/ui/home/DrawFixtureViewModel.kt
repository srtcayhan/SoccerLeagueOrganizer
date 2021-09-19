package com.example.soccerleagueorganizer.ui.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.soccerleagueorganizer.data.ApiRepository
import com.example.soccerleagueorganizer.utils.room.Week
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DrawFixtureViewModel @Inject constructor(
    var savedStateHandle: SavedStateHandle,
    private var apiRepository: ApiRepository
) : ViewModel() {

    fun listWeek(): List<Week> {
        return apiRepository.listWeek()
    }

}