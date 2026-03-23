package com.example.adgrid.ui.model

import androidx.compose.ui.graphics.Color

// Task Models

data class TaskCardData(
    val category: String,
    val title: String,
    val progress: Float,
    val color: Color,
    val tag: String = ""
)

data class TaskGroupData(
    val icon: String,
    val title: String,
    val taskCount: Int,
    val percent: Int,
    val color: Color
)

data class TaskItem(
    val category: String,
    val title: String,
    val time: String,
    val status: TaskStatus,
    val color: Color
)

//Enums

enum class TaskStatus { Done, InProgress, ToDo }

enum class TaskFilter {
    All, ToDo, InProgress, Completed;

    fun label(): String = when (this) {
        All -> "All"
        ToDo -> "To do"
        InProgress -> "In Progress"
        Completed -> "Completed"
    }
}

// Navigation

data class DayItem(
    val dayName: String,
    val date: Int,
    val month: String = "May"
)