package com.example.application.pix.entrypoint

import com.example.domain.SendPixUseCase
import com.example.domain.vo.Transaction
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pix")
class PixRestController(
        private val sendPixUseCase: SendPixUseCase
) {

    @PostMapping
    fun send(@RequestBody transaction: Transaction) {
        sendPixUseCase.execute(transaction)
    }
}