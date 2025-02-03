package com.naps.jetpackcompose

import android.os.Bundle

import com.naps.jetpackcompose.ui.theme.JetpackComposeTheme

import androidx.activity.enableEdgeToEdge
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.naps.jetpackcompose.base.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme { Navigation().Create() }
        }
    }
}



