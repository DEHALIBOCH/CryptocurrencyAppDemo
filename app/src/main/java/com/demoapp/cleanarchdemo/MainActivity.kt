package com.demoapp.cleanarchdemo

import android.os.Bundle
import androidx.compose.material.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import com.demoapp.cleanarchdemo.presentation.ui.theme.CleanArchDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchDemoTheme {
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}