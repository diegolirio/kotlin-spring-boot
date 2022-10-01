package com.liriotech.purchaseorder.domain.usecases.create.workflow.steps.exception

import java.lang.RuntimeException

class StopStepExecption : RuntimeException {

    private var context: Any? = null

    constructor(context: Any): super() {
        this.context = context
    }

    constructor():super()

}
