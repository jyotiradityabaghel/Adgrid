package com.example.adgrid


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.background
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


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundGray)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp)
        ) {
            when (selectedNavIndex) {
                0 -> HomeScreen()
                1 -> CalendarScreen()
                else -> HomeScreen()
            }
        }


        CMPBottomNavBar(
            selectedIndex = selectedNavIndex,
            onItemSelected = { selectedNavIndex = it },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )
    }
}