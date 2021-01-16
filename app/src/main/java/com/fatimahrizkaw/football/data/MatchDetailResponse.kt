package com.fatimahrizkaw.football.data

import com.google.gson.annotations.SerializedName

data class MatchDetailResponse(
    @SerializedName("event")
    val event: List<MatchModel> = emptyList()
)