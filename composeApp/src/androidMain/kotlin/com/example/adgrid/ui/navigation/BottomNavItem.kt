package com.example.adgrid.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.adgrid.ui.theme.*

data class BottomNavItem(
    val icon: ImageVector,
    val label: String
)

val bottomNavItems = listOf(
    BottomNavItem(Icons.Filled.Home,          "Home"),
    BottomNavItem(Icons.Filled.CalendarToday, "Calendar"),
    BottomNavItem(Icons.Filled.Add,           "Add"),
    BottomNavItem(Icons.Filled.BarChart,      "Stats"),
    BottomNavItem(Icons.Filled.Person,        "Profile")
)



@Composable
fun CMPBottomNavBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            bottomNavItems.forEachIndexed { index, item ->
                if (index == 2) {
                    // FAB-style center Add button
                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .clip(CircleShape)
                            .background(Purple),
                        contentAlignment = Alignment.Center
                    ) {
                        IconButton(onClick = { onItemSelected(index) }) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.label,
                                tint = White,
                                modifier = Modifier.size(28.dp)
                            )
                        }
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                if (selectedIndex == index) PurpleLight else androidx.compose.ui.graphics.Color.Transparent
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        IconButton(onClick = { onItemSelected(index) }) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.label,
                                tint = if (selectedIndex == index) Purple else GrayText,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
