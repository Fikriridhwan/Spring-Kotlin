import kotlin.math.roundToInt
import kotlin.math.sqrt
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.memberProperties

fun isPrime(int: Int): Boolean {
    val maxNumber = sqrt(int.toDouble()).roundToInt()
    for (i in 2..maxNumber) if (int % i == 0) return false

    return true
}

fun main() {
    val myList = listOf(14,15,16,17,18,19)
    //sama seperti .filter{isPrime(it)}
    //filter(classname::function)
    val myPrimeNumber = myList.filter(::isPrime)
    println(myPrimeNumber)

    println(myList::class.memberProperties)
    println(myList::class.declaredFunctions)


}