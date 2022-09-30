package fikri.kotlin.security

import fikri.kotlin.security.security.PasswordEncoderDefault
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootApplication()
class Application
{
	@Bean
	fun passwordEncoder():PasswordEncoder{
//		return BCryptPasswordEncoder()
		return PasswordEncoderDefault()
	}
}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}



