package com.example.theater.service

import com.example.theater.domain.Seat
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class TheaterService {

    private val hiddenSeats = mutableListOf<Seat>()

    constructor() {

        fun getPrice(row: Int, num: Int) : Double {
            return when {
                row >=14 -> 14.50
                num <=3 || num >= 34 -> 16.50
                row == 1 -> 21.0
                else -> 18.0
            }

        }

        fun getDescription(row: Int, num: Int) : String {
            return when {
                row == 15 -> "Back Row"
                row == 14 -> "Cheaper Seat"
                num <=3 || num >= 34 -> "Restricted View"
                row <=2 -> "Best View"
                else -> "Standard Seat"
            }
        }
        var i: Int = 0
        for (row in 1..15) {
            for (num in 1..36) {

                hiddenSeats.add(Seat(i.toLong(),(row+64).toChar(), num, getPrice(row,num), getDescription(row,num) ))
                i++
            }
        }
    }

	val seats
    get() = hiddenSeats.toList()

    fun find(num: Int, row: Char): Seat{
        return seats.filter { it.rowSeat == row && it.numSeat == num }.first()
    }

}
