fun main() {
    val colors = listOf("RED","BLUE","GREEN")
    println(colors)

    val days = mutableListOf("senin", "selasa", "rabu")
    println(days)

    val webColor = mapOf("red" to "merah", "blue" to "biru")

    val intArray : IntArray = intArrayOf(1,2,3,4,5,6)
    intArray.set(2,10)
    intArray.forEach { println(it) }
    days.add("abc")
    println(colors.get(0))
    println(days)
}