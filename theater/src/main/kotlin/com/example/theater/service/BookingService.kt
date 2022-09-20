package com.example.theater.service

import com.example.theater.domain.Booking
import com.example.theater.domain.Performance
import com.example.theater.domain.Seat
import com.example.theater.repository.BookingRepository
import com.example.theater.repository.SeatRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookingService() {
    @Autowired
    lateinit var bookingRepository: BookingRepository
    @Autowired
    lateinit var seatRepository: SeatRepository

    fun isSeatFree(seat: Seat, performance: Performance): Boolean{
//        val bookings = bookingRepository.findAll()
//        val result = bookings.filter { it.seat == seat && it.performance == performance }
        val result = findBooking(seat, performance)
        return result == null
    }

    fun findSeat(seatNum: Int, seatRow: Char): Seat?{
        val listSeat = seatRepository.findAll()
        val foundSeat = listSeat.filter { it.numSeat == seatNum && it.rowSeat == seatRow }
        return foundSeat.firstOrNull()
    }

    fun reserveSeat(seat: Seat, performance: Performance, customerName: String): Booking {
        val listBooking = bookingRepository.findAll()
        val booking = Booking(listBooking.size.toLong(),customerName)
        booking.seat = seat
        booking.performance = performance
        bookingRepository.save(booking)
        return booking
    }

    fun findBooking(seat: Seat, performance: Performance): Booking? {
        val listBooking = bookingRepository.findAll()
        val foundBooked = listBooking.filter { it.seat == seat && it.performance == performance }
        return foundBooked.firstOrNull()
    }
}