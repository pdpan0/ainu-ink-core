package com.pdpano.ainu.services

import com.pdpano.ainu.models.User
import com.pdpano.ainu.repositories.IUserRepository
import com.pdpano.ainu.utils.Logger
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: IUserRepository) {
    private val logger: org.slf4j.Logger = Logger().getLogger(javaClass)

    fun createUser(user: User): Long {
        logger.info("passou aqui")
        return repository.save(user).id
    }
}