package com.fatimahrizkaw.football.features.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.fatimahrizkaw.football.R
import com.fatimahrizkaw.football.common.Constant
import com.fatimahrizkaw.football.features.favorite.FavoriteFragment
import com.fatimahrizkaw.football.features.listmatch.ListMatchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnMenuSelected()

        showFragment(ListMatchFragment.newInstance(Constant.MatchType.NEXT_MATCH), "Beranda")
    }

    private fun setOnMenuSelected() {
        navHome.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuMatchSchedule -> showFragment(
                    ListMatchFragment.newInstance(Constant.MatchType.NEXT_MATCH),
                    "Beranda"
                )
                R.id.menuMatchHistory -> showFragment(
                    ListMatchFragment.newInstance(Constant.MatchType.PAST_MATCH),
                    "Histori"
                )
                R.id.menuMatchFavorite -> showFragment(FavoriteFragment.newInstance(), "Favorit")
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun showFragment(fragment: Fragment, title: String) {
        this.title = title
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameContainer, fragment)
            .commit()
    }
}