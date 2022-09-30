package product.cost.structure.kotlin.entity

import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class PriceStructureDetail(

    @Id
    val priceStructureDetailID: Int,

    @ManyToOne
    val priceID: Price,

    @ManyToOne
    val priceStructureID: PriceStructure,

    @Column(length = 1, nullable = false)
    val isPercentage: Int,

    @Column(columnDefinition = "Decimal(9,6) default '100.000000'")
    val percentage: BigDecimal?,

    @Column(columnDefinition = "Decimal(18,2) default '100.00'")
    val amount: BigDecimal?,

    @Column(columnDefinition = "Decimal(18,2) default '100.00'")
    val maxAmount: BigDecimal?,

    @Column(length = 15, nullable = false)
    val createUserID: String,

    @Column(length = 15, nullable = false)
    val createIPAddress: String,

    @Column(nullable = false)
    val createDate: Date,

    @Column(length = 15, nullable = false)
    val lastModifyUserID: String,

    @Column(length = 15, nullable = false)
    val lastModifyIPAddress: String,

    @Column(nullable = false)
    val lastModifyDate: Date
)