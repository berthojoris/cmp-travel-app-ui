package com.example.travelappui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelappui.components.*
import com.example.travelappui.model.TravelMockData
import com.example.travelappui.theme.TravelColors
import com.example.travelappui.theme.TravelTypography
import org.jetbrains.compose.resources.painterResource
import travelappui.shared.generated.resources.*

@Composable
fun YachtDetailScreen(
    onBackClick: () -> Unit,
    onRequestBooking: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var selectedDate by remember { mutableStateOf(15) }
    var isFavorite by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(TravelColors.SurfaceWhite)
    ) {
        // Main Scrollable Body
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            // Hero Image with category badge and indicators
            YachtHeroImage(
                categoryBadgeText = "YACHT CHARTER"
            )

            // Content Area
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 18.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Location & Flag Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_location),
                            contentDescription = "Location",
                            modifier = Modifier.size(16.dp),
                            tint = TravelColors.TextSecondary
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Amalfi Coast, Italy",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = TravelColors.TextSecondary
                        )
                    }

                    // Italy Flag
                    Image(
                        painter = painterResource(Res.drawable.ic_flag_italy),
                        contentDescription = "Italy Flag",
                        modifier = Modifier
                            .width(26.dp)
                            .height(18.dp)
                            .clip(RoundedCornerShape(3.dp))
                    )
                }

                // Title
                Text(
                    text = "Azimut Grande 35M",
                    style = TravelTypography.DisplayMediumSerif,
                    color = TravelColors.TextPrimary
                )

                // Description
                Text(
                    text = "A masterpiece of Italian design and luxury. Spacious, elegant, unforgettable.",
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    color = TravelColors.TextSecondary
                )

                // Specs Row (10 Guests, 5 Cabins, 6 Crew)
                SpecsRow(specs = TravelMockData.yachtSpecs)

                Spacer(modifier = Modifier.height(4.dp))

                // Select Dates Section
                SelectDatesSection(
                    days = TravelMockData.calendarDays,
                    selectedDate = selectedDate,
                    onDateSelect = { selectedDate = it },
                    onViewCalendarClick = { /* Open full calendar */ }
                )

                // Bottom padding to ensure scrollable content isn't obscured by bottom bar
                Spacer(modifier = Modifier.height(84.dp))
            }
        }

        // Floating / Overlay Top Bar (Back, Favorite, Share)
        DetailTopBar(
            onBackClick = onBackClick,
            onFavoriteClick = { isFavorite = !isFavorite },
            onShareClick = { /* Share */ },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .statusBarsPadding()
        )

        // Sticky Bottom Booking Bar
        BookingBottomBar(
            priceText = "$28,500",
            unitText = "Per Day",
            onRequestBooking = onRequestBooking,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}
