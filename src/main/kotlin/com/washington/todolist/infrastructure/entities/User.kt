package com.washington.todolist.infrastructure.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "users")
data class User(

    @Id
    val id: UUID,

    @Column
    val name: String,

    @Column
    val email: String,
){
    @CreationTimestamp
    @Column(name = "created_at")
    lateinit var createdAt: LocalDateTime

    @UpdateTimestamp
    @Column(name = "updated_at")
    lateinit var updatedAt: LocalDateTime
}