package functionalprogramming

fun toSentenceCase(input: String): String {
    return input[0].uppercase() + input.substring(1)
}

fun main() {
    println(toSentenceCase("hello"))
}