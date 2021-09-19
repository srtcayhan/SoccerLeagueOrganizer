package com.example.soccerleagueorganizer.ui.home
import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerleagueorganizer.databinding.ItemViewPagerBinding
import com.example.soccerleagueorganizer.utils.room.Week

class ViewPagerAdapter(
    val weeks: List<Week>
    ) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(val binding:ItemViewPagerBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val binding = ItemViewPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewPagerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return weeks.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val week = weeks[position]
        val matchList = week.matchesInWeek as ArrayList
        matchList.removeAll {
            item -> item.home.name == "dummy" || item.away.name == "dummy"
        }
        val adapter = MatchesAdapter(matchList)
        holder.binding.apply {
            weekTextView.text = "Week : " + (week.weekId + 1).toString()
            matchesRecyclerView.adapter = adapter
            matchesRecyclerView.layoutManager = LinearLayoutManager(matchesRecyclerView.context)
        }

    }
}