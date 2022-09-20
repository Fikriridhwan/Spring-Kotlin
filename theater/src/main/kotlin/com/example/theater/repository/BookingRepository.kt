package com.example.theater.repository

import com.example.theater.domain.Booking
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookingRepository: JpaRepository<Booking, Long>