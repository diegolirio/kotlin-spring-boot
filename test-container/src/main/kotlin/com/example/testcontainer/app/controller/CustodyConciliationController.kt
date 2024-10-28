package com.example.testcontainer.app.controller

import com.example.testcontainer.core.usecase.ConciliationUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/custody-conciliation")
class CustodyConciliationController(
    private val usecase: ConciliationUsecase,
) {

    @PostMapping("/{code}")
    fun postConciliation(@PathVariable code: String) : ResponseEntity<*> {
        if(usecase.conciliationPosition(code)) {
            return ResponseEntity.ok().body("OK")
        } else {
            return ResponseEntity.badRequest().body("NOK")
        }
    }

}