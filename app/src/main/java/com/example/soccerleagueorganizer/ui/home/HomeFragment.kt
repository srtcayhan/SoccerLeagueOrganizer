package com.example.soccerleagueorganizer.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.soccerleagueorganizer.R
import com.example.soccerleagueorganizer.data.entity.Team
import com.example.soccerleagueorganizer.databinding.FragmentHomeBinding
import com.example.soccerleagueorganizer.utils.Resource
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class HomeFragment : Fragment(){

    private lateinit var binding : FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    private var teamsAdapter: TeamsListAdapter = TeamsListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.teamsRecyclerView.layoutManager = LinearLayoutManager(context)

        getTeams()

        binding.drawFixtureButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_drawFixtureFragment)
        }
    }

    private fun getTeams() {
        Log.d("Home", "getTeams")
        viewModel.getTeams()
            .observe(viewLifecycleOwner, { response ->

                when (response.status) {
                    Resource.Status.LOADING -> {
                        Log.d("Home", "loading ")
                    }
                    Resource.Status.SUCCESS -> {
                        viewModel.teamList = response.data!!
                        setTeams(viewModel.teamList)
                        Log.d("Home", "teamListSize: " + viewModel.teamList?.size)
                    }
                    Resource.Status.ERROR -> {
                        Log.d("Home", "error: "+response.toString())
                    }
                }

            })
    }


    private fun setTeams(teamList: List<Team>) {

        teamsAdapter.setTeamsList(teamList)
        binding.teamsRecyclerView.adapter = teamsAdapter

    }
}