package com.example.theater.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "booking")
data class Booking(
    @Id
    val idBooking: Long,
    val customerName: String)
{
    @ManyToOne
    lateinit var seat: Seat

    @ManyToOne
    lateinit var performance: Performance
}