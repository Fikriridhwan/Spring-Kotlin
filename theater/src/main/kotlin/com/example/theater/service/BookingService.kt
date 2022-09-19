package com.example.theater.service

import com.example.theater.domain.Seat
import org.springframework.stereotype.Service

@Service
class BookingService() {
    fun isSeatFree(seat: Seat): Boolean{
        return true
    }
}