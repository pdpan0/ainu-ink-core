package com.pdpano.ainu.models

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity(name = "tb_auth_roles")
class AuthRoles(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "auth_id")
    val authentication: Auth,
    @ManyToOne
    @JoinColumn(name = "role_id")
    val role: Role
)