package com.pdpano.ainu.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

@Entity(name = "tb_auth_roles")
data class AuthRoles(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "auth_id")
    val authentication: Auth,
    @ManyToOne
    @JoinColumn(name = "role_id")
    val role: Role
) : GrantedAuthority {
    override fun getAuthority(): String = role.name
}