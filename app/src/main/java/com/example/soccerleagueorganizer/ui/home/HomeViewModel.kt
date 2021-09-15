package com.example.soccerleagueorganizer.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.soccerleagueorganizer.data.ApiRepository
import com.example.soccerleagueorganizer.data.entity.Team
import com.example.soccerleagueorganizer.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    var savedStateHandle: SavedStateHandle,
    private var apiRepository: ApiRepository
) : ViewModel() {

    var teamList: List<Team> = emptyList()
    fun getTeams(): LiveData<Resource<List<Team>>> =
        apiRepository.getTeams()
}