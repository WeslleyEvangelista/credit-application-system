package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Empty inputs not allowed!") val creditValue: BigDecimal,
    @field:Future(message = "Insert a valid date!")
    val dayFirstInstallment: LocalDate,
    @field:NotNull(message = "Empty inputs not allowed!")
    @field:Max(value = 48, message = "Max number of installments: 48")
    val numberOfInstallments: Int,
    @field:NotNull(message = "Empty inputs not allowed!") val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}
