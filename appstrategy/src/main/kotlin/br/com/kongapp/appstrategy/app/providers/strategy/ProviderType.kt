package br.com.kongapp.appstrategy.app.providers.strategy

interface ProviderType {

    fun getType() : ProviderEnum
    fun getCustomer(): String

}
