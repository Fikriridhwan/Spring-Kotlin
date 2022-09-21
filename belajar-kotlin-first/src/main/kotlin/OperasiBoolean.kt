fun main() {
    val nilaiMatkul = 80
    val nilaiAbsen = 75

    val passMatkul = nilaiMatkul > 75
    val passAbsen = nilaiAbsen > 75

    val result = passAbsen && passMatkul

    println(result)
}