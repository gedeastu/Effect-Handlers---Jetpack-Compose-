package com.example.effecthandlers.snapShotFlow

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.flow.filter

@Composable
fun SnapshotFlowExample(){
    val listState = rememberLazyListState()
    LazyColumn(state = listState){
        items((1..100).toList()){
            Text(text = "Number is $it", fontSize = 35.sp)
        }
    }
    
    LaunchedEffect(key1 = Unit, block = {
        snapshotFlow { listState.firstVisibleItemScrollOffset }
            //Boolean
            //.map {
            //    it > 0
            //}
            //.distinctUntilChanged()

            //Int
            .filter {
                it > 0
            }
            .collect{
                println("The value is $it")
            }
    })

}