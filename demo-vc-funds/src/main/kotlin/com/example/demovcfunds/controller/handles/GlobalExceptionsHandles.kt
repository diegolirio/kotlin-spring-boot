package com.example.demovcfunds.controller.handles

import com.example.demovcfunds.controller.handles.exceptions.OperatingTimeInvalidException
import com.example.demovcfunds.controller.handles.exceptions.ValuationInvalidException
import com.example.demovcfunds.controller.handles.exceptions.ValueToInvestInvalidException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionsHandles {

    //private val logger: KLogger = KotlinLogging.logger {}

    @ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
    @ExceptionHandler(value = [
        IllegalArgumentException::class,
        ValuationInvalidException::class,
        OperatingTimeInvalidException::class,
        ValueToInvestInvalidException::class,
    ])
    fun preconditionFailed412(ex: Exception): ResponseData {
        return ResponseData(code = 1, message = ex.message!!)
    }


}