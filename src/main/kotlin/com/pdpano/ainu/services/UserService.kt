package com.pdpano.ainu.services

import com.pdpano.ainu.exceptions.UserNotFoundException
import kotlin.jvm.Throws
import com.pdpano.ainu.entities.User
import com.pdpano.ainu.repositories.IUserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: IUserRepository) {

    @Throws(UserNotFoundException::class)
    fun createUser(user: User): Long {
        if (repository.existsUserByCpf(user.cpf))
            throw UserNotFoundException("cpf já existe.")
        if (repository.existsUserByEmail(user.email))
            throw UserNotFoundException("email já existe.")

        return repository.save(user).id
    }

    fun getUserByEmail(email: String) = repository.findUserByEmail(email)

    fun getUsers(): MutableList<User> = repository.findAll()
}