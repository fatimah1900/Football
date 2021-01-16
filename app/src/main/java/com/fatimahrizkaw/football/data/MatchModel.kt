package com.fatimahrizkaw.football.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

@Parcelize
data class MatchModel(
    @SerializedName("idEvent")
    val idEvent: String? = null,
    @SerializedName("idHomeTeam")
    val idHomeTeam: String? = null,
    @SerializedName("idAwayTeam")
    val idAwayTeam: String? = null,
    @SerializedName("strHomeTeam")
    val strHomeTeam: String? = null,
    @SerializedName("strAwayTeam")
    val strAwayTeam: String? = null,
    @SerializedName("intHomeScore")
    val intHomeScore: String? = null,
    @SerializedName("intAwayScore")
    val intAwayScore: String? = null,
    @SerializedName("dateEvent")
    val dateEvent: String? = null,
    @SerializedName("strTime")
    val strTime: String? = null
): Parcelable {

    fun getWibTimeZone(strTime: String): String {
        return try {
            val sdf = SimpleDateFormat("HH:mm:ssX", Locale.getDefault())
            val newTime = sdf.parse(strTime) ?: strTime
            val newSdf = SimpleDateFormat("HH:mm", Locale.getDefault())
            newSdf.format(newTime)
        } catch (e: ParseException) {
            try {
                val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
                val newTime = sdf.parse(strTime) ?: strTime
                val newSdf = SimpleDateFormat("HH:mm", Locale.getDefault())
                newSdf.format(newTime)
            } catch (e: ParseException) {
                strTime
            }
        }
    }
}