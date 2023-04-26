package com.example.hometownintroduction

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.hometownintroduction.ui.theme.HometownintroductionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HometownintroductionTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var msg = remember { mutableStateOf("行動應用軟體開發") }
    var scenicspot = arrayListOf(
        R.drawable.jingdian1, R.drawable.jingdian2,
        R.drawable.jingdian3, R.drawable.jingdian4,
        R.drawable.jingdian5
    )

    var places = arrayListOf("巴厘島", "雙桅帆船", "科莫多島", "印尼國家紀念塔", "營多麵")
    val context = LocalContext.current
    var mper = MediaPlayer()



    Column {
        Button(onClick = {
            mper.reset()
            context.startActivity(Intent(context, VideoActivity::class.java))
        })
        {
            Text(text = "印尼景點精選")
        }

        LazyColumn {
            items(5) { index ->
                Text(text = places[index % 5])
                Image(
                    painter = painterResource(id = scenicspot[index % 5]),
                    contentDescription = "手掌圖片"
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HometownintroductionTheme {
        Greeting("Android")
    }
}