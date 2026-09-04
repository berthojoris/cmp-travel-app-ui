package com.example.travelappui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelappui.model.ConciergeBooking
import com.example.travelappui.model.QuickAccessItem
import com.example.travelappui.theme.TravelColors
import org.jetbrains.compose.resources.painterResource

@Composable
fun ConciergeSection(
    bookings: List<ConciergeBooking>,
    onViewAllClick: () -> Unit = {},
    onBookingClick: (ConciergeBooking) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        // Section Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Your Concierge",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = TravelColors.TextPrimary
            )

            Text(
                text = "View all",
                fontSize = 13.sp,
                color = TravelColors.TextSecondary,
                modifier = Modifier.clickable { onViewAllClick() }
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Booking Cards
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            bookings.forEach { booking ->
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(18.dp))
                        .clickable { onBookingClick(booking) },
                    shape = RoundedCornerShape(18.dp),
                    color = TravelColors.SurfaceWhite,
                    border = BorderStroke(1.dp, TravelColors.SurfaceBorder),
                    shadowElevation = 0.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f, fill = false)
                        ) {
                            // Icon Box
                            Box(
                                modifier = Modifier
                                    .size(46.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(TravelColors.SurfaceElevated),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(booking.iconRes),
                                    contentDescription = booking.title,
                                    modifier = Modifier.size(22.dp),
                                    tint = TravelColors.TextPrimary
                                )
                            }

                            Spacer(modifier = Modifier.width(14.dp))

                            // Text Column
                            Column {
                                Text(
                                    text = booking.title,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = TravelColors.TextPrimary,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Spacer(modifier = Modifier.height(3.dp))
                                Text(
                                    text = booking.subtitle,
                                    fontSize = 12.sp,
                                    color = TravelColors.TextSecondary,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }

                        // Right Status or Time
                        if (booking.status != null) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(TravelColors.MintBadgeBg)
                                    .padding(horizontal = 10.dp, vertical = 5.dp)
                            ) {
                                Text(
                                    text = booking.status,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = TravelColors.MintBadgeText
                                )
                            }
                        } else if (booking.time != null) {
                            Text(
                                text = booking.time,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Medium,
                                color = TravelColors.TextSecondary
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun QuickAccessSection(
    items: List<QuickAccessItem>,
    onItemClick: (QuickAccessItem) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = "Quick Access",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = TravelColors.TextPrimary
        )

        Spacer(modifier = Modifier.height(14.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            items.forEach { item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onItemClick(item) }
                ) {
                    Box(
                        modifier = Modifier
                            .size(54.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(TravelColors.SurfaceWhite)
                            .border(BorderStroke(1.dp, TravelColors.SurfaceBorder), RoundedCornerShape(16.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(item.iconRes),
                            contentDescription = item.label,
                            modifier = Modifier.size(22.dp),
                            tint = TravelColors.TextPrimary
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = item.label,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Normal,
                        color = TravelColors.TextSecondary,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}
