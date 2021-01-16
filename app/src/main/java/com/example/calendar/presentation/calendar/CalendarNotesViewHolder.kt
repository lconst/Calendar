package com.example.calendar.presentation.calendar

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.calendar.R
import com.example.calendar.databinding.ViewHolderNotesBinding
import com.example.calendar.model.notes.entities.Note


class CalendarNotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val viewBinding = ViewHolderNotesBinding.bind(itemView)

    fun bind(note: Note) {
        with(viewBinding) {
            time.text = itemView.context.getString(
                R.string.time,
                note.getStartHour(),
                note.getStartMinutes(),
                note.getFinishHour(),
                note.getFinishMinutes())
            name.text = note.name
        }
    }
}