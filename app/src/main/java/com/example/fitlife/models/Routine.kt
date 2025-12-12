package com.example.fitlife.model

import java.io.Serializable

data class Routine(
    val id: Int,
    val name: String,
    val description: String,
    val duration: String, // ej: "10 min"
    val level: String, // "Principiante", "Intermedio", "Avanzado"
    val imageResId: Int,
    val steps: List<String>,
    val isFavorite: Boolean = false
) : Serializable