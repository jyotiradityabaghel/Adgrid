package com.example.adgrid.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adgrid.ui.model.TaskStatus
import com.example.adgrid.ui.theme.Green
import com.example.adgrid.ui.theme.GreenLight
import com.example.adgrid.ui.theme.Pink
import com.example.adgrid.ui.theme.PinkLight
import com.example.adgrid.ui.theme.Purple
import com.example.adgrid.ui.theme.PurpleLight

@Composable
fun StatusBadge(status: TaskStatus) {
    val label: String
    val bgColor: Color
    val textColor: Color

    when (status) {
        TaskStatus.Done -> {
            label = "Done"
            bgColor = GreenLight
            textColor = Green
        }
        TaskStatus.InProgress -> {
            label = "In Progress"
            bgColor = PinkLight
            textColor = Pink
        }
        TaskStatus.ToDo -> {
            label = "To-do"
            bgColor = PurpleLight
            textColor = Purple
        }
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(bgColor)
            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Text(
            text = label,
            fontSize = 11.sp,
            color = textColor,
            fontWeight = FontWeight.SemiBold
        )
    }
}