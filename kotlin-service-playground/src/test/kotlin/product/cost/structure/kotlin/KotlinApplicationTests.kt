package product.cost.structure.kotlin

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import product.cost.structure.kotlin.entity.Course
import product.cost.structure.kotlin.entity.CourseRegistration
import product.cost.structure.kotlin.entity.Student
import product.cost.structure.kotlin.repository.CourseRegistrationRepository
import product.cost.structure.kotlin.repository.CourseRepository
import product.cost.structure.kotlin.repository.StudentRepository
import product.cost.structure.kotlin.service.TestNumericService
import java.math.BigDecimal

@SpringBootTest
class KotlinApplicationTests {

	@Autowired
	lateinit var testNumericService: TestNumericService
	@Autowired
	lateinit var studentRepository: StudentRepository
	@Autowired
	lateinit var courseRepository: CourseRepository
	@Autowired
	lateinit var courseRegistrationRepository: CourseRegistrationRepository

	@Test
	fun contextLoads() {
	}

	@Test
	fun testNyoba(){
//		val student = Student("S1")
//		val course = Course("C1")
//		val courseRegistration = CourseRegistration("CR1", course, student)
//		student.courseRegistration = listOf(courseRegistration)
//		course.courseRegistration = listOf(courseRegizstration)
//		studentRepository.save(student)
//		courseRepository.save(course)
//		courseRegistrationRepository.save(courseRegistration)

//		println(courseRegistrationRepository.findByIdOrNull("CR1").toString())
	}

}
