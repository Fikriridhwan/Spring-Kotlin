package product.cost.structure.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import product.cost.structure.kotlin.entity.PriceStructureDetail

@Repository
interface PriceStructureDetailRepository: JpaRepository<PriceStructureDetail,Int>