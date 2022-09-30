package product.cost.structure.kotlin.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import product.cost.structure.kotlin.entity.TestNumeric
import product.cost.structure.kotlin.repository.TestNumericRepository
import java.math.BigDecimal
import java.math.RoundingMode

@Service
class TestNumericService {

    @Autowired
    lateinit var testNumericRepository: TestNumericRepository

    fun createTestNumeric(value: BigDecimal) {
        val testNumeric = TestNumeric(0,value.setScale(6,RoundingMode.FLOOR),BigDecimal(2))
        testNumericRepository.save(testNumeric)
        println(testNumeric)
    }
}