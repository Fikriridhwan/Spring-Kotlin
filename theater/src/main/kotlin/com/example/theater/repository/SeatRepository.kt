package com.example.theater.repository

import com.example.theater.domain.Seat
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SeatRepository: JpaRepository<Seat, Long>