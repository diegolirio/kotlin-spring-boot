package com.example.demoreativespring3java21.my

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

data class User(
    var name: String
) : Subscriber<String> {

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

    override fun onNext(video: String?) {
        println("onNext $video")
    }
}