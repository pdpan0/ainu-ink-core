package com.pdpano.ainu.controllers

import com.pdpano.ainu.entities.Auth
import com.pdpano.ainu.models.Credentials
import com.pdpano.ainu.services.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/auth")
class AuthController(private val service: AuthService) {

    @PostMapping("/token")
    fun getAuthentications(@RequestBody credentials: Credentials): UserDetails = service.loadUserByUsername(credentials.username)
}