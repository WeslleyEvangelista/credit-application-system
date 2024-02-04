package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "Empty Inputs not allowed!") val firstName: String,
    @field:NotEmpty(message = "Empty Inputs not allowed!") val lastName: String,
    @field:NotEmpty(message = "Empty Inputs not allowed!")
    @field:CPF(message = "Invalid CPF!")
    val cpf: String,
    @field:NotNull(message = "Empty inputs not allowed!") val income: BigDecimal,
    @field:NotEmpty(message = "Empty Inputs not allowed!")
    @field:Email(message = "Invalid e-mail!")
    val email: String,
    @field:NotEmpty(message = "Empty Inputs not allowed!") var password: String,
    @field:NotEmpty(message = "Empty Inputs not allowed!") var zipCode: String,
    @field:NotEmpty(message = "Empty Inputs not allowed!") var street: String
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )

}
