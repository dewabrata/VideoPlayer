package com.adl.videoplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.BandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val url:String = "rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mp4"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bandwithMeter :BandwidthMeter = DefaultBandwidthMeter()

        var videoTrackSelectionFactory = AdaptiveTrackSelection.Factory()

        var trackSelector = DefaultTrackSelector(videoTrackSelectionFactory)

        var player =  SimpleExoPlayer.Builder(this)
            .setTrackSelector(trackSelector)
            .build()

        videoPlayer.setPlayer(player)

        val mediaSource: MediaSource = RtspMediaSource.Factory()
            .createMediaSource(MediaItem.fromUri(url))



        player.setMediaSource(mediaSource)

        player.prepare()





    }
}