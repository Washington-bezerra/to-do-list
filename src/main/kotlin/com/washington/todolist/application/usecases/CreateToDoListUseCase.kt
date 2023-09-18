package com.washington.todolist.application.usecases

import com.washington.todolist.boundaries.models.requests.ToDoListRequest
import com.washington.todolist.infrastructure.entities.ToDoList
import com.washington.todolist.infrastructure.entities.User
import com.washington.todolist.infrastructure.repositories.ToDoListRepository
import com.washington.todolist.infrastructure.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.lang.Exception
import java.util.*

@Component
class CreateToDoListUseCase {

    @Autowired
    lateinit var toDoListRepository: ToDoListRepository
    @Autowired
    lateinit var userRepository: UserRepository

    operator fun invoke(request: ToDoListRequest): ToDoList {

        val user = userRepository.findById(request.userId).orElseThrow()

        val toDoListEntity = ToDoList(
            UUID.randomUUID(),
            user,
            request.title,
            request.description,
            request.priority,
            request.dueDate,
            request.status
        )
        return toDoListRepository.save(toDoListEntity)
    }
}