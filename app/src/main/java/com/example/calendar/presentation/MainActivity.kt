package com.example.calendar.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.calendar.R
import com.example.calendar.presentation.calendar.CalendarFragment
import com.example.calendar.presentation.notes.NoteFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, CalendarFragment.newInstance())
                .addToBackStack(CalendarFragment::class.java.name)
                .commit()
        }
    }

    fun navigateToCalendar() {
        supportFragmentManager.popBackStack()
    }

    fun navigateToNote() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, NoteFragment.newInstance())
            .addToBackStack(NoteFragment::class.java.name)
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }
}