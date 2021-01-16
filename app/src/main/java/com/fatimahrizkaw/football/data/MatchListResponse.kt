package com.fatimahrizkaw.football.data

import com.google.gson.annotations.SerializedName

data class MatchListResponse(
    @SerializedName("events")
    val events: List<MatchModel> = emptyList()
)