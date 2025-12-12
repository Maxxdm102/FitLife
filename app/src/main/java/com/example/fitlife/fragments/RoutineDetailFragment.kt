package com.example.fitlife.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fitlife.R
import com.example.fitlife.databinding.FragmentRoutineDetailBinding
import com.example.fitlife.model.Routine
import com.google.android.material.snackbar.Snackbar

class RoutineDetailFragment : Fragment() {

    private var _binding: FragmentRoutineDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var routine: Routine

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRoutineDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        routine = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable("routine", Routine::class.java)!!
        } else {
            @Suppress("DEPRECATION")
            arguments?.getSerializable("routine") as Routine
        }

        binding.textDetailName.text = routine.name
        binding.textDetailDescription.text = routine.description
        binding.textDetailDuration.text = routine.duration
        binding.textDetailLevel.text = routine.level
        binding.imageDetail.setImageResource(routine.imageResId)

        // Mostrar pasos
        val stepsText = routine.steps.joinToString("\n\n") { "• $it" }
        binding.textDetailSteps.text = stepsText

        binding.fabComplete.setOnClickListener {
            Snackbar.make(binding.root, "¡Rutina completada! +10 puntos", Snackbar.LENGTH_LONG)
                .setAction("DESHACER") {
                    // Acción de deshacer
                }
                .show()
        }

        binding.fabFavorite.setOnClickListener {
            // Aquí podrías abrir un DialogFragment de confirmación
            Snackbar.make(binding.root, "Añadido a favoritos", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}