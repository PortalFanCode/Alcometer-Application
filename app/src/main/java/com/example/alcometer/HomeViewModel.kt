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
        if (male) resultFloat = (gramsLeft / (weight * 0.7)).toFloat()
        else resultFloat = (gramsLeft / (weight * 0.6)).toFloat()
    }

    var resultFloat: Float by mutableStateOf(0f)

    var result: String = ""
        get() {
            var valid = true
            if (weight <= 0) valid = false
            if (bottles <= 0) valid = false
            if (hours <= 0) valid = false
            if (resultFloat <= 0f) valid = false
            return if (valid) resultFloat.toString() else "Invalid parameters"
        }
}