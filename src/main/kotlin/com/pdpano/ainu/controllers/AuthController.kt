package com.pdpano.ainu.controllers

import com.pdpano.ainu.models.Auth
import com.pdpano.ainu.services.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/auth")
class AuthController(private val service: AuthService) {

    @GetMapping
    fun getAuthentications(): ResponseEntity<MutableList<Auth>> = ResponseEntity.ok(service.getAuthentications())
}