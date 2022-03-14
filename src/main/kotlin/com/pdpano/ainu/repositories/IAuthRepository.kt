package com.pdpano.ainu.repositories

import com.pdpano.ainu.entities.Auth
import org.springframework.data.jpa.repository.JpaRepository

interface IAuthRepository : JpaRepository<Auth, Long>