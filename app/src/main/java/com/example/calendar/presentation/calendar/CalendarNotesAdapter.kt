package com.example.calendar.presentation.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calendar.R
import com.example.calendar.model.notes.entities.Note

class CalendarNotesAdapter: RecyclerView.Adapter<CalendarNotesViewHolder>() {

    private var notes = emptyList<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarNotesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_notes, parent, false)
        return CalendarNotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CalendarNotesViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun submitList(list: List<Note>) {
        notes = list
        notifyDataSetChanged()
    }

}