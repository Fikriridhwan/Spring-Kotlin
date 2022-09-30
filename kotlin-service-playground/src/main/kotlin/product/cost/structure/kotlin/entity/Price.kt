package product.cost.structure.kotlin.entity

import com.sun.istack.Nullable
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
data class Price (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val priceId: Int,

    @Column(length = 50, nullable = false)
    val priceName: String,

    @Column(length = 250)
    val priceDescription: String,

    @Column(length = 50, nullable = false)
    val accountCode: String,

    @Column(length = 1, nullable = false)
    val isActive: Int,

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
{
    @OneToMany(mappedBy = "priceID")
    lateinit var priceStructureDetail: List<PriceStructureDetail>
}