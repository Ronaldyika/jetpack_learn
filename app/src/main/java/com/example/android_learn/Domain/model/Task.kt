package com.example.android_learn.Domain.model

data class Task(
    val title: String,
    val description:String,
    val dueDate:Long,
    val proirity: Int,
    val relatedToSubject: String,
    val isComplete: Boolean,
    val taskSubjectId: Int,
    val taskId: Int
)
