fun main() {
    val nilaiMatkul = 100
    val nilaiAbsen = 75

    var result = nilaiAbsen + nilaiMatkul + 10
    result /= 2

    if (result > 80){
        println("Selamat anda lulus")
    }else if (result > 75){
        println("good")
    }else{
        println("Semangat. coba lagi")
    }

    println(result)

    // When ================================

    var finalResult = 'D'
    when(finalResult){
        'A' -> println("Perfect")
        'B' -> println("Great")
        'C' -> {
            println("Good")
            println("Take class again for better score")
        }
        'D' -> println("Bad")
        else -> println("Failed. Take class again")
    }

    when(finalResult){
        'A','B','C' -> println("Lulus")
        else -> println("Tidak lulus")
    }

    finalResult = 'B'
    val passValue: Array<Char> = arrayOf('A','B','C')
    when(finalResult){
        in passValue -> println("lulus")
        !in passValue -> println("tidak lulus")
    }

    val name = "Fikri"
    when(name){
        is String -> println("String")
        !is String -> println("not String")
    }

    when{
        result > 90 && name == "Fikri" -> println("Superb")
        result > 80  -> println("Nice")
        result > 70 -> println("Meh")
        else -> println("try again next time")
    }

}