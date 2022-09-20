package com.example.theater.repository

import com.example.theater.domain.Performance
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PerformanceRepository: JpaRepository<Performance, Long> {
}