package com.example.demovcfunds.controller.handles

import com.example.demovcfunds.controller.handles.exceptions.ValuationInvalidException
import com.example.demovcfunds.entity.Investment

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.IllegalArgumentException

@RestControllerAdvice
class GlobalExceptionsHandles {

    //private val logger: KLogger = KotlinLogging.logger {}

    @ResponseStatus(value = HttpStatus.PRECONDITION_FAILED, reason = "Condition Failed")
    @ExceptionHandler(value = [IllegalArgumentException::class, ValuationInvalidException::class])
    fun preconditionFailed412(ex: Exception): ResponseData {
        return ResponseData(1, ex.message)
    }

}