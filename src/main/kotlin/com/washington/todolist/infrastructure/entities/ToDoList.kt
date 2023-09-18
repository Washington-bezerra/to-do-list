package com.washington.todolist.infrastructure.entities

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
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "to_do_list")
data class ToDoList (

    @Id
    val id: UUID,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val userId: User,

    @Column
    val title: String,

    @Column
    val description: String? = null,

    @Column
    @Enumerated(EnumType.STRING)
    val priority: PriorityEnum? = null,

    @Column(name = "due_date")
    val dueDate: Date? = null,

    @Column
    @Enumerated(EnumType.STRING)
    val status: StatusEnum,

    @OneToMany(mappedBy = "list")
    val items: List<ToDoItem>? = null
){
    @CreationTimestamp
    @Column(name = "created_at")
    lateinit var createdAt: LocalDateTime

    @UpdateTimestamp
    @Column(name = "updated_at")
    lateinit var updatedAt: LocalDateTime
}