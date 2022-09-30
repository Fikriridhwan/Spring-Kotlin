package fikri.kotlin.security.security

//import fikri.kotlin.security.filter.CustomAuthenticationFilter
import com.auth0.jwt.JWT
import fikri.kotlin.security.filter.CustomAuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SpringConfig2{

//    @Bean
//    fun passwordEncoder(): PasswordEncoder{
//        return BCryptPasswordEncoder()
//    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain{
        http.csrf().disable()
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http.authorizeRequests().anyRequest().permitAll()
        http.addFilter(CustomAuthenticationFilter(authenticationManagerBean()))
        http.httpBasic()
//        http.addFilter(CustomAuthenticationFilter(authenticationManager(http.getSharedObject(AuthenticationConfiguration::class.java))))
        return http.build()
    }


    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }



}