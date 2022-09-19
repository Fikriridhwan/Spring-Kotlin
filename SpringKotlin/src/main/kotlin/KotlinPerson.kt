import java.util.Calendar
import java.util.GregorianCalendar

class KotlinPerson(val id: Long,
                   val title: String, val firstName: String, val surename: String,
                   val dateOfBirth: Calendar?)
{
    override fun toString() = "$title $firstName $surename"

    val safeAge: Int
        get() = age ?: -1
    val age : Int?
        get() = getAge(dateOfBirth)

    var favoriteColor: String? = null
    fun getUpperCaseColor(): String {
        return favoriteColor?.uppercase() ?: ""
    }
    fun getLastLetter(a: String) = a.takeLast(1)
    fun getLastLetterColor() : String {
//        return if(favoriteColor == null) "" else getLastLetter(favoriteColor)
        return favoriteColor?.let { getLastLetter(it) } ?: ""
    }

    fun getColorType(): String {
        val color = getUpperCaseColor()
//        return if (color == "") "empty"
//        else if (color == "RED" || color == "BLUE" || color == "GREEN") "RGB"
//        else "Other"
        return when (color){
            "" -> "empty"
            "RED","GREEN","BLUE" -> "RGB"
            else -> "other"
        }
    }


    companion object{
        fun getAge(dateOfBirth: Calendar?): Int {
            if (dateOfBirth == null) return -1

            val today = GregorianCalendar();
            var years = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
            if (dateOfBirth.get(Calendar.DAY_OF_YEAR) >= today.get(Calendar.YEAR)) {
                return years -1
            }
            else {
                return years
            }
        }
    }
    operator fun component1() = id
    operator fun component2() = title
    operator fun component3() = firstName

}

fun main() {
    val john = KotlinPerson(1L, "Mr", "John", "Blue",  GregorianCalendar(1977,9,3))
    val jane = KotlinPerson(2L, "Mrs", "Jane", "Green", null)
    val fikri = KotlinPerson(3L, "Mr", "Fikri", "Fikri", GregorianCalendar(2022,1,1))
    println("$john's age is ${john.age}")
    println ("$jane's age is ${jane.age}");
    println ("$fikri's age is ${fikri.age}");
    println ("The age of someone born on 3rd May 1988 is " + KotlinPerson.getAge(GregorianCalendar(1988,5,3)));
}