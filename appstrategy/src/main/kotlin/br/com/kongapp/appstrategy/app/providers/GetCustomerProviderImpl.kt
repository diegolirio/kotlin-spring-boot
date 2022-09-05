package br.com.kongapp.appstrategy.app.providers

import br.com.kongapp.appstrategy.app.providers.strategy.ProviderEnum
import br.com.kongapp.appstrategy.app.providers.strategy.ProviderStrategy
import br.com.kongapp.appstrategy.domain.providers.GetCustomerProvider
import org.springframework.stereotype.Component

@Component
class GetCustomerProviderImpl(
    private val providerStrategy: ProviderStrategy
) : GetCustomerProvider {

    override fun get(type: ProviderEnum): String {
        return providerStrategy.get(type).getCustomer()
    }


}