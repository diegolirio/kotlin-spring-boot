package com.example.demoreativespring3java21.my

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

data class YoutubeSubscription(
    var subscriber: Subscriber<in String>,
    var videos: MutableList<String>) : Subscription {

    override fun request(size: Long) {
        println("request = unbounded")
        var itens: Int = if(size <= videos.size) size.toInt() else videos.size

        for(i in 0 until itens) {
            subscriber.onNext(videos[i])
        }
        subscriber.onComplete()

    }

    override fun cancel() {
        println("cancel")
    }

}
