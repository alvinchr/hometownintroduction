package com.example.hometownintroduction

import android.media.browse.MediaBrowser
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.hometownintroduction.ui.theme.HometownintroductionTheme

class VideoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HometownintroductionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    val context = LocalContext.current

    val link = "https://rr1---sn-n4v7sney.googlevideo.com/videoplayback?expire=1682514905&ei=ec9IZN3SD4bEgwP_z45g&ip=198.199.101.47&id=o-AFMTO1XazXDGJpyUxDN98U-CtiyELY0dO5LJnMTKLtcC&itag=22&source=youtube&requiressl=yes&mh=bA&mm=31,26&mn=sn-n4v7sney,sn-a5meknde&ms=au,onr&mv=m&mvi=1&pl=24&initcwndbps=153750&spc=qEK7Bxe6pAcPt19w8JeZ3OnymuyBH0SyNiY-lsFb1w&vprv=1&mime=video/mp4&ns=lJe22_tKQ1V_UeixwhrDQvoN&cnr=14&ratebypass=yes&dur=1610.675&lmt=1669112974556753&mt=1682492945&fvip=4&fexp=24007246&c=WEB_EMBEDDED_PLAYER&txp=5432434&n=NkXTt2kjwQax-dGuN&sparams=expire,ei,ip,id,itag,source,requiressl,spc,vprv,mime,ns,cnr,ratebypass,dur,lmt&sig=AOq0QJ8wRQIgGGhBka8K8un_tPfzTL39EiqfSO5gpW1j00hMqaSbyrICIQCIecR06i4pHrk-weo2j76xL6rFoTsuw5UZEjubQsA8lA==&lsparams=mh,mm,mn,ms,mv,mvi,pl,initcwndbps&lsig=AG3C_xAwRQIga9lr8mgWr8iV7IdS7ph_gtFwtcWE3H7Ml37VyOfFBz4CIQDgvAjCENxM1aHWjRue5u4RI0s7TVxbYw1ZHmApEKNJjw==&title=%E9%80%99%E8%B6%9F%E5%B3%87%E9%87%8C%E5%B3%B6%E6%9C%80%E7%BE%8E%E7%9A%84%E7%95%AB%E9%9D%A2%E3%80%8E%E9%A8%8E%E9%A6%AC%E5%BE%9C%E5%BE%89%E5%9C%A8%E7%A7%81%E4%BA%BA%E6%B5%B7%E7%81%98%E3%80%8F%EF%BC%8C%E9%82%84%E6%9C%89%E7%B5%95%E7%BE%8E%E7%80%91%E5%B8%83%E3%80%81Eco%E7%AB%B9%E5%AD%90%E5%B1%8B%E9%A3%AF%E5%BA%97%EF%BC%8C%E4%BD%A0%E7%B5%95%E5%B0%8D%E4%B8%8D%E8%83%BD%E9%8C%AF%E9%81%8E"
    val exoPlayer = ExoPlayer.Builder(context).build()
    val mediaItem = MediaItem.fromUri(android.net.Uri.parse(link))
    exoPlayer.setMediaItem(mediaItem)
    val playerView = PlayerView(context)
    playerView.player = exoPlayer

    DisposableEffect(AndroidView(factory = {playerView})){
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true

        onDispose{
            exoPlayer.release()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    HometownintroductionTheme {
        Greeting2("Android")
    }
}