package com.example.effecthandlers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.effecthandlers.DisposableEffect.DisposableEffectExample
import com.example.effecthandlers.ui.theme.EffectHandlersTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EffectHandlersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    //RememberCoroutineScope(name = remember {
                    //    mutableStateOf("Click me")
                    //})

                    //LaunchedEffectExample()

                    DisposableEffectExample()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//State Increament
@Composable
fun StateIncreament(number: MutableState<Int>){
    EffectHandlersTheme {
        LaunchedEffect(key1 = number){
            delay(1000L)
            println("numer is ${number.value}")
        }
        Button(onClick = {
            number.value++
        }) {
            Text(text = number.value.toString())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EffectHandlersTheme {
        Greeting("Android")
    }
}