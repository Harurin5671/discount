package com.crowns.discountapp.viewModels

import androidx.lifecycle.ViewModel

class CalculateViewModel1 : ViewModel() {

    fun calculate(price: String, discount: String): Pair<Double, Pair<Double, Boolean>> {
        var priceDiscount = 0.0
        var totalDiscount = 0.0
        var showAlert = false
        if (price != "" && discount != "") {
            priceDiscount = calculatePrice(price.toDouble(), discount.toDouble())
            totalDiscount = calculateDiscount(price.toDouble(), discount.toDouble())
        } else {
            showAlert = true
        }
        return Pair(priceDiscount, Pair(totalDiscount, showAlert))
    }

    private fun calculatePrice(price: Double, discount: Double): Double {
        val res = price - calculateDiscount(price, discount)
        return kotlin.math.round(res * 100) / 100.0
    }

    private fun calculateDiscount(price: Double, discount: Double): Double {
        val res = price * (1 - discount / 100)
        return kotlin.math.round(res * 100) / 100.0
    }
}