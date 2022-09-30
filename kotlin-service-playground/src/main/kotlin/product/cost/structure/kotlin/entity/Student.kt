package product.cost.structure.kotlin.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Student (
    @Id
    val idStudent: String
)
{
    @OneToMany(mappedBy = "student")
    lateinit var courseRegistration: List<CourseRegistration>
}