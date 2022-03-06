package com.pdpano.ainu.models

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "tb_user")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(nullable = false)
    val name: String,
    @Column(nullable = false)
    val birth: LocalDate,
    @Column(nullable = false, unique = true)
    val email: String,
    @Column(nullable = false, unique = true)
    val cpf: String,
    val created_at: LocalDateTime = LocalDateTime.now()
)