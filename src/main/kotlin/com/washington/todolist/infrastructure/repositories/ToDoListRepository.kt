package com.washington.todolist.infrastructure.repositories

import com.washington.todolist.infrastructure.entities.ToDoList
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ToDoListRepository: JpaRepository<ToDoList, UUID> {}