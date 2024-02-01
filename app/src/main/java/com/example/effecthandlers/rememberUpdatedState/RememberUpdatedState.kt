package com.example.effecthandlers.rememberUpdatedState

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun RememberUpdatedStateExample(){
    var caller by remember { mutableStateOf(" ") }
    val updateState = rememberUpdatedState(newValue = caller)
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(modifier = Modifier.clickable {
            caller = "astu"
        },text = "Hello ${updateState.value}", color = Color.Cyan)
        Text(modifier = Modifier.clickable {
            caller = "puspita"
        },text = "Hello ${updateState.value}", color = Color.Blue)
    }
    CallTimer(caller = caller)
}

@Composable
fun CallTimer(caller: String){
    println("From the Composable: $caller")
    val updatedCaller by rememberUpdatedState(newValue = caller)
    LaunchedEffect(key1 = Unit, block = {
        println("From the Composable: $caller")
    })
}