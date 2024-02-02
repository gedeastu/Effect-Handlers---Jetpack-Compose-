package com.example.effecthandlers.sideEffect

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun SideEffectExample(){
    var state by remember() { mutableIntStateOf(0) }
    val context = LocalContext.current

    SideEffect{
        println(state)
        Toast.makeText(context,"Hello Side Effect with $state",Toast.LENGTH_SHORT).show()
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(modifier = Modifier.clickable {
            state++
        }, text = "Hello Side Effect $state")
    }
}