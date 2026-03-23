package com.example.adgrid.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adgrid.ui.model.TaskGroupData
import com.example.adgrid.ui.theme.*

@Composable
fun TaskGroupCard(group: TaskGroupData) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = CardWhite),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(group.color.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = group.icon, fontSize = 20.sp)
            }
            Spacer(Modifier.width(14.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = group.title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = DarkNavy
                )
                Text(
                    text = "${group.taskCount} Tasks",
                    fontSize = 12.sp,
                    color = GrayText
                )
            }
            MiniDonutChart(percent = group.percent, color = group.color)
        }
    }
}