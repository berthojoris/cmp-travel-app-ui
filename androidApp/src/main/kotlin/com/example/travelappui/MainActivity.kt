package com.example.travelappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }
    }
}

@Preview(showBackground = true, name = "Full App Flow")
@Composable
fun AppAndroidPreview() {
    App()
}

@Preview(showBackground = true, name = "Screen 1 - Home")
@Composable
fun HomeScreenPreview() {
    com.example.travelappui.theme.TravelAppTheme {
        com.example.travelappui.screens.HomeScreen(
            onNavigateToExperiences = {},
            onNavigateToYachtDetail = {}
        )
    }
}

@Preview(showBackground = true, name = "Screen 2 - Experiences")
@Composable
fun ExperiencesScreenPreview() {
    com.example.travelappui.theme.TravelAppTheme {
        com.example.travelappui.screens.ExperiencesScreen(
            onBackClick = {},
            onNavigateToYachtDetail = {}
        )
    }
}

@Preview(showBackground = true, name = "Screen 3 - Yacht Detail")
@Composable
fun YachtDetailScreenPreview() {
    com.example.travelappui.theme.TravelAppTheme {
        com.example.travelappui.screens.YachtDetailScreen(
            onBackClick = {}
        )
    }
}