package com.washington.todolist.boundaries.controllers

import com.washington.todolist.application.usecases.CreateItemsUseCase
import com.washington.todolist.application.usecases.CreateToDoListUseCase
import com.washington.todolist.boundaries.models.requests.ToDoItemRequest
import com.washington.todolist.boundaries.models.requests.ToDoListRequest
import com.washington.todolist.infrastructure.entities.ToDoItem
import com.washington.todolist.infrastructure.entities.ToDoList
import com.washington.todolist.infrastructure.repositories.ToDoItemRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class ToDoItemController (
    private val createToDoItemsUseCase: CreateItemsUseCase,
    private val toDoItemRepository: ToDoItemRepository
){

    @PostMapping("/api/to-do-items")
    fun createToDoItems(@RequestBody request: List<ToDoItemRequest>): MutableList<ToDoItem> {
        return createToDoItemsUseCase(request)
    }

    @GetMapping("/api/to-do-items/{itemId}")
    fun getItem(
        @PathVariable itemId: UUID
    ): Optional<ToDoItem> {
        return toDoItemRepository.findById(itemId)
    }
}