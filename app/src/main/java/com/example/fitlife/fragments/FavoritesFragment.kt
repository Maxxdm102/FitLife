package com.example.fitlife.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitlife.R
import com.example.fitlife.adapters.RoutineAdapter
import com.example.fitlife.databinding.FragmentFavoritesBinding
import com.example.fitlife.utils.DataSource

class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: RoutineAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = RoutineAdapter { routine ->
            // Navegar al detalle
        }

        binding.recyclerViewFavorites.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewFavorites.adapter = adapter

        val favorites = DataSource.getRoutines().filter { it.isFavorite }
        adapter.submitList(favorites)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}