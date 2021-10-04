package com.pdpano.ainu.controllers

import com.pdpano.ainu.models.User
import com.pdpano.ainu.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/users")
class UserController(private val service: UserService) {

    @PostMapping
    fun createUser(@RequestBody user: User): Long = service.createUser(user)
}