package com.example.android_learn.util

import androidx.compose.ui.graphics.Color
import com.example.android_learn.presentation.theme.Green

enum class Common {
}

enum class Priority(
    val title:String, val color: Color, val value: Int){
    LOW(title = "low", color = Green,value = 0),
    MEDUIM(title = "low", color = Green,value = 0),
    HIGH(title = "low", color = Green,value = 0);

    companion object{
        fun fromInt(value: Int)= values().firstOrNull{it.value==value}?:MEDUIM
    }

}