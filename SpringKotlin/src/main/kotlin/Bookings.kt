import java.math.BigDecimal

interface BookingManager{

    val version : String
    fun isSeatFree(seat: Seat): Boolean
    fun reservedSeat(seat: Seat, customerId: Long): Boolean
    fun systemStatus() = "All operation are Functional"
}

//custom class exception
class UnauthorizeUserException : Throwable()

//open untuk membuka class. *default class kotlin final
open class BasicBookingManager(authorizationKey : String) : BookingManager{

    val authorizationKey get() = ""
    override val version = "1.0"

    override fun isSeatFree(seat: Seat): Boolean = true
    override fun reservedSeat(seat: Seat, customerId: Long): Boolean = false

    init {
        if (authorizationKey != "12345") throw UnauthorizeUserException()
    }
}

class AdvanceBookingManager : BasicBookingManager("12345"), java.io.Closeable{

//    val authorizationKey get()
    override val version = "2.0"
    fun howManyBooking() = 10
    override fun close() {}
}

//extend function di class yang sudah ada
fun String.toSentenceString(): String{
    return this[0].uppercase() + this.substring(1)
}


fun main() {
    println(AdvanceBookingManager().isSeatFree(Seat(1,2, BigDecimal.ZERO,"")))
    println(AdvanceBookingManager().version)
//    println(BasicBookingManager().authoriztionKey)

    val name: String = "muhammad"
    println(name.toSentenceString())
}