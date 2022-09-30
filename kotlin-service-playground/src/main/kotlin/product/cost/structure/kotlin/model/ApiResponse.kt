package product.cost.structure.kotlin.model

class ApiResponse<T> (
    val code: Int,
    val status: String,
    val data: T
)