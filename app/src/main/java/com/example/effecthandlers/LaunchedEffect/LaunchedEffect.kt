package com.example.effecthandlers.LaunchedEffect

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import com.example.effecthandlers.ui.theme.EffectHandlersTheme
import kotlinx.coroutines.delay

@Composable
fun LaunchedEffectExample(){
    EffectHandlersTheme {
        val number = remember {
            mutableIntStateOf(1)
        }
        LaunchedEffect(key1 = number){
            delay(1000L)
            println("nubmer is ${number.intValue}")
        }
        Button(onClick = {
            number.intValue++
        }) {
            Text(text = number.intValue.toString())
        }
    }
}