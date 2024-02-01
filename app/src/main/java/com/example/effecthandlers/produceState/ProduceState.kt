package com.example.effecthandlers.produceState


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun ProduceState(){
    val number by produceState(initialValue = 5, producer ={
        delay(2000)
        value = Random.nextInt()
        awaitDispose {

        }
    })
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Current Number is $number", fontSize = 35.sp)
    }
}