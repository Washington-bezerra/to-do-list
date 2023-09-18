package com.washington.todolist.application.usecases

import com.washington.todolist.boundaries.models.requests.ToDoItemRequest
import com.washington.todolist.infrastructure.entities.ToDoItem
import com.washington.todolist.infrastructure.repositories.ToDoItemRepository
import com.washington.todolist.infrastructure.repositories.ToDoListRepository
import kotlin.collections.List
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class CreateItemsUseCase {

    @Autowired
    lateinit var toDoItemRepository: ToDoItemRepository

    @Autowired
    lateinit var toDoListRepository: ToDoListRepository

    operator fun invoke(request: List<ToDoItemRequest>): MutableList<ToDoItem> {
        val toDoItemEntities = mutableListOf<ToDoItem>()
        request.forEach {
            val toDoList = toDoListRepository.findById(it.listId).orElseThrow()
            val toDoItemEntity = ToDoItem(
                UUID.randomUUID(),
                toDoList,
                it.dueDate,
                it.description,
                it.priority,
                it.status
            )

            toDoItemEntities.add(toDoItemEntity)
        }

        return toDoItemRepository.saveAll(toDoItemEntities)
    }
}