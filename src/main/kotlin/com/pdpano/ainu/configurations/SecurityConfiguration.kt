package com.pdpano.ainu.configurations

import com.pdpano.ainu.security.JwtAuthenticationFilter
import com.pdpano.ainu.security.JwtLoginFilter
import com.pdpano.ainu.utils.JwtUtils
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val userDetailService: UserDetailsService,
    private val jwtUtils: JwtUtils
): WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http?.csrf()?.disable()
        http?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http?.authorizeRequests()?.anyRequest()?.permitAll()
        http?.addFilter(JwtLoginFilter(authManager = authenticationManager(), jwtUtils = jwtUtils))
//        http?.let {
//            it.csrf().disable()
//            it.authorizeRequests()
////                .antMatchers("/v1/users").hasAuthority("ESCRITA")
//                .mvcMatchers(HttpMethod.POST, "/v1/auth/token")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//            it.addFilterBefore(JwtLoginFilter(
//                authManager = authenticationManager(),
//                jwtUtils = jwtUtils), UsernamePasswordAuthenticationFilter().javaClass)
//            it.addFilterBefore(JwtAuthenticationFilter(jwtUtils = jwtUtils), UsernamePasswordAuthenticationFilter().javaClass)
//            it.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        }
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(userDetailService)?.passwordEncoder(bCryptPasswordEncoder())
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}