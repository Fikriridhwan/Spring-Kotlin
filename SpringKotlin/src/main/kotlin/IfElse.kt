import java.util.*

fun main() {
    val john = KotlinPerson(1L, "Mr", "John", "Blue",  GregorianCalendar(1977,9,3))
    val jane = KotlinPerson(2L, "Mrs", "Jane", "Green", null)
    val fikri = KotlinPerson(3L, "Mr", "Fikri", "Fikri", GregorianCalendar(1997,1,1))
    println("$john's age is ${john.age}")
    println ("$jane's age is ${jane.age}");
    println ("$fikri's age is ${fikri.age}");
    println ("The age of someone born on 3rd May 1988 is " + KotlinPerson.getAge(GregorianCalendar(1988,5,3)));

    // assign variable with ifelse tenary syntax
    val whoIsOlder = if(john.safeAge > jane.safeAge) john else jane
    println("The older person is $whoIsOlder")

}

fun boolean(i: Int,j: Int ):Boolean{
    //if else tenary syntax
    return if (i >= j) true else false
}