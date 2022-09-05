package br.com.kongapp.appstrategy.app.providers.client

import br.com.kongapp.appstrategy.app.providers.strategy.ProviderEnum
import br.com.kongapp.appstrategy.app.providers.strategy.ProviderType
import org.springframework.stereotype.Component

@Component
class CustomerClient : ProviderType {

    override fun getType(): ProviderEnum = ProviderEnum.PROVIDER_EXTERNAL_SOURCE

    override fun getCustomer(): String {
        return "EXTERNAL_API"
    }
}