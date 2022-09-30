package product.cost.structure.kotlin.model

import java.time.LocalDate
import javax.persistence.Column

data class CreatePriceRequest (

    val priceName: String,
    val priceDescription: String,
    val accountCode: String
)