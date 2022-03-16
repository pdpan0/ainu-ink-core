package com.pdpano.ainu.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "tb_auth")
data class Auth (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(nullable = false, unique = true)
    val username: String,
    @Column(nullable = false)
    val password: String,
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val user: User,
    val last_login: LocalDateTime,
    val is_active: Boolean = true,
    @OneToMany(mappedBy = "authentication")
    val authenticantion_roles: List<AuthRoles> = mutableListOf()
)