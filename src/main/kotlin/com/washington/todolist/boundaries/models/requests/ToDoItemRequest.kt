package com.washington.todolist.boundaries.models.requests

import com.washington.todolist.domain.enums.priority.PriorityEnum
import com.washington.todolist.domain.enums.status.StatusEnum
import com.washington.todolist.infrastructure.entities.ToDoList
import jakarta.persistence.Column
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.util.Date
import java.util.UUID

data class ToDoItemRequest(
    val listId: UUID,
    val dueDate: Date? = null,
    val description: String,
    val priority: PriorityEnum? = null,
    val status: StatusEnum
)
