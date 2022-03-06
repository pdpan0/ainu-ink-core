package com.pdpano.ainu.models

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "tb_auth")
class Auth (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(nullable = false, unique = true)
    val username: String,
    @Column(nullable = false)
    val password: String,
    val user_id: Int,
    val last_login: LocalDateTime,
    val is_active: Boolean = true
)