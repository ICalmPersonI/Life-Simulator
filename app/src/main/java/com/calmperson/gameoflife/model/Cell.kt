package com.calmperson.gameoflife.model

import java.io.Serializable

data class Cell(var isAlive: Boolean, var age: Int) : Serializable
