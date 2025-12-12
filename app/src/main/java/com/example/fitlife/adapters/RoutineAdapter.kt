package com.example.fitlife.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitlife.databinding.ItemRoutineCardBinding
import com.example.fitlife.model.Routine

class RoutineAdapter(
    private val onItemClick: (Routine) -> Unit
) : RecyclerView.Adapter<RoutineAdapter.RoutineViewHolder>() {

    private var routines = listOf<Routine>()

    fun submitList(newList: List<Routine>) {
        routines = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutineViewHolder {
        val binding = ItemRoutineCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RoutineViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoutineViewHolder, position: Int) {
        holder.bind(routines[position])
    }

    override fun getItemCount() = routines.size

    inner class RoutineViewHolder(
        private val binding: ItemRoutineCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(routine: Routine) {
            binding.textRoutineName.text = routine.name
            binding.textRoutineDuration.text = routine.duration
            binding.textRoutineLevel.text = routine.level
            binding.imageRoutine.setImageResource(routine.imageResId)

            binding.root.setOnClickListener {
                onItemClick(routine)
            }
        }
    }
}