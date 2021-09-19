package com.example.soccerleagueorganizer.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soccerleagueorganizer.data.entity.Team
import com.example.soccerleagueorganizer.databinding.TeamCardBinding

class TeamsListAdapter : RecyclerView.Adapter<TeamsListAdapter.TeamsViewHolder>() {

    private var teamsList = emptyList<Team>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        val binding = TeamCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        val team = teamsList[position]

        Glide.with(holder.binding.teamLogo.context)
            .load(team.logo)
            .thumbnail(0.5f)
            .into(holder.binding.teamLogo)
        holder.binding.teamName.text = team.name
        holder.binding.venueCity.text = team.venue_city

    }

    override fun getItemCount(): Int = teamsList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setTeamsList(teams: List<Team>) {
            teamsList = teams
            notifyDataSetChanged()
    }

    inner class TeamsViewHolder(val binding: TeamCardBinding) :
        RecyclerView.ViewHolder(binding.root)
}
