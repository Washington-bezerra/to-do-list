package com.washington.todolist.boundaries.controllers

import com.washington.todolist.application.usecases.CreateUserUseCase
import com.washington.todolist.boundaries.models.requests.UserRequest
import com.washington.todolist.infrastructure.entities.User
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController (
    private val createUserUseCase: CreateUserUseCase
){

    @PostMapping("/api/user")
    fun createUser(@RequestBody user: UserRequest): User {
        return createUserUseCase(user)
    }
}