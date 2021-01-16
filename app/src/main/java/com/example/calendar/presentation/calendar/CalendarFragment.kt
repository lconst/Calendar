package com.example.calendar.presentation.calendar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.example.calendar.R
import com.example.calendar.databinding.FragmentCalendarBinding
import com.example.calendar.presentation.MainActivity
import com.example.calendar.presentation.notes.NoteFragment

class CalendarFragment: Fragment(R.layout.fragment_calendar) {

    private var viewBinding: FragmentCalendarBinding? = null

    private val viewModel = CalendarViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding = FragmentCalendarBinding.bind(view)

        with(viewBinding?:return){

            recycler.adapter = CalendarNotesAdapter()

            addNote.setOnClickListener {
                viewModel.addNote()
            }
        }

        viewModel.navigateToAddNoteScreen.observe(this.viewLifecycleOwner) {
            (requireActivity() as MainActivity).navigateToNote()
        }

        setFragmentResultListener("requestKey") { requestKey, bundle ->
            val result = bundle.getString("bundleKey")
        }
    }


    override fun onDestroy() {
        viewBinding = null
        super.onDestroy()
    }

    companion object {
        fun newInstance(): Fragment = CalendarFragment()
    }
}