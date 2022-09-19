package interoperability

data class Customer (val id: Long, val name: String)

class CustomerDatabase(){
    val customer = listOf<Customer>(
        Customer(1, "Matt"),
        Customer(2, "James"),
        Customer(3, "Dianne"),
        Customer(4, "Sally")
    )

    //hanya digunakan untuk java interoperability
    @Throws(IllegalAccessException::class)
    fun addCustomer(c : Customer) {
        throw IllegalAccessException("You cannot add a customer")
    }

    companion object {
        @JvmStatic
        fun helloWorld() =
            println("Hello world")

    }
}