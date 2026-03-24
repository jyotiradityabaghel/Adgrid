package com.example.adgrid.ui.navigation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.adgrid.ui.theme.Purple
import com.example.adgrid.ui.theme.White


//  Nav Item Model

data class BottomNavItem(
    val icon: ImageVector,
    val label: String
)

val bottomNavItems = listOf(
    BottomNavItem(Icons.Filled.Home,          "Home"),
    BottomNavItem(Icons.Filled.CalendarToday, "Calendar"),
    BottomNavItem(Icons.Filled.Add,           "Add"),
    BottomNavItem(Icons.Filled.Article,       "Notes"),
    BottomNavItem(Icons.Filled.Person,        "Profile")
)

//  Bottom Nav Bar with Center Docked FAB

@Composable
fun CMPBottomNavBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val barHeight    = 64.dp
    val fabSize      = 40.dp
    val notchRadius  = 20.dp
    val fabElevation = 6.dp

    val totalHeight  = barHeight + 12.dp

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(totalHeight),
        contentAlignment = Alignment.BottomCenter
    ) {

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(barHeight)
                .align(Alignment.BottomCenter)
        ) {
            drawNotchedBar(
                size = size,
                notchRadius = notchRadius.toPx(),
                cornerRadius = 28.dp.toPx(),
                color = Color(0xFFF0EEFF)
            )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(barHeight)
                .align(Alignment.BottomCenter)
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                listOf(0, 1).forEach { index ->
                    NavIconButton(
                        item = bottomNavItems[index],
                        isSelected = selectedIndex == index,
                        onClick = { onItemSelected(index) }
                    )
                }
            }


            Spacer(Modifier.width(fabSize + 16.dp))


            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                listOf(3, 4).forEach { index ->
                    NavIconButton(
                        item = bottomNavItems[index],
                        isSelected = selectedIndex == index,
                        onClick = { onItemSelected(index) }
                    )
                }
            }
        }

        //  Center Docked FAB
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(fabSize)
                .shadow(elevation = fabElevation, shape = CircleShape, clip = false)
                .clip(CircleShape)
                .background(Purple),
            contentAlignment = Alignment.Center
        ) {
            IconButton(onClick = { onItemSelected(2) }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add",
                    tint = White,
                    modifier = Modifier.size(26.dp)
                )
            }
        }
    }
}

//  Canvas: draw bar with circular notch cut out of center top

private fun DrawScope.drawNotchedBar(
    size: Size,
    notchRadius: Float,
    cornerRadius: Float,
    color: Color
) {
    val centerX = size.width / 2f
    val notchMargin = 8f
    val r = notchRadius + notchMargin

    val path = Path().apply {

        moveTo(cornerRadius, 0f)


        lineTo(centerX - r - cornerRadius, 0f)


        quadraticBezierTo(
            centerX - r, 0f,
            centerX - r, r * 0.6f
        )


        arcTo(
            rect = Rect(
                center = Offset(centerX, r * 0.6f),
                radius = r
            ),
            startAngleDegrees = 180f,
            sweepAngleDegrees = -180f,
            forceMoveTo = false
        )


        quadraticBezierTo(
            centerX + r, 0f,
            centerX + r + cornerRadius, 0f
        )


        lineTo(size.width - cornerRadius, 0f)


        arcTo(
            rect = Rect(
                offset = Offset(size.width - cornerRadius * 2, 0f),
                size = Size(cornerRadius * 2, cornerRadius * 2)
            ),
            startAngleDegrees = -90f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )


        lineTo(size.width, size.height)


        lineTo(0f, size.height)


        lineTo(0f, cornerRadius)


        arcTo(
            rect = Rect(
                offset = Offset(0f, 0f),
                size = Size(cornerRadius * 2, cornerRadius * 2)
            ),
            startAngleDegrees = 180f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )

        close()
    }

    drawPath(path = path, color = color)
}

//  Single Nav Icon Button

@Composable
private fun NavIconButton(
    item: BottomNavItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(44.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(
                if (isSelected) Purple.copy(alpha = 0.13f) else Color.Transparent
            ),
        contentAlignment = Alignment.Center
    ) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.label,
                tint = if (isSelected) Purple else Color(0xFFAEA9C8),
                modifier = Modifier.size(22.dp)
            )
        }
    }
}