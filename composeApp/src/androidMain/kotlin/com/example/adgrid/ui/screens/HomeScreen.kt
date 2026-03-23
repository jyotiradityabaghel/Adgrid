package com.example.adgrid.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adgrid.ui.component.CircularProgressRing
import com.example.adgrid.ui.component.InProgressCard
import com.example.adgrid.ui.component.SectionHeader
import com.example.adgrid.ui.component.TaskGroupCard
import com.example.adgrid.ui.model.TaskCardData
import com.example.adgrid.ui.model.TaskGroupData
import com.example.adgrid.ui.theme.*


@Composable
fun HomeScreen() {

    val inProgressTasks = listOf(
        TaskCardData(
            category = "Office Project",
            title = "Grocery shopping app design",
            progress = 0.6f,
            color = Purple
        ),
        TaskCardData(
            category = "Personal Project",
            title = "Uber Eats redesign challenge",
            progress = 0.45f,
            color = Pink
        )
    )

    val taskGroups = listOf(
        TaskGroupData("🛒", "Office Project", 23, 70, Purple),
        TaskGroupData("💼", "Personal Project", 30, 52, Pink),
        TaskGroupData("📚", "Daily Study",      30, 87, Yellow),
        TaskGroupData("🎯", "Side Project",     15, 40, Green)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundGray)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp)
            .padding(top = 24.dp, bottom = 100.dp)
    ) {

        // ── Header
        HomeHeader()

        Spacer(Modifier.height(20.dp))

        // ── Progress Banner
        ProgressBanner(percent = 85)

        Spacer(Modifier.height(24.dp))

        // ── In Progress Section
        SectionHeader(title = "In Progress", count = 6)

        Spacer(Modifier.height(14.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            inProgressTasks.forEach { task ->
                InProgressCard(task = task, modifier = Modifier.weight(1f))
            }
        }

        Spacer(Modifier.height(24.dp))

        // ── Task Groups Section
        SectionHeader(title = "Task Groups", count = 4)

        Spacer(Modifier.height(14.dp))

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            taskGroups.forEach { group ->
                TaskGroupCard(group = group)
            }
        }
    }
}

// ─── Home Header

@Composable
private fun HomeHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(PurpleSurface),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "LV",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Purple
                )
            }
            Spacer(Modifier.width(12.dp))
            Column {
                Text(
                    text = "Hello!",
                    fontSize = 12.sp,
                    color = GrayText
                )
                Text(
                    text = "Livia Vaccaro",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkNavy
                )
            }
        }
        Icon(
            imageVector = Icons.Filled.Notifications,
            contentDescription = "Notifications",
            tint = DarkNavy,
            modifier = Modifier.size(24.dp)
        )
    }
}

// ─── Progress Banner

@Composable
private fun ProgressBanner(percent: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Purple)
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Your today's task\nalmost done!",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = White,
                    lineHeight = 22.sp
                )
                Spacer(Modifier.height(14.dp))
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = White),
                    contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = "View Task",
                        color = Purple,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
            CircularProgressRing(percent = percent)
        }
    }
}
