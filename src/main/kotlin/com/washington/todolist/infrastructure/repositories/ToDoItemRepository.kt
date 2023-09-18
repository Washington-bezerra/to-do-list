package com.washington.todolist.infrastructure.repositories

import com.washington.todolist.infrastructure.entities.ToDoItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ToDoItemRepository: JpaRepository<ToDoItem, UUID> {}