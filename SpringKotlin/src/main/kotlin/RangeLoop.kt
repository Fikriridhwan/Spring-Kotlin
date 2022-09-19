import java.util.*
import kotlin.collections.HashMap

fun main() {
    var x: Int = 0
    var y: Int = 10

    while (x < 10){
        print(x)
        x++
    }

    println()
    val people = HashMap<Int,KotlinPerson>()
    val john = KotlinPerson(1L, "Mr", "John", "Blue",  GregorianCalendar(1977,9,3))
    val jane = KotlinPerson(2L, "Mrs", "Jane", "Green", null)
    val fikri = KotlinPerson(3L, "Mr", "Fikri", "Fikri", GregorianCalendar(2022,1,1))
    people.put(1,john)
    people.put(2,jane)
    people.put(3,fikri)

    for ((key,value) in people){
        println("$value has $key")
    }

    for(i in 0..9){
        print(i)
    }

    (0..9).forEach{print("$it,")}
    (20 downTo 0 step 3).forEach{ print("-$it-")}
    (0 until 9).forEach { print("$it") }
    ('A'..'H').forEach { println(it) }
}