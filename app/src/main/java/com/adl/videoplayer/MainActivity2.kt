package com.adl.videoplayer

import android.os.Bundle
import android.util.SparseArray
import androidx.appcompat.app.AppCompatActivity
import at.huber.youtubeExtractor.VideoMeta
import at.huber.youtubeExtractor.YouTubeExtractor
import at.huber.youtubeExtractor.YtFile


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val youtubeLink = "https://www.youtube.com/watch?v=8R9ZLs53feE"

        var link = object: YouTubeExtractor(this){
            override fun onExtractionComplete(
                ytFiles: SparseArray<YtFile>?,
                videoMeta: VideoMeta?
            ) {
                if (ytFiles != null) {
                    val itag = 22
                    val downloadUrl = ytFiles[itag].url
                }
            }

        }.extract(youtubeLink,true,true)


    }


}