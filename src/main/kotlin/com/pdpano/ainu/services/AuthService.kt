package com.pdpano.ainu.services

import com.pdpano.ainu.models.Auth
import com.pdpano.ainu.repositories.IAuthRepository
import org.springframework.stereotype.Service

@Service
class AuthService(private val repository: IAuthRepository) {

    fun getAuthentications(): MutableList<Auth> = repository.findAll()
}