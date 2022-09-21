fun main() {
    val names : Array<String> = arrayOf("Muhammad", "Fikri", "Ridhwan")
    println(names.size)
    names.set(1,"Iwan")
    println(names[1])

    val members : Array<Int?> = arrayOf(0,1,2,3,null,5,6,7)
    println(members.get(4))
}