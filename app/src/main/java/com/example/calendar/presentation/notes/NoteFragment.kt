package com.example.calendar.presentation.notes

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.example.calendar.R
import com.example.calendar.databinding.FragmentNoteBinding
import com.example.calendar.presentation.MainActivity
import com.example.calendar.presentation.calendar.CalendarFragment

class NoteFragment: Fragment(R.layout.fragment_note) {

    private var viewBinding : FragmentNoteBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding = FragmentNoteBinding.bind(view)

        with(viewBinding?:return) {
            save.setOnClickListener {
                val result = "result"
                setFragmentResult("requestKey", bundleOf("bundleKey" to result))
                (requireActivity() as MainActivity).navigateToCalendar()
            }
        }
    }

    override fun onDestroy() {
        viewBinding = null
        super.onDestroy()
    }

    companion object {
        fun newInstance(): Fragment = NoteFragment()
    }
}