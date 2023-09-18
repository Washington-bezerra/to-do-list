package com.washington.todolist.boundaries.models.requests

import com.washington.todolist.domain.enums.priority.PriorityEnum
import com.washington.todolist.domain.enums.status.StatusEnum
import java.util.Date
import java.util.UUID

data class ToDoListRequest(
    val userId: UUID,
    val title: String,
    val description: String? = null,
    val priority: PriorityEnum? = null,
    val dueDate: Date? = null,
    val status: StatusEnum
)
