package com.pdpano.ainu.services

import com.pdpano.ainu.entities.Auth
import com.pdpano.ainu.repositories.IAuthRepository
import com.pdpano.ainu.security.AuthDetail
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthService(private val repository: IAuthRepository): UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val auth = repository.findAuthByUsername(username) ?: throw RuntimeException()

        return AuthDetail(auth)
    }
    fun getAuthentications(): MutableList<Auth> = repository.findAll()
}