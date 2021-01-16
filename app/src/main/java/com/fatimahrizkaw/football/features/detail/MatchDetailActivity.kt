package com.fatimahrizkaw.football.features.detail

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.fatimahrizkaw.football.R
import com.fatimahrizkaw.football.common.Constant
import com.fatimahrizkaw.football.data.MatchModel
import kotlinx.android.synthetic.main.activity_detail.*

class MatchDetailActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val match: MatchModel? = intent.getParcelableExtra(Constant.Key.MATCH)
        if (match != null) {
            showMatchDetail(match)
        } else {
            Toast.makeText(this, "Gagal memuat, coba lagi...", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    private fun showMatchDetail(match: MatchModel) {
        tvDateTime.text = match.dateEvent
        tvHomeTeam.text = match.strHomeTeam
        tvAwayTeam.text = match.strAwayTeam
        tvHomeGoals.text = match.intHomeScore
        tvAwayGoals.text = match.intAwayScore
    }
}