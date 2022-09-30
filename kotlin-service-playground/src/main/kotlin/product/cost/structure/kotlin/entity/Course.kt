package product.cost.structure.kotlin.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Course (
    @Id
    val idCourse: String
)
{
    @OneToMany(mappedBy = "course")
    lateinit var courseRegistration: List<CourseRegistration>
}