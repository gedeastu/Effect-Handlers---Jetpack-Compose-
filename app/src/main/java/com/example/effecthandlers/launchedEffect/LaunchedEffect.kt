package com.example.effecthandlers.launchedEffect

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun LaunchedEffectExample(){
    var state by remember { mutableStateOf(true) }
    val context = LocalContext.current

    //with state, when clicked it will show toast one more time, if do it again the toast will not showing
    LaunchedEffect(key1 = state,){
        //delay(1000L)
        Toast.makeText(context,"Hello with State", Toast.LENGTH_LONG).show()
    }

    //with Unit, when launched the app the toast will showing in once time
    LaunchedEffect(key1 = Unit,){
        Toast.makeText(context,"Hello with Unit", Toast.LENGTH_LONG).show()
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(modifier = Modifier.clickable {
                                           state = false
        },text = "Hello What's Up $state", style = TextStyle(fontSize = 30.sp))
    }
}