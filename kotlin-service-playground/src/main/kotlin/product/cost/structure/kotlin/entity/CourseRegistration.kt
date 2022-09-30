package product.cost.structure.kotlin.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class CourseRegistration (
    @Id
    val idCourseRegistration: String,

    @ManyToOne
    val course: Course,

    @ManyToOne
    val student: Student
)