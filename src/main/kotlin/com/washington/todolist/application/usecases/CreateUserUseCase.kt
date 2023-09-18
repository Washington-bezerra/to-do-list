package com.washington.todolist.application.usecases

import com.washington.todolist.boundaries.models.requests.UserRequest
import com.washington.todolist.infrastructure.entities.User
import com.washington.todolist.infrastructure.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class CreateUserUseCase {

    @Autowired
    lateinit var userRepository: UserRepository

    operator fun invoke(userRequest: UserRequest): User {
        val userEntity = User(
            UUID.randomUUID(),
            userRequest.name,
            userRequest.email
        )
        return userRepository.save(userEntity)
    }
}