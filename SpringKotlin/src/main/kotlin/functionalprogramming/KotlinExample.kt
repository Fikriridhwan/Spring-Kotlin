package functionalprogramming

fun applySomeFunctionToAString(inputString: String, myFunction: (String) -> String): String{
    return myFunction(inputString)
}

fun main() {
    val result = applySomeFunctionToAString("hello", ::toSentenceCase)
    val result2 = applySomeFunctionToAString("hello") { it.uppercase() }
    println(result)
    println(result2)

    //map = mengambil 1:1 datanya untuk di aplikasikan dengan fungsinya. *berbentuk collection
    val colors = listOf("red","blue","magenta","green","black","yellow")
    val uppercaseColors = colors.map { it.uppercase() }

    println(uppercaseColors)

    //filter = ambil data sesuai dengan filter
    val colorsFirstB = colors.filter { it.startsWith("b") }
    println(colorsFirstB)

    //flatmap = mengambil 1:1 datanya untuk di aplikasikan dengan fungsinya. *berbentuk given datatypenya
    val colorDuplicateB = colors.flatMap { if(it.startsWith("b")) listOf(it,it) else listOf(it) }
    println(colorDuplicateB)

    //reduce = make a collection to single value
    println(colors.reduce{result, value -> "$result, $value"})

    val numbers = colors.map { it.length }
    println(numbers)
    println(numbers.sum())
    println(numbers.average())
    println(numbers.count())

    //fold = make a collection to single value. dimana result sudah memiliki value dari initial yg diberikan
    println(numbers.fold(0){result, value -> result + value} )
    println(numbers.fold(0){result, value -> if(value > result) value else result})

    val myMap = mapOf(1 to "one", 2 to "two", 3 to "three")
    myMap.filter { (k,v) -> v.startsWith("t") }.forEach{ println("${it.key} ${it.value}") }

}