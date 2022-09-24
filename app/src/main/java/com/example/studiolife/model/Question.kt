package com.example.studiolife.model

import android.widget.Button
import androidx.annotation.DrawableRes

/**
 * A data class to represent the information presented in the question card
 */
data class Question(
    @DrawableRes val imageResourceId: Int,
    val question: String,
    var input1: String?,
    var input2: String?,
    var input3: String?,
)