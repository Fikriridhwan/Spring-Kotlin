package product.cost.structure.kotlin.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import product.cost.structure.kotlin.entity.PriceStructure
import product.cost.structure.kotlin.repository.PriceRepository
import product.cost.structure.kotlin.repository.PriceStructureDetailRepository
import product.cost.structure.kotlin.service.PriceStructureService

@Service
class PriceStructureServiceImpl: PriceStructureService {

    @Autowired
    lateinit var priceStructureDetailRepository: PriceStructureDetailRepository

    override fun create() {
        TODO("Not yet implemented")
    }

    override fun read() {
        TODO("Not yet implemented")
    }

    override fun update() {
        TODO("Not yet implemented")
    }

    override fun delete() {
        TODO("Not yet implemented")
    }
}