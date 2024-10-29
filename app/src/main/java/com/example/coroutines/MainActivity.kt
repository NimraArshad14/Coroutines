package com.example.coroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import kotlin.concurrent.thread



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            BasicLayout()

        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BasicLayout() {
    var data by remember {mutableStateOf(value=0)}
    Column(
        horizontalAlignment= Alignment.CenterHorizontally,
        verticalArrangement= Arrangement.Center,
        modifier = Modifier.fillMaxSize(),
        content = {
            Text(text = "$data")
            Button(
                onClick={
                    thread (true){ for(i in 1..100000L) {
                        if(i == 100000L)
                            data = 100000
                    }
                    }

                    data++},
                content = {
                    Text(text = "data")

                }
            )
        }
    )
}