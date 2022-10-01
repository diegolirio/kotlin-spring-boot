package com.liriotech.purchaseorder.domain.usecases.create.workflow

interface OrderStepExecution<Input> {

    fun doExec(input: Input): Input

    //fun undoExec(input: Input)
}
