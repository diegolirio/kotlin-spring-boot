package com.example.demoreativespring3java21.reactor

import reactor.core.publisher.Flux

data class YoutubeChannel(
    var videos: MutableList<Video> = ArrayList()
) {

    fun addVideo(title: Video) {
        this.videos.add(title)
    }

    fun allVideos() : Flux<Video> = Flux.fromIterable(videos)

}