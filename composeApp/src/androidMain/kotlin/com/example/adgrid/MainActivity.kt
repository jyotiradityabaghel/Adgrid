package com.example.adgrid


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.adgrid.ui.navigation.CMPBottomNavBar
import com.example.adgrid.ui.screens.CalendarScreen
import com.example.adgrid.ui.screens.HomeScreen
import com.example.adgrid.ui.theme.BackgroundGray
import com.example.adgrid.ui.theme.CMPTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CMPTheme {
                CMPApp()
            }
        }
    }
}

@Composable
fun CMPApp() {
    var selectedNavIndex by remember { mutableStateOf(0) }

    Scaffold(
        containerColor = BackgroundGray,
        bottomBar = {
            CMPBottomNavBar(
                selectedIndex = selectedNavIndex,
                onItemSelected = { selectedNavIndex = it }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (selectedNavIndex) {
                0 -> HomeScreen()
                1 -> CalendarScreen()
                else -> HomeScreen()
            }
        }
    }
}
