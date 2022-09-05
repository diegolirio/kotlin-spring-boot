package br.com.kongapp.appstrategy.app.providers.strategy

import org.springframework.stereotype.Component

@Component
class ProviderStrategy(
    private val providerTypes : List<ProviderType>
) {

    fun get(providerEnum: ProviderEnum) : ProviderType {
        return providerTypes.stream().filter {
                it.getType() == providerEnum
            }
            .findFirst()
            .orElseThrow { IllegalStateException("Provider is not valid $providerEnum") }
    }
}
