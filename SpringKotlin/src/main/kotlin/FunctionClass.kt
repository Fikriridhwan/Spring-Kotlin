fun myFunction (name : String) =
    "nama saya $name"

fun addTwoNumber(one: Double,two: Double) =
    one + two

fun mathCalculation(x: Double, y: Double = 3.14){
    println("Sum value: ${x + y}")
    println("Minus value: ${x - y}")
}

fun functionLambda(input: String, action: java.util.function.Function<String, Int>){
    println(action.apply(input))
}
