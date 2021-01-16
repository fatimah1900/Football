package com.fatimahrizkaw.football.features.listmatch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fatimahrizkaw.football.R
import com.fatimahrizkaw.football.data.MatchModel
import kotlinx.android.synthetic.main.item_match.view.*

class MatchAdapter(
    private val onClick: (MatchModel) -> Unit
) : RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    var listMatch: List<MatchModel> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_match, parent, false)
        return MatchViewHolder(view)
    }

    override fun getItemCount(): Int = listMatch.size

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val match = listMatch[position]
        val itemView = holder.itemView
        itemView.tvDateTime.text = match.dateEvent
        itemView.tvJam.text = match.strTime
        itemView.tvHomeTeam.text = match.strHomeTeam
        itemView.tvAwayTeam.text = match.strAwayTeam
        itemView.tvHomeScore.text = match.intHomeScore ?: "?"
        itemView.tvAwayScore.text = match.intAwayScore ?: "?"
        itemView.setOnClickListener {
            onClick(match)
        }
    }

    inner class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}