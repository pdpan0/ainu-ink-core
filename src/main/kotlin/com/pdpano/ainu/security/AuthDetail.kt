package com.pdpano.ainu.security

import com.pdpano.ainu.entities.Auth
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthDetail(
    private val auth: Auth
): UserDetails {

    override fun getAuthorities() = null

    override fun getPassword(): String = auth.password

    override fun getUsername(): String = auth.username

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}