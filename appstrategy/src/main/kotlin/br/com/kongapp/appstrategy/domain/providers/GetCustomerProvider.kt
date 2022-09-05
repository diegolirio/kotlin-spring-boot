package br.com.kongapp.appstrategy.domain.providers

import br.com.kongapp.appstrategy.app.providers.strategy.ProviderEnum

interface GetCustomerProvider {

    fun get(type: ProviderEnum): String

}
