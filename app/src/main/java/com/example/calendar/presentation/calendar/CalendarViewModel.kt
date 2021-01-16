package com.example.calendar.presentation.calendar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calendar.model.notes.entities.Note

class CalendarViewModel : ViewModel() {

    private val _navigateToAddNote = MutableLiveData<Boolean>()
    val navigateToAddNoteScreen: LiveData<Boolean> get() = _navigateToAddNote

    fun previewNotes() : List<Note> {
        return emptyList()
    }

    fun addNote(){
        _navigateToAddNote.value = true
    }
}