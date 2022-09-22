package com.example.studiolife.model

import androidx.annotation.DrawableRes

/**
 * A data class to represent the information presented in the question card
 */
data class Question(
//    @DrawableRes val imageResourceId: Int,
    val question: String,
    val input1: String?,
    val input2: String?,
    val input3: String?
)