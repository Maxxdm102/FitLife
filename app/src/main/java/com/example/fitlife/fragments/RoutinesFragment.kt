package com.example.fitlife.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController // ← AÑADE ESTA IMPORTACIÓN
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitlife.R
import com.example.fitlife.adapters.RoutineAdapter
import com.example.fitlife.databinding.FragmentRoutinesBinding
import com.example.fitlife.model.Routine
import com.example.fitlife.utils.DataSource

class RoutinesFragment : Fragment() {

    private var _binding: FragmentRoutinesBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: RoutineAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRoutinesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = RoutineAdapter { routine ->
            navigateToDetail(routine)
        }

        binding.recyclerViewRoutines.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewRoutines.adapter = adapter

        adapter.submitList(DataSource.getRoutines())
    }

    private fun navigateToDetail(routine: Routine) {
        val bundle = Bundle().apply {
            putSerializable("routine", routine)
        }
        findNavController().navigate(R.id.action_routinesFragment_to_routineDetailFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}