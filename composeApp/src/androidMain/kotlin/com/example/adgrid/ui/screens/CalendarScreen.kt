package com.example.adgrid.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adgrid.ui.component.TaskListCard
import com.example.adgrid.ui.model.*
import com.example.adgrid.ui.theme.*

@Composable
fun CalendarScreen() {

    val days = listOf(
        DayItem("Fri", 23),
        DayItem("Sat", 24),
        DayItem("Sun", 25),
        DayItem("Mon", 26),
        DayItem("Tue", 27)
    )

    val tasks = listOf(
        TaskItem(
            category = "Grocery shopping app design",
            title = "Market Research",
            time = "10:00 AM",
            status = TaskStatus.Done,
            color = Pink
        ),
        TaskItem(
            category = "Grocery shopping app design",
            title = "Competitive Analysis",
            time = "12:00 PM",
            status = TaskStatus.InProgress,
            color = Pink
        ),
        TaskItem(
            category = "Uber Eats redesign challenge",
            title = "Create Low-fidelity Wireframe",
            time = "07:00 PM",
            status = TaskStatus.ToDo,
            color = Purple
        ),
        TaskItem(
            category = "About design sprint",
            title = "How to pitch a Design Sprint",
            time = "09:00 PM",
            status = TaskStatus.ToDo,
            color = Yellow
        )
    )

    var selectedDay by remember { mutableStateOf(2) }
    var selectedFilter by remember { mutableStateOf(TaskFilter.All) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundGray)
            .padding(horizontal = 20.dp)
            .padding(top = 24.dp, bottom = 100.dp)
    ) {

        // ── Top Bar
        CalendarTopBar()

        Spacer(Modifier.height(20.dp))

        // ── Date Strip
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            days.forEachIndexed { index, day ->
                DayCell(
                    day = day,
                    isSelected = index == selectedDay,
                    onClick = { selectedDay = index }
                )
            }
        }

        Spacer(Modifier.height(20.dp))

        // ── Filter Tabs
        FilterTabRow(
            selectedFilter = selectedFilter,
            onFilterSelected = { selectedFilter = it }
        )

        Spacer(Modifier.height(16.dp))

        // ── Task List
        val filtered = when (selectedFilter) {
            TaskFilter.All -> tasks
            TaskFilter.ToDo -> tasks.filter { it.status == TaskStatus.ToDo }
            TaskFilter.InProgress -> tasks.filter { it.status == TaskStatus.InProgress }
            TaskFilter.Completed -> tasks.filter { it.status == TaskStatus.Done }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            filtered.forEach { task ->
                TaskListCard(task = task)
            }
        }
    }
}

// Calendar Top Bar

@Composable
private fun CalendarTopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back",
            tint = DarkNavy,
            modifier = Modifier
                .size(24.dp)
                .clickable { }
        )
        Text(
            text = "Today's Tasks",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = DarkNavy
        )
        Icon(
            imageVector = Icons.Filled.Notifications,
            contentDescription = "Notifications",
            tint = DarkNavy,
            modifier = Modifier.size(24.dp)
        )
    }
}

// Day Cell

@Composable
private fun DayCell(
    day: DayItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(14.dp))
            .background(if (isSelected) Purple else androidx.compose.ui.graphics.Color.Transparent)
            .clickable { onClick() }
            .padding(horizontal = 10.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = day.month,
            fontSize = 10.sp,
            color = if (isSelected) White.copy(alpha = 0.8f) else GrayText
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = "${day.date}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = if (isSelected) White else DarkNavy
        )
        Spacer(Modifier.height(2.dp))
        Text(
            text = day.dayName,
            fontSize = 11.sp,
            color = if (isSelected) White.copy(alpha = 0.85f) else GrayText
        )
    }
}

// Filter Tab Row

@Composable
private fun FilterTabRow(
    selectedFilter: TaskFilter,
    onFilterSelected: (TaskFilter) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(White)
            .padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        TaskFilter.values().forEach { filter ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (selectedFilter == filter) Purple else androidx.compose.ui.graphics.Color.Transparent)
                    .clickable { onFilterSelected(filter) }
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = filter.label(),
                    fontSize = 11.sp,
                    fontWeight = if (selectedFilter == filter) FontWeight.SemiBold else FontWeight.Normal,
                    color = if (selectedFilter == filter) White else GrayText
                )
            }
        }
    }
}
