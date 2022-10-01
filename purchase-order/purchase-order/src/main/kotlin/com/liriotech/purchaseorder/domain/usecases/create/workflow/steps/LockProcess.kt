package com.liriotech.purchaseorder.domain.usecases.create.workflow.steps

import com.fasterxml.jackson.databind.ObjectMapper

class LockProcess private constructor() {

    // TODO
    //  Reading -> https://proandroiddev.com/synchronization-and-thread-safety-techniques-in-java-and-kotlin-f63506370e6d

    companion object {

        private var map = HashMap<String, String>()

        @Synchronized
        fun lock(key: String, value: Any): Pair<Boolean, Any> {
            if (map[key] != null) {
                return Pair(false, "Already exists")
            }
            map[key] = ObjectMapper().writeValueAsString(value)
            return Pair(true, value)
        }

        @Synchronized
        fun <T : Any> unlock(key: String, clazz: Class<T>): Pair<Boolean, Any> {
            if (map[key] == null) {
                return Pair(false, "It is not exists")
            }
            val value = map[key]
            map.remove(key)
            return Pair(true, ObjectMapper().readValue(value, clazz))
        }

        fun validate(key: String): Boolean = map[key] != null
    }

}