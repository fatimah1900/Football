package com.fatimahrizkaw.football.api

import com.fatimahrizkaw.football.common.Constant
import com.fatimahrizkaw.football.data.MatchDetailResponse
import com.fatimahrizkaw.football.data.MatchListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("api/v1/json/${Constant.API_KEY}/{matchType}.php?id=4328")
    suspend fun getMatchList(@Path("matchType") matchType: String): MatchListResponse

    @GET("api/v1/json/${Constant.API_KEY}/lookupevent.php")
    suspend fun getMatchDetail(@Query("id") matchId: String): MatchDetailResponse
}