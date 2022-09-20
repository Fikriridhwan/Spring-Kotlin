package com.example.theater.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "seats")
data class Seat(@Id
                val idSeat: Long,
                val rowSeat: Char,
                val numSeat: Int,
                val priceSeat: Double,
                val description: String) {
    override fun toString(): String = "Seat $rowSeat-$numSeat $priceSeat ($description)"
}