package com.example.effecthandlers.DisposableEffect

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

@Composable
fun DisposableEffectExample(){

    //Example 1
    val lifecyleOwner = LocalLifecycleOwner.current
    DisposableEffect(key1 = lifecyleOwner,){
        val observer = LifecycleEventObserver{_,event->
            if (event == Lifecycle.Event.ON_PAUSE){
                println("On pause called")
            }
        }
        lifecyleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecyleOwner.lifecycle.removeObserver(observer)
        }
    }


    //Example 2 ( i'am not sure )
    var state by remember() {
        mutableStateOf(true)
    }
    val context = LocalContext.current

    DisposableEffect(key1 = Unit,){
        Toast.makeText(context, "Hello World", Toast.LENGTH_SHORT).show()
        onDispose {

        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Text(modifier = Modifier.clickable {
            state = false
            Toast.makeText(context,"Hello Disposable ",Toast.LENGTH_LONG).show()
        }, text = "Hello Disposable $state")
    }
}