package com.example.travelappui

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.travelappui.components.TravelBottomNavigation
import com.example.travelappui.model.NavigationTab
import com.example.travelappui.model.ScreenType
import com.example.travelappui.screens.ExperiencesScreen
import com.example.travelappui.screens.HomeScreen
import com.example.travelappui.screens.YachtDetailScreen
import com.example.travelappui.theme.TravelAppTheme
import com.example.travelappui.theme.TravelColors
import com.example.travelappui.util.BackHandler

@Composable
fun App() {
    TravelAppTheme {
        var currentScreen by remember { mutableStateOf(ScreenType.HOME) }
        var currentTab by remember { mutableStateOf(NavigationTab.Home) }
        var previousScreen by remember { mutableStateOf(ScreenType.HOME) }
        var showBookingConfirmation by remember { mutableStateOf(false) }

        // Intercept Android System Back Button / Gestures
        val canHandleBack = showBookingConfirmation || currentScreen != ScreenType.HOME || currentTab != NavigationTab.Home
        BackHandler(enabled = canHandleBack) {
            when {
                showBookingConfirmation -> {
                    showBookingConfirmation = false
                }
                currentScreen == ScreenType.YACHT_DETAIL -> {
                    currentScreen = previousScreen
                    if (previousScreen == ScreenType.HOME) {
                        currentTab = NavigationTab.Home
                    }
                }
                currentScreen == ScreenType.EXPERIENCES -> {
                    currentScreen = ScreenType.HOME
                    currentTab = NavigationTab.Home
                }
                currentTab != NavigationTab.Home -> {
                    currentTab = NavigationTab.Home
                }
            }
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = TravelColors.Background,
            bottomBar = {
                // Bottom navigation is visible on Home and Experiences screens (matching the mockup)
                if (currentScreen != ScreenType.YACHT_DETAIL) {
                    TravelBottomNavigation(
                        currentTab = currentTab,
                        onTabSelected = { tab ->
                            currentTab = tab
                            when (tab) {
                                NavigationTab.Home -> currentScreen = ScreenType.HOME
                                NavigationTab.Bookings -> currentScreen = ScreenType.EXPERIENCES
                                NavigationTab.Wishlist -> currentScreen = ScreenType.EXPERIENCES
                                NavigationTab.Profile -> currentScreen = ScreenType.HOME
                            }
                        }
                    )
                }
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = if (currentScreen == ScreenType.YACHT_DETAIL) 0.dp else paddingValues.calculateTopPadding(),
                        bottom = paddingValues.calculateBottomPadding()
                    )
            ) {
                when (currentScreen) {
                    ScreenType.HOME -> {
                        HomeScreen(
                            onNavigateToExperiences = {
                                previousScreen = ScreenType.HOME
                                currentScreen = ScreenType.EXPERIENCES
                                currentTab = NavigationTab.Bookings
                            },
                            onNavigateToYachtDetail = {
                                previousScreen = ScreenType.HOME
                                currentScreen = ScreenType.YACHT_DETAIL
                            }
                        )
                    }

                    ScreenType.EXPERIENCES -> {
                        ExperiencesScreen(
                            onBackClick = {
                                currentScreen = ScreenType.HOME
                                currentTab = NavigationTab.Home
                            },
                            onNavigateToYachtDetail = {
                                previousScreen = ScreenType.EXPERIENCES
                                currentScreen = ScreenType.YACHT_DETAIL
                            }
                        )
                    }

                    ScreenType.YACHT_DETAIL -> {
                        YachtDetailScreen(
                            onBackClick = {
                                currentScreen = previousScreen
                            },
                            onRequestBooking = {
                                showBookingConfirmation = true
                            }
                        )
                    }
                }

                // Booking confirmation dialog
                if (showBookingConfirmation) {
                    AlertDialog(
                        onDismissRequest = { showBookingConfirmation = false },
                        containerColor = TravelColors.SurfaceWhite,
                        title = {
                            Text(
                                text = "Booking Requested!",
                                style = MaterialTheme.typography.titleLarge,
                                color = TravelColors.TextPrimary
                            )
                        },
                        text = {
                            Text(
                                text = "Your booking request for Azimut Grande 35M on 15 May has been submitted to your concierge. You will receive a confirmation shortly.",
                                style = MaterialTheme.typography.bodyMedium,
                                color = TravelColors.TextSecondary
                            )
                        },
                        confirmButton = {
                            TextButton(
                                onClick = { showBookingConfirmation = false },
                                colors = ButtonDefaults.textButtonColors(
                                    contentColor = TravelColors.TealPrimary
                                )
                            ) {
                                Text("Done")
                            }
                        }
                    )
                }
            }
        }
    }
}