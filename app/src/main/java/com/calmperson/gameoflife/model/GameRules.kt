package com.calmperson.gameoflife.model


data class GameRules(
    var neighborhoodType: NeighborhoodType,
    var neighborhoodRange: Int,
    var cellSurvivalRange: IntRange,
    var cellRevivalNeighboursCount: Int
)