package com.example.soccerleagueorganizer.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soccerleagueorganizer.data.entity.Match
import com.example.soccerleagueorganizer.databinding.MatchCardBinding

class MatchesAdapter(
    private val matches: List<Match>
): RecyclerView.Adapter<MatchesAdapter.MatchesViewHolder>(){

    inner class MatchesViewHolder(val binding: MatchCardBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesViewHolder{
        val binding = MatchCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return matches.size
    }

    override fun onBindViewHolder(holder: MatchesViewHolder, position: Int) {
        val match = matches[position]

        holder.binding.apply {
            teamAwayName.text = match.away.name
            Glide.with(teamAwayLogo.context)
                .load(match.away.logo)
                .into(teamAwayLogo)
            teamHomeName.text = match.home.name
            Glide.with(teamHomeLogo.context)
                .load(match.home.logo)
                .into(teamHomeLogo)
        }

    }
}
