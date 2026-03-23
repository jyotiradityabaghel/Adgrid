package com.example.adgrid.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adgrid.ui.theme.*


@Composable
fun CountBadge(count: Int) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(Purple)
            .padding(horizontal = 7.dp, vertical = 2.dp)
    ) {
        Text(
            text = "$count",
            fontSize = 11.sp,
            color = White,
            fontWeight = FontWeight.Bold
        )
    }
}