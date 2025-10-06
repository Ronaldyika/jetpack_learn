package com.example.android_learn.Domain.model

data class Session(
    val sessionSubjectId:Int,
    val relatedSubject:String,
    val date:Long,
    val duration:Long,
    val session:Int
)
