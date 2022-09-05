package br.com.kongapp.appstrategy.app.providers.h2db

import br.com.kongapp.appstrategy.app.providers.strategy.ProviderEnum
import br.com.kongapp.appstrategy.app.providers.strategy.ProviderType
import org.springframework.stereotype.Component

@Component
class CustomerH2Repository : ProviderType {
    override fun getType(): ProviderEnum = ProviderEnum.PROVIDER_H2_DATABASE

    override fun getCustomer(): String {
        return "H2_DATABASE"
    }
}