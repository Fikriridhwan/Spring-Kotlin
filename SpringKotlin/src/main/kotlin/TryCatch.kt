import java.io.FileInputStream
import java.lang.Exception

// kotlin tidak ada pengecekan exception karena kegunaannya untuk functional programming (java lamda)
// lakukan pengecekan untuk setiap pemanggilan dengan testing
fun main() {
    try {
        println(7/0)
    }catch (e: ArithmeticException){
        println("catch ArithmeticException")
    }

    var result = try {
        divide(3,70)
    }catch (e: Exception){
        println(e)
        0
    }

    println(result)
}

@Throws(InterruptedException::class) // sebagai anotasi saja. tidak menotice ketika pemnaggilan func
fun divide (a: Int, b: Int): Double{
    return (a.toDouble() /b)
}

// deklarasi kotlin untuk penggunaan try(//somecode) {... }catch(exception e) {...}
fun printFile (){
    val input = FileInputStream("file.txt")
    input.use {
        //throw execption untuk close file (insert file)
    }
}