const val HOST = "localhost"
const val USER = "SALT-PC"

fun main() {
    val name = "Fikri"
    var lastName = "Ridhwan"
    val tinggi = 169
    var nullStr: String? = "tidak null"

    lastName = lastName.length.toString()
    println(name)
    println(lastName)
    println(tinggi)
    println(nullStr)
    getConst()
}

fun getConst(){
   println("$HOST $USER")
}