//package com.liriotech.purchaseorder.domain.usecases.create.workflow
//
//class ContextPayload<T> constructor(var payload: T) {
//
//    private var attributes = mutableMapOf<String, Any>()
//
//    fun addInfo(label: String, value: Any) {
//        attributes.putIfAbsent(label, value)
//    }
//
//    @Suppress("UNCHECKED_CAST")
//    fun <A> getInfo(label: String): A {
//        return attributes[label] as A
//    }
//
//    fun hasInfo(label: String): Boolean {
//        return attributes.containsKey(label)
//    }
//
//    override fun toString(): String {
//        return "payload=$payload"
//    }
//
//}
