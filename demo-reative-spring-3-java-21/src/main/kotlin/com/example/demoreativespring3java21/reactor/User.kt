package com.example.demoreativespring3java21.reactor

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

data class User(
    val name: String
) : Subscriber<Video> {


    override fun onSubscribe(subscription: Subscription) {
        println("onSubscribe $name")
        subscription.request(Long.MAX_VALUE)
    }

    override fun onError(t: Throwable?) {
        println("onError " + t?.message)
    }

    override fun onComplete() {
        println("onComplete")
    }

    override fun onNext(video: Video) {
        println("onNext $video")
    }
}