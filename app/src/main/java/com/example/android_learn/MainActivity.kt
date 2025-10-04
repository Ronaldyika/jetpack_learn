package com.example.android_learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.android_learn.presentation.dashboard.DashboardScreen
import com.example.android_learn.presentation.theme.Android_learnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_learnTheme {
                DashboardScreen()
            }
        }
    }
}

