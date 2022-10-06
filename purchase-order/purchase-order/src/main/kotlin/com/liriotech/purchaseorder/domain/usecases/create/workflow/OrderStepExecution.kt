package com.liriotech.purchaseorder.domain.usecases.create.workflow

import reactor.core.publisher.Mono

interface OrderStepExecution<Input> {

    fun doExec(input: Mono<Input>): Mono<Input>

    //fun undoExec(input: Input)
}
