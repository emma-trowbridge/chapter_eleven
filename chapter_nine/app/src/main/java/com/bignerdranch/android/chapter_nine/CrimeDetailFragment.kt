package com.bignerdranch.android.chapter_nine

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.bignerdranch.android.chapter_nine.databinding.ActivityMainBinding
import com.bignerdranch.android.chapter_nine.databinding.FragmentCrimeDetailBinding
import java.util.Date
import java.util.UUID

private lateinit var binding: FragmentCrimeDetailBinding


class CrimeDetailFragment : Fragment() {

    var crime: Crime = Crime(
        id = UUID.randomUUID(),
        title = "",
        date = Date(),
        isSolved = false
    )

    private var _binding: FragmentCrimeDetailBinding? = null
    val binding get() = _binding!! // Non-nullable binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCrimeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            crimeTitle.doOnTextChanged { text, _, _, _ ->
                crime = crime.copy(title = text.toString())
                Log.d("CrimeDetailFragment", "Updated Crime title: ${crime.title}")
            }

            crimeDate.apply {
                text = crime.date.toString()
                isEnabled = false
            }

            crimeSolved.setOnCheckedChangeListener { _, isChecked ->
                crime = crime.copy(isSolved = isChecked)
                Log.d("CrimeDetailFragment", "Updated Crime isSolved: ${crime.isSolved}")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Avoid memory leaks by nullifying the binding reference
    }
}
