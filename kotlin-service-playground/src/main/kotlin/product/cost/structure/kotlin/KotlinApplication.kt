package product.cost.structure.kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import product.cost.structure.kotlin.util.PriceUtil

@SpringBootApplication
class KotlinApplication

fun main(args: Array<String>) {
	runApplication<KotlinApplication>(*args)
//	val priceUtil = PriceUtil()
//	println("get outside ip address: ${priceUtil.getIpAddress()}")
}
