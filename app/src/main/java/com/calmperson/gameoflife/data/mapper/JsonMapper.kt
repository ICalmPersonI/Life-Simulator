package com.calmperson.gameoflife.data.mapper

import com.calmperson.gameoflife.model.GameRules
import com.calmperson.gameoflife.model.GameSettings
import com.calmperson.gameoflife.model.GameStats
import com.calmperson.gameoflife.model.NeighborhoodType
import com.google.gson.Gson
import com.google.gson.GsonBuilder

object JsonMapper {

    fun GameSettings.toJson(): String {
        return Gson().toJson(this)
    }

    fun GameRules.toJson(): String {
        val map = mapOf(
            "neighborhoodType" to neighborhoodType.toString(),
            "neighborhoodRange" to neighborhoodRange,
            "cellSurvivalRangeFrom" to cellSurvivalRange.first,
            "cellSurvivalRangeTo" to cellSurvivalRange.last,
            "cellRevivalNeighboursCount" to cellRevivalNeighboursCount
        )
        return Gson().toJson(map)
    }

    fun GameStats.toJson(): String {
        return Gson().toJson(this)
    }

    fun <T> fromJson(data: String, clazz: Class<T>): T {
        if (clazz.isAssignableFrom(GameRules::class.java)) {
            val map = Gson().fromJson(data, Map::class.java).map { (key, value) ->
                key to if (value is Double) value.toInt() else value
            }.toMap()
            return GameRules(
                NeighborhoodType.valueOf(map["neighborhoodType"] as String),
                map["neighborhoodRange"] as Int,
                (map["cellSurvivalRangeFrom"] as Int)..(map["cellSurvivalRangeTo"] as Int),
                map["cellRevivalNeighboursCount"] as Int
            ) as T
        }
        return Gson().fromJson(data, clazz)
    }

}