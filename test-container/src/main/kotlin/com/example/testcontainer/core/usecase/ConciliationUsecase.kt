package com.example.testcontainer.core.usecase

import com.example.testcontainer.core.client.CustodyClient
import com.example.testcontainer.core.repository.PositionRepository
import org.springframework.stereotype.Service

@Service
class ConciliationUsecase(
    private val repository: PositionRepository,
    private val client: CustodyClient
) {

    fun conciliationPosition(code: String): Boolean {
        repository.findByCode(code)
            .let {
                val custody = client.getCustody(code)
                if(custody.code != it.code) {
                    return false
                }
                if(custody.quantity != it.quantity) {
                    return false
                }
                if(custody.value != it.value) {
                    return false
                }
                return true
            }
    }

}
