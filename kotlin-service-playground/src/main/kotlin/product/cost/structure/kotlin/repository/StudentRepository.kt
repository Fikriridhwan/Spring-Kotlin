package product.cost.structure.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import product.cost.structure.kotlin.entity.Student

@Repository
interface StudentRepository :JpaRepository<Student,String>