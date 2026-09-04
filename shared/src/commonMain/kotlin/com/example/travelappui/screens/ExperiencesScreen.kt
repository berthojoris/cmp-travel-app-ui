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
fun ExperiencesScreen(
    onBackClick: () -> Unit,
    onNavigateToYachtDetail: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedCategoryId by remember { mutableStateOf("all") }
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(TravelColors.Background)
            .verticalScroll(scrollState)
    ) {
        // Sticky/Top Header
        ExperiencesTopBar(
            onBackClick = onBackClick,
            onToggleView = { /* Toggle Grid/List layout */ }
        )

        // Horizontal Category Filter Row
        CategoryFilterRow(
            categories = TravelMockData.categories,
            selectedCategoryId = selectedCategoryId,
            onCategorySelect = { selectedCategoryId = it }
        )

        Spacer(modifier = Modifier.height(14.dp))

        // Live Extraordinary Hero Banner
        LiveExtraordinaryHeroCard(
            onExploreClick = onNavigateToYachtDetail
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Top Experiences Section (2x2 Grid)
        TopExperiencesSection(
            items = TravelMockData.topExperiences,
            onItemClick = { item ->
                onNavigateToYachtDetail()
            },
            onViewAllClick = { /* View all experiences */ }
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}
