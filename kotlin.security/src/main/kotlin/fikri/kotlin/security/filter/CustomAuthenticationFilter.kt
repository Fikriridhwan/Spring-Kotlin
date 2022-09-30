package fikri.kotlin.security.filter

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.util.*
import java.util.stream.Collector
import java.util.stream.Collectors
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlin.collections.ArrayList

class CustomAuthenticationFilter(
    private val authManager: AuthenticationManager
): UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse?): Authentication {
        val username = request.getParameter("username")
        val password = request.getParameter("password")
        println("Username is $username, password is $password")
        val authenticationToken = UsernamePasswordAuthenticationToken(username, password)
        return authManager.authenticate(authenticationToken)
    }

    override fun successfulAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain?,
        authentication: Authentication
    ) {
        val user = authentication.principal as User
        println("${user.username}, ${user.password}")
        val algorithm = Algorithm.HMAC256("secret".toByteArray())
        val authoritiesMap = mutableListOf<String>()
        authoritiesMap.addAll(user.authorities.toList().map { it.authority }.toMutableList())
        val accessToken = JWT.create()
            .withSubject(user.username)
            .withExpiresAt(Date(System.currentTimeMillis()+ 10 * 60 * 1000))
            .withIssuer(request.requestURL.toString())
            .withClaim("roles", authoritiesMap )
            .sign(algorithm)
        val refreshToken = JWT.create()
            .withSubject(user.username)
            .withExpiresAt(Date(System.currentTimeMillis()+ 10 * 60 * 1000))
            .withIssuer(request.requestURL.toString())
            .withClaim("roles", authoritiesMap )
            .sign(algorithm)
        response.setHeader("access_token",accessToken)
        response.setHeader("refresh_token",refreshToken)
    }
}