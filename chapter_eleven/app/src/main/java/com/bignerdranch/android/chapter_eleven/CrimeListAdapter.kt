package com.bignerdranch.android.chapter_eleven

import android.text.format.DateFormat //added for 3b - nicer format
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.chapter_eleven.databinding.ListItemCrimeBinding

class CrimeHolder(
    private val binding:ListItemCrimeBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        //binding.crimeDate.text = crime.date.toString() //replaced - timestamp format
        val formattedDate = DateFormat.format("MMM dd, yyyy", crime.date).toString()
        binding.crimeDate.text = formattedDate

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} Clicked!",
                Toast.LENGTH_SHORT
            ).show()

        }

        //display crimeSolved icon based on whether crime is solved
        binding.crimeSolved.visibility = if(crime.isSolved) {
            View.VISIBLE
        } else{
            View.GONE
        }
    }


    class CrimeListAdapter(
        private val crimes: List<Crime>
    ) : RecyclerView.Adapter<CrimeHolder>() {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): CrimeHolder {

            val inflater = LayoutInflater.from(parent.context)
            val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
            return CrimeHolder(binding)
        }

        override fun getItemCount() = crimes.size

        override fun onBindViewHolder(holder: CrimeHolder, position: Int) {

            val crime = crimes[position]

            holder.bind(crime)

        }
    }
}