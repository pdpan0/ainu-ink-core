package com.pdpano.ainu.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.GrantedAuthority
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity(name = "tb_roles")
data class Role (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(nullable = false, unique = true)
    val name: String,
    val is_active: Boolean = true,
//    @JsonIgnore
//    @OneToMany(mappedBy = "role")
//    val authenticantion_roles: List<AuthRoles> = mutableListOf()
)