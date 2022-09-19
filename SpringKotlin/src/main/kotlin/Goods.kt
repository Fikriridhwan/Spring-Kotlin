data class Goods(
    var name: String,
     var price: Int){

    constructor(name: String) :this(name,0)
    override fun toString() = "$name , $price"
}

class AnotherGoods(val name: String,val price: Int = 0)

class GradingReport(val name: String, var totalNilai: Int){
    //akses variable, do something
    var lulus = true
    set(value){
        if(totalNilai < 75){
            field = value
        }else{
            println("sudah pasti lulus")
        }
    }

    //get variable, do something
    val nilaiAbsen
        get() = totalNilai + 5

    fun uppercaseName() = name.uppercase()

    //override
    override fun toString() = "$name , $totalNilai, lulus : $lulus "

    //deconstruction: value dari class di pass ke individu variable
    operator fun component1() = name
    operator fun component2() = totalNilai

    //create static function
    companion object{
        fun getInstance() = GradingReport("Anonim",0)
    }
}