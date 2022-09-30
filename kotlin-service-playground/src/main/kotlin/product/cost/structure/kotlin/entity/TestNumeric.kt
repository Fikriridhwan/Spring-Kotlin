package product.cost.structure.kotlin.entity

import java.math.BigDecimal
import javax.persistence.*

@Entity
data class TestNumeric(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(columnDefinition = "Decimal(9,6) default '100.000000'")
    val percentage: BigDecimal,

    @Column(name = "tiny",precision = 1)
    val tiny: BigDecimal
)