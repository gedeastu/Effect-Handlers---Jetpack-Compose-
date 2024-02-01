package com.example.effecthandlers.rememberCoroutineScope

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RememberCoroutineScope(name: MutableState<String>){
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){

        //Example 1
        val scope = rememberCoroutineScope()
        Box(modifier = Modifier.width(200.dp).height(200.dp), contentAlignment = Alignment.Center) {
            Button(onClick = {
                scope.launch {
                    delay(1000L)
                    name.value = "Thank you"
                }
            }) {
                Text(text = name.value)
            }
        }


        //Example 2
        var state by remember() { mutableIntStateOf(0) }
        val context = LocalContext.current
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(modifier = Modifier.clickable {
                scope.launch {
                    delay(200L)
                    state++
                }
            }, text = "Hello Disposable $state")
        }
    }
}