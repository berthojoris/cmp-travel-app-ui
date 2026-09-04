package com.example.travelappui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelappui.model.DayItem
import com.example.travelappui.model.SpecItem
import com.example.travelappui.theme.TravelColors
import com.example.travelappui.theme.TravelTypography
import org.jetbrains.compose.resources.painterResource
import travelappui.shared.generated.resources.*

@Composable
fun YachtHeroImage(
    categoryBadgeText: String = "YACHT CHARTER",
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(315.dp)
            .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
    ) {
        // High-res Yacht Image
        Image(
            painter = painterResource(Res.drawable.img_azimut_yacht),
            contentDescription = "Azimut Grande 35M",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Overlay Badge on bottom-left
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 20.dp, bottom = 24.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(TravelColors.TealPrimary.copy(alpha = 0.92f))
                .padding(horizontal = 12.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF22C55E)) // Bright emerald dot
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = categoryBadgeText,
                style = TravelTypography.LabelEyebrow,
                fontSize = 11.sp,
                color = Color.White
            )
        }

        // Carousel Indicators at bottom-center
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(18.dp)
                    .height(4.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            )
            Box(
                modifier = Modifier
                    .size(4.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.5f))
            )
            Box(
                modifier = Modifier
                    .size(4.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.5f))
            )
        }
    }
}

@Composable
fun SpecsRow(
    specs: List<SpecItem>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        specs.forEach { spec ->
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                shape = RoundedCornerShape(14.dp),
                color = TravelColors.SurfaceWhite,
                border = BorderStroke(1.dp, TravelColors.SurfaceBorder),
                shadowElevation = 0.dp
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(spec.iconRes),
                        contentDescription = spec.label,
                        modifier = Modifier.size(18.dp),
                        tint = TravelColors.TextPrimary
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = spec.label,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = TravelColors.TextPrimary,
                        maxLines = 1
                    )
                }
            }
        }
    }
}

@Composable
fun SelectDatesSection(
    days: List<DayItem>,
    selectedDate: Int,
    onDateSelect: (Int) -> Unit,
    onViewCalendarClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Select Dates",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = TravelColors.TextPrimary
            )

            Text(
                text = "View calendar",
                fontSize = 13.sp,
                color = TravelColors.TextSecondary,
                modifier = Modifier.clickable { onViewCalendarClick() }
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Days row (7 days)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            days.forEach { day ->
                val isSelected = day.date == selectedDate
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clickable { onDateSelect(day.date) }
                        .padding(horizontal = 4.dp)
                ) {
                    Text(
                        text = day.dayOfWeek,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = TravelColors.TextMuted,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(
                                if (isSelected) TravelColors.TealPrimary else Color.Transparent
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = day.date.toString(),
                            fontSize = 14.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isSelected) Color.White else TravelColors.TextPrimary,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BookingBottomBar(
    priceText: String = "$28,500",
    unitText: String = "Per Day",
    onRequestBooking: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(TravelColors.SurfaceWhite)
            .border(
                border = BorderStroke(1.dp, TravelColors.SurfaceBorder),
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            )
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .padding(horizontal = 24.dp, vertical = 14.dp)
            .navigationBarsPadding()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Price info
            Column {
                Text(
                    text = priceText,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = TravelColors.TextPrimary
                )
                Text(
                    text = unitText,
                    fontSize = 12.sp,
                    color = TravelColors.TextMuted
                )
            }

            // CTA Button
            Button(
                onClick = onRequestBooking,
                modifier = Modifier.height(52.dp),
                shape = RoundedCornerShape(26.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = TravelColors.TealPrimary,
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                    hoveredElevation = 0.dp,
                    disabledElevation = 0.dp
                ),
                contentPadding = PaddingValues(horizontal = 24.dp, vertical = 0.dp)
            ) {
                Text(
                    text = "Request Booking",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(Res.drawable.ic_arrow_right),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = Color.White
                )
            }
        }
    }
}
