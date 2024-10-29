package com.headoncloud.personalproject.criminalintent_review

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.headoncloud.personalproject.criminalintent_review.databinding.FragmentCrimeListBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

private const val TAG = "CrimeListIntent"

class CrimeListFragment : Fragment() {
    private val crimeListViewmodel: CrimeListViewmodel by viewModels()

    private var _binding: FragmentCrimeListBinding? = null
    private val binding
        get() = checkNotNull(_binding)

    private var job: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCrimeListBinding.inflate(inflater, container, false)

        binding.crimeRecyclerView.layoutManager = LinearLayoutManager(this.context)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
//                val crimes = crimeListViewmodel.loadCrimes()
                crimeListViewmodel.crimes.collect{ crimes ->
                    binding.crimeRecyclerView.adapter = CrimeListAdapter(crimes)
                }

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStart() {
        super.onStart()
        /*job = viewLifecycleOwner.lifecycleScope.launch {
            val crimes = crimeListViewmodel.loadCrimes()
            binding.crimeRecyclerView.adapter = CrimeListAdapter(crimes)
        }*/
    }

    override fun onStop() {
        super.onStop()
//        job?.cancel()
    }
}