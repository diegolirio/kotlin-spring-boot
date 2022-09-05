package br.com.kongapp.appstrategy.app.entrypoint.http

import br.com.kongapp.appstrategy.app.providers.strategy.ProviderEnum
import br.com.kongapp.appstrategy.domain.usecases.CreateCustomerUsecase
import br.com.kongapp.appstrategy.domain.usecases.GetCustomerUsecase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerEntrypoint(
    private val getCustomerUsecase : GetCustomerUsecase,
    private val createCustomerUsecase: CreateCustomerUsecase
) {

    @GetMapping
    fun get(@RequestParam("type") type: ProviderEnum) : String {
        return getCustomerUsecase.execute(type)
    }

    @PostMapping
    fun create() {
        return createCustomerUsecase.execute()
    }
}