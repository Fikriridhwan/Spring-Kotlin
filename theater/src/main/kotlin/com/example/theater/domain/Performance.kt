package com.example.theater.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "performance")
data class Performance(
    @Id
    val idPeformance: Long,
    val titlePerformance: String)
{
    @OneToMany(mappedBy = "performance")
    lateinit var booking: List<Booking>
}
