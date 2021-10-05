package com.pdpano.ainu.repositories

import com.pdpano.ainu.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IUserRepository: JpaRepository<User, Long> {
    fun existsUserByCpf(cpf: String): Boolean

    fun existsUserByEmail(email: String): Boolean

    fun findUserByEmail(email: String): List<User>
}