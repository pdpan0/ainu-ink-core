package com.pdpano.ainu.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.pdpano.ainu.entities.AuthRoles
import com.pdpano.ainu.models.Credentials
import com.pdpano.ainu.utils.JwtUtils
import com.pdpano.ainu.utils.LogUtils
import org.slf4j.Logger
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtLoginFilter(
    private val authManager: AuthenticationManager,
    private val jwtUtils: JwtUtils
) : UsernamePasswordAuthenticationFilter() {
    private val log: Logger = LogUtils().getLogger(javaClass)

    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        log.info("Tentativa de autenticação")
        println("attemptAuthentication()")
        val (username, password) = ObjectMapper().readValue(request?.inputStream, Credentials::class.java)
        val token = UsernamePasswordAuthenticationToken(username, password)

        return authManager.authenticate(token)
    }

    override fun successfulAuthentication(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        chain: FilterChain?,
        authResult: Authentication?
    ) {
        println("successfulAuthentication()")
        val user = (authResult?.principal as UserDetails)
        val token = jwtUtils.generateToken(user.username, user.authorities as List<AuthRoles>)
        response?.addHeader("Authorization", "Bearer $token")
    }
}