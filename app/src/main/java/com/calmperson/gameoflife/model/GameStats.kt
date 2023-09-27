package com.calmperson.gameoflife.model

data class GameStats(
    val aliveCells: Int = 0,
    val deadCells: Int = 0,
    val generation: Int = 0,
    val oldestCell: Int = 0,
)