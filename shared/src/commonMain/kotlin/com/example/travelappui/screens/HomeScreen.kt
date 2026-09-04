package com.example.travelappui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.travelappui.components.*
import com.example.travelappui.model.TravelMockData
import com.example.travelappui.theme.TravelColors

@Composable
fun HomeScreen(
    onNavigateToExperiences: () -> Unit,
    onNavigateToYachtDetail: () -> Unit,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(TravelColors.Background)
            .verticalScroll(scrollState)
    ) {
        // Sticky/Top Header
        HomeTopBar(
            onAvatarClick = { /* Profile action */ },
            onNotificationClick = { /* Notification action */ }
        )

        // Search & Filter
        SearchBarRow(
            query = searchQuery,
            onQueryChange = { searchQuery = it },
            onFilterClick = { onNavigateToExperiences() }
        )

        Spacer(modifier = Modifier.height(14.dp))

        // Summer Collection Hero Banner
        SummerCollectionHeroCard(
            onExploreClick = onNavigateToExperiences
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Your Concierge Section
        ConciergeSection(
            bookings = TravelMockData.conciergeBookings,
            onViewAllClick = { /* View all bookings */ },
            onBookingClick = { booking ->
                if (booking.title.contains("Jet", ignoreCase = true)) {
                    onNavigateToExperiences()
                }
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Quick Access Section
        QuickAccessSection(
            items = TravelMockData.quickAccessItems,
            onItemClick = { item ->
                when (item.id) {
                    "2" -> onNavigateToYachtDetail() // Yacht Charter
                    "5" -> onNavigateToExperiences() // View All
                    else -> onNavigateToExperiences()
                }
            }
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}
