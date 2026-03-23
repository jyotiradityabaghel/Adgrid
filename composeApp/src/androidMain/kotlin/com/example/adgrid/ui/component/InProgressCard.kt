package com.example.adgrid.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adgrid.ui.model.TaskCardData
import com.example.adgrid.ui.theme.CardWhite
import com.example.adgrid.ui.theme.DarkNavy


@Composable
fun InProgressCard(task: TaskCardData, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardWhite),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            CategoryChip(label = task.category, color = task.color)
            Spacer(Modifier.height(8.dp))
            Text(
                text = task.title,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = DarkNavy,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 18.sp
            )
            Spacer(Modifier.height(12.dp))
            LinearProgressBar(progress = task.progress, color = task.color)
        }
    }
}

