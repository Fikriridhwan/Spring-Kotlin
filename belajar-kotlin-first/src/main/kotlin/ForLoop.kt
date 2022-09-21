fun main() {
    val names = arrayOf("Muhammad", "Fikri", "Ridhwan")
    for (name in names){
        println(name)
    }

    for (i in 0..20 step 3){
        println(i)
    }

    for (i in names.indices){
        println("array $i : ${names[i]}")
    }
}