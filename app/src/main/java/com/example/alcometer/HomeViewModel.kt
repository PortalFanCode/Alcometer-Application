package com.example.alcometer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    var weightInput by mutableStateOf("")
    private val weight: Int
        get() {
            return weightInput.toIntOrNull() ?: 0
        }

    var male by mutableStateOf(true)

    var bottlesInput by mutableStateOf("")
    private var bottles: Int = 0
        get() {
            return bottlesInput.toIntOrNull() ?: 0
        }

    fun addBottleInput(add: Boolean) {
        val bottlesTemp = bottlesInput.toIntOrNull() ?: 0
        if (add) bottlesInput = (bottlesTemp + 1).toString()
        else bottlesInput = (bottlesTemp - 1).toString()
    }

    var hoursInput by mutableStateOf("")
    private var hours: Int = 0
        get() {
            return hoursInput.toIntOrNull() ?: 0
        }

    fun addHourInput(add: Boolean) {
        val hoursTemp = hoursInput.toIntOrNull() ?: 0
        if (add) hoursInput = (hoursTemp + 1).toString()
        else hoursInput = (hoursTemp - 1).toString()
    }

    fun calculate() {
        val liters: Float = bottles * 0.33f
        val grams: Float = liters * 8f * 4.5f
        val burning: Float = weight / 10f
        val gramsLeft: Float = grams - (burning * hours)
        val resultTemp: Float = if (male) (gramsLeft / (weight * 0.7)).toFloat()
        else (gramsLeft / (weight * 0.6)).toFloat()
        result = if (resultTemp <= 0f) "Invalid result"
        else resultTemp.round(2).toString()
    }

    var result by mutableStateOf("")

    private fun Float.round(decimals: Int): Float {
        var multiplier = 1.0f
        repeat(decimals) { multiplier *= 10 }
        return kotlin.math.round(this * multiplier) / multiplier
    }

}