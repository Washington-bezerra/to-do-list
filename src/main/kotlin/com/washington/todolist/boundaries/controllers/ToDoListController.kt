package com.washington.todolist.boundaries.controllers

import com.washington.todolist.application.usecases.CreateToDoListUseCase
import com.washington.todolist.boundaries.models.requests.ToDoListRequest
import com.washington.todolist.infrastructure.entities.ToDoList
import com.washington.todolist.infrastructure.repositories.ToDoListRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class ToDoListController (
    private val createToDoListUseCase: CreateToDoListUseCase,
    private val toDoListRepository: ToDoListRepository
){

    @PostMapping("/api/to-do-list")
    fun createToDoList(@RequestBody request: ToDoListRequest): ToDoList {
        return createToDoListUseCase(request)
    }

    @GetMapping("/api/to-do-list/{toDoListId}")
    fun getToDoList(
        @PathVariable toDoListId: UUID,
    ): Optional<ToDoList> {
        return toDoListRepository.findById(toDoListId)
    }
}