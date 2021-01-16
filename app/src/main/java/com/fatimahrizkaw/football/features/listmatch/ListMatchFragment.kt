package com.fatimahrizkaw.football.features.listmatch

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatimahrizkaw.football.R
import com.fatimahrizkaw.football.api.NetworkConfig
import com.fatimahrizkaw.football.common.Constant
import com.fatimahrizkaw.football.features.detail.MatchDetailActivity
import kotlinx.android.synthetic.main.fragment_list_match.view.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class ListMatchFragment : Fragment(), CoroutineScope {

    companion object {
        private const val MATCH_TYPE = "matchType"

        fun newInstance(matchType: String): ListMatchFragment {
            return ListMatchFragment().apply {
                arguments = Bundle().apply {
                    putString(MATCH_TYPE, matchType)
                }
            }
        }
    }

    private val apiService = NetworkConfig.getApiService()
    private var listAdapter = MatchAdapter {
        val intent = Intent(requireContext(), MatchDetailActivity::class.java)
        intent.putExtra(Constant.Key.MATCH, it)
        startActivity(intent)
    }
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(view) {
            listMatch.layoutManager = LinearLayoutManager(context)
            listMatch.adapter = listAdapter
        }

        val matchType = arguments?.getString(MATCH_TYPE) ?: Constant.MatchType.NEXT_MATCH
        getMatchList(matchType)
    }

    private fun getMatchList(matchType: String) {
        view?.loadingView?.visibility = View.VISIBLE
        launch {
            try {
                val matchList = apiService.getMatchList(matchType).events
                withContext(Dispatchers.Main) {
                    view?.loadingView?.visibility = View.GONE
                    listAdapter.listMatch = matchList
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    view?.loadingView?.visibility = View.GONE
                    Toast.makeText(
                        requireContext(),
                        "Gagal Memuat, coba lagi...",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}