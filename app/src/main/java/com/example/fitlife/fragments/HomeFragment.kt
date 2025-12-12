package com.example.fitlife.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController // ← AÑADE ESTA IMPORTACIÓN
import com.example.fitlife.R
import com.example.fitlife.databinding.FragmentHomeBinding
import com.example.fitlife.utils.NotificationHelper

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRoutines.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_routinesFragment)
        }

        binding.btnFavorites.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_favoritesFragment)
        }

        binding.btnNotify.setOnClickListener {
            NotificationHelper.sendWorkoutNotification(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}