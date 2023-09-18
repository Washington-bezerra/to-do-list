package com.washington.todolist.infrastructure.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import com.washington.todolist.domain.enums.priority.PriorityEnum
import com.washington.todolist.domain.enums.status.StatusEnum
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "to_do_items")
data class ToDoItem (

    @Id
    val id: UUID,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "list_id")
    @JsonIgnore
    val list: ToDoList,

    @Column(name = "due_date")
    val dueDate: Date? = null,

    @Column
    val description: String,

    @Column
    @Enumerated(EnumType.STRING)
    val priority: PriorityEnum? = null,

    @Column
    @Enumerated(EnumType.STRING)
    val status: StatusEnum
){
    @CreationTimestamp
    @Column(name = "created_at")
    lateinit var createdAt: LocalDateTime

    @UpdateTimestamp
    @Column(name = "updated_at")
    lateinit var updatedAt: LocalDateTime
}