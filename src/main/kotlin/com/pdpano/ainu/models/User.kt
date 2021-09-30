package com.pdpano.ainu.models

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(nullable = false)
    val name: String,
    @Column(nullable = false)
    val birth: LocalDate,
    @Column(nullable = false)
    val email: String,
    @Column(nullable = false)
    val cpf: String,
    val is_active: Boolean = true,
    val created_at: LocalDateTime = LocalDateTime.now()
)