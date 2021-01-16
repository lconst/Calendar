package com.example.calendar.model.notes.entities

class Note(
    val id: Int,
    val dateStart: Long,
    val dateFinish: Long,
    val name: String,
    val description: String) {

    fun getStartHour(): Int = ((dateStart / 1000) % 60).toInt()
    fun getStartMinutes(): Int = ((dateStart / 1000) / 60).toInt()

    fun getFinishHour(): Int = ((dateFinish / 1000) % 60).toInt()
    fun getFinishMinutes(): Int = ((dateFinish / 1000) / 60).toInt()
}