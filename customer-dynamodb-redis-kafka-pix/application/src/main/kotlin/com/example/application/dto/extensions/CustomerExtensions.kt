import com.example.application.dataprovider.repository.entity.CustomerEntity
import com.example.application.dto.CustomerRequest
import com.example.application.dto.CustomerResponse
import com.example.domain.vo.Customer

fun CustomerRequest.toCustomerVO(): Customer =
        Customer(
            name = this.name,
            age = this.age
        )

fun Customer.toCustomerResponse(): CustomerResponse =
        CustomerResponse(
            id = this.id,
            name = this.name,
            age = this.age
        )

fun List<Customer>.toCustomersResponse() = this.map { it.toCustomerResponse() }

fun CustomerEntity.toCustomerVO(): Customer =
        Customer(
        id = this.id,
        name = this.name,
        age = this.age
        )

fun List<CustomerEntity>.toCustomersVO(): List<Customer> = this.map { it.toCustomerVO() }