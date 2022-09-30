package product.cost.structure.kotlin.util

import org.springframework.stereotype.Component
import java.net.InetSocketAddress
import java.net.*

@Component
class PriceUtil {


    companion object{
        val socket = Socket()

        fun getIpAddress(): String{
            socket.connect(InetSocketAddress("google.com", 80))
            return socket.localAddress.toString()
        }
    }

}