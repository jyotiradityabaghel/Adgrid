package com.example.adgrid.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adgrid.ui.theme.DarkNavy
import com.example.adgrid.ui.theme.Purple



@Composable
fun SectionHeader(
    title: String,
    count: Int,
    onSeeAll: () -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = DarkNavy
            )
            Spacer(Modifier.width(6.dp))
            CountBadge(count = count)
        }
        Text(
            text = "See all",
            fontSize = 13.sp,
            color = Purple,
            modifier = Modifier.clickable { onSeeAll() }
        )
    }
}