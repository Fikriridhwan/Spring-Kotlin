package product.cost.structure.kotlin.entity

import org.jetbrains.annotations.NotNull
import java.time.LocalDate
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class PriceStructure(
    @Id
    val priceStructureID: Int,

    @Column(nullable = false)
    val priceStructureType: Int,

    @Column(length = 50, nullable = false)
    @NotNull
    val priceStructuredName: String,

    val productServiceTypeID: Int?,

    val branchProductServiceID: Int?,

    val serviceActivityID: Int?,

    @Column(nullable = false)
    val branchID: Int,

    @Column(nullable = false)
    val isActive: Int,

    @Column(length = 15, nullable = false)
    val createUserID: String,

    @Column(length = 15, nullable = false)
    val createIPAddress: String,

    @Column(nullable = false)
    val createDate: Date,

    @Column(length = 15)
    @NotNull
    val lastModifyUserID: String,

    @Column(length = 15,nullable = false)
    val lastModifyIPAddress: String,

    @Column(nullable = false)
    val lastModifyDate: Date
)
{
    @OneToMany(mappedBy = "priceStructureID")
    lateinit var priceStructureDetail: List<PriceStructureDetail>
}