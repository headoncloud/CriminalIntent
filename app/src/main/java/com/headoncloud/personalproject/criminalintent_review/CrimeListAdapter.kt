package com.headoncloud.personalproject.criminalintent_review

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.headoncloud.personalproject.criminalintent_review.databinding.ListItemCrimeBinding
import com.headoncloud.personalproject.criminalintent_review.databinding.ListItemCrimeRequirePoliceBinding
import java.text.DateFormat
import java.util.Date

private const val ITEM_CRIME_NORMAL = 0
private const val ITEM_CRIME_NORMAL_REQUIRES_POLICE = 1

class CrimeViewHolder(
    private val binding: ListItemCrimeBinding
) : RecyclerView.ViewHolder(binding.root){
    fun bind(crime: Crime){
        binding.crimeTitle.text = crime.title
        val textDateFormat = android.text.format.DateFormat.format("EEEE, MMMM d, yyyy", crime.date)
        binding.crimeDate.text = textDateFormat

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.imgCrimeSolved.visibility = if(crime.isSolved){
            View.VISIBLE
        }else{
            View.GONE
        }
    }
}

/*class CrimeRequiresPoliceViewHolder(
    private val binding: ListItemCrimeRequirePoliceBinding
) : ViewHolder(binding.root){
    fun bind(crime: Crime){
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} REQUIRE POLICE",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.imgCrimeSolved.visibility = if(crime.isSolved){
            View.VISIBLE
        }else{
            View.GONE
        }
    }
}*/

class CrimeListAdapter(
    val listCrime: List<Crime>
) : Adapter<ViewHolder>(){

    /*override fun getItemViewType(position: Int): Int {
        return when{
            listCrime[position].requiresPolice -> ITEM_CRIME_NORMAL_REQUIRES_POLICE
            else -> ITEM_CRIME_NORMAL
        }
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        /*if(viewType == ITEM_CRIME_NORMAL){
            val inflater = LayoutInflater.from(parent.context)
            val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
            return CrimeViewHolder(binding)
        }else {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ListItemCrimeRequirePoliceBinding.inflate(inflater, parent, false)
            return CrimeRequiresPoliceViewHolder(binding)
        }*/

        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
        return CrimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val crimeItem = listCrime[position]
        /*if(getItemViewType(position) == ITEM_CRIME_NORMAL){
            holder as CrimeViewHolder
            holder.bind(crimeItem)
        }else{
            holder as CrimeRequiresPoliceViewHolder
            holder.bind(crimeItem)
        }*/
        holder as CrimeViewHolder
        holder.bind(crimeItem)
    }

    override fun getItemCount(): Int {
        return listCrime.size
    }


}