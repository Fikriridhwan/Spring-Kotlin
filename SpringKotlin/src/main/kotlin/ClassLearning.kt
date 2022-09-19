fun main() {
    var customer = Customer()
    println("Alamat: ${customer.address}, umur: ${customer.age}")
    customer.age = 26
    println("Umur tahun depan ${customer.age}")

    val goodsOreo = Goods("Oreo", 5_000)
    println(goodsOreo.name)
    val goodsRegal = Goods("Regal")
    println(goodsRegal.name)


    val goodsTango = AnotherGoods("Tango")
    println(goodsTango.name)

    val bocahSD1 = GradingReport("Dio", 89)
    bocahSD1.lulus = false
    println("bocah sd lulus ? ${bocahSD1.lulus}")
    val bocahSD2 = GradingReport("Gajah", 74)
    bocahSD2.lulus = false
    println("bocah sd lulus ? ${bocahSD2.lulus}")
    println("bocah sd ? ${bocahSD1.nilaiAbsen}")
    println("bocah sd ? ${bocahSD1.uppercaseName()}")
    println("bocah sd ? ${bocahSD1.toString()}")

    val bocahSD3 = GradingReport.getInstance()
    println(bocahSD3.toString())

    val goodsKitkat = goodsOreo.copy(name = "Kitkat")
    println(goodsKitkat.toString())

    val (name) = goodsKitkat
    println("$name")

    val(namaBocah, nilaiBocah) = bocahSD3
    println("$namaBocah. $nilaiBocah")
}