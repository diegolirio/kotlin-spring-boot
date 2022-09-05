package br.com.kongapp.appstrategy.domain.usecases

import br.com.kongapp.appstrategy.app.providers.strategy.ProviderEnum
import br.com.kongapp.appstrategy.domain.providers.GetCustomerProvider
import javax.inject.Named

@Named
class GetCustomerUsecase(
    private val getCustomerProvider : GetCustomerProvider
) {

    fun execute(type: ProviderEnum): String {
        return getCustomerProvider.get(type)
    }

}
