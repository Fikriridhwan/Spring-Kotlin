package fikri.kotlin.security.repositories

import fikri.kotlin.security.entities.AppUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AppUserRepository: JpaRepository<AppUser,Long>{
    fun findByUsername(prefix: String): AppUser
}