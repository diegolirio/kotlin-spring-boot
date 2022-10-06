package com.liriotech.purchaseorder.domain.usecases.create.workflow

import org.slf4j.LoggerFactory
import reactor.core.publisher.Mono

class OrderExecutorChain<Input> private constructor() {

    private val log = LoggerFactory.getLogger(this::class.java)

    private lateinit var finallyStep: OrderStepExecution<Input>

    private val executors = mutableListOf<OrderStepExecution<Input>>()

    // TODO Why?
    private val executedSteps = mutableMapOf<Int, Pair<OrderStepExecution<Input>, Input>>()

    companion object {
        fun <Input> begin(step: OrderStepExecution<Input>): OrderExecutorChain<Input> {
            val executorChain = OrderExecutorChain<Input>()
            executorChain.initialStep(step)
            return executorChain
        }

    }

    private fun initialStep(step: OrderStepExecution<Input>): OrderExecutorChain<Input>  {
        return addStep(step)
    }

    private fun addStep(step: OrderStepExecution<Input>): OrderExecutorChain<Input>  {
        executors.add(step)
        return this
    }

    fun and(step: OrderStepExecution<Input>): OrderExecutorChain<Input> {
        return addStep(step)
    }

    fun doFinally(finalStep: OrderStepExecution<Input>): OrderExecutorChain<Input> {
        this.finallyStep = finalStep
        return this
    }


    fun apply(originalValue: Mono<Input>): Mono<Input> {
        val value: Mono<Input> = originalValue
        log.info("m=apply, message=It is starting execute the Order workflow, input=$originalValue ")
        try {
            executors.forEach {
                log.info("m=apply, step=$it")
                it.doExec(input = originalValue)
            }
        } finally {
            log.info("m=apply, step=$finallyStep")
            finallyStep.doExec(input = originalValue)
        }
        log.info("m=apply, message=Finished the workflow execution, input=$originalValue ")
        return value
    }

}