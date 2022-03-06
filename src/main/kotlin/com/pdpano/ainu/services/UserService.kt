package com.pdpano.ainu.services

import com.pdpano.ainu.models.User
import com.pdpano.ainu.repositories.IUserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: IUserRepository) {

    fun createUser(user: User): Long {
        if (repository.existsUserByCpf(user.cpf))
            throw IllegalArgumentException("cpf já existe.")
        if (repository.existsUserByEmail(user.email))
            throw IllegalArgumentException("email já existe.")

        return repository.save(user).id
    }

    fun getUserByEmail(email: String) = repository.findUserByEmail(email)

    fun getUsers(): MutableList<User> = repository.findAll()
}