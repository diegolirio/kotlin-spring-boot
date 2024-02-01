package com.example.demoreativespring3java21.my

import org.reactivestreams.Publisher
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

class YoutubeChannel(
    var videos: MutableList<String> = ArrayList()
) : Publisher<String> {

    fun addVideo(title: String) {
        this.videos.add(title)
    }

    override fun subscribe(subscriber: Subscriber<in String>) {
        subscriber.onSubscribe(YoutubeSubscription(subscriber, videos))
    }
}

