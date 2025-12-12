package com.example.fitlife.utils

import com.example.fitlife.R
import com.example.fitlife.model.Routine

object DataSource {

    fun getRoutines(): List<Routine> = listOf(
        Routine(
            id = 1,
            name = "Flexiones de pecho",
            description = "Ejercicio clásico para fortalecer pecho y brazos.",
            duration = "3 series x 15 repeticiones",
            level = "Principiante",
            imageResId = R.drawable.img_pushup,
            steps = listOf(
                "Colócate en posición de plancha.",
                "Baja el cuerpo manteniendo la espalda recta.",
                "Vuelve a la posición inicial."
            ),
            isFavorite = true
        ),
        Routine(
            id = 2,
            name = "Sentadillas",
            description = "Ejercicio fundamental para piernas y glúteos.",
            duration = "4 series x 20 repeticiones",
            level = "Intermedio",
            imageResId = R.drawable.img_squat,
            steps = listOf(
                "Pies separados al ancho de hombros.",
                "Baja como si fueras a sentarte.",
                "Mantén la espalda recta."
            ),
            isFavorite = false
        ),
        // Añade más rutinas...
    )
}