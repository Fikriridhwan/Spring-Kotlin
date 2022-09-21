fun main() {
    var firstName: String = "Fikri"
    var address: String = """
        Kembang raya
        Kwitang
        Senen
        Jakarta Pusat
    """.trimIndent()

    println(firstName)
    println(address)

    var stringOne: String = "kata pertama"
    var stringTwo: String = "kata dua"
    var complete: String = "$stringOne $stringTwo"
    var detailComplete: String = "Length for $complete = ${complete.length}"
    println(stringOne)
    println(stringTwo)
    println(complete)
    println(detailComplete)
}