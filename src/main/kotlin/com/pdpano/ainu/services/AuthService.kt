package com.pdpano.ainu.services

import com.pdpano.ainu.entities.Auth
import com.pdpano.ainu.exceptions.UserNotFoundException
import com.pdpano.ainu.repositories.IAuthRepository
import com.pdpano.ainu.security.AuthDetail
import com.pdpano.ainu.utils.LogUtils
import org.slf4j.Logger
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthService(private val repository: IAuthRepository): UserDetailsService {
    private val log: Logger = LogUtils().getLogger(javaClass)

    override fun loadUserByUsername(username: String?): UserDetails {
        val auth = repository.findAuthByUsername(username)

        if (auth == null) {
            log.error("User not found in the database")
            throw UserNotFoundException("User not found in the database")
        } else {
            log.info("User found in the database: {}", auth.username)
        }

        return AuthDetail(auth)
    }
    fun getAuthentications(): MutableList<Auth> = repository.findAll()
}