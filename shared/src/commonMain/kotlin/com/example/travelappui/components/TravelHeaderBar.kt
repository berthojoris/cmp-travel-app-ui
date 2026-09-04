package com.example.travelappui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelappui.theme.TravelColors
import org.jetbrains.compose.resources.painterResource
import travelappui.shared.generated.resources.*

@Composable
fun HomeTopBar(
    onAvatarClick: () -> Unit = {},
    onNotificationClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Left: Avatar + Greeting
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(Res.drawable.img_avatar),
                contentDescription = "User Avatar",
                modifier = Modifier
                    .size(46.dp)
                    .clip(CircleShape)
                    .border(1.dp, TravelColors.SurfaceBorder, CircleShape)
                    .clickable { onAvatarClick() },
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = "Welcome back,",
                    fontSize = 13.sp,
                    color = TravelColors.TextSecondary
                )
                Text(
                    text = "Olivia Carter",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = TravelColors.TextPrimary
                )
            }
        }

        // Right: Notification Bell Button
        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(TravelColors.SurfaceWhite)
                .border(BorderStroke(1.dp, TravelColors.SurfaceBorder), CircleShape)
                .clickable { onNotificationClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_bell),
                contentDescription = "Notifications",
                modifier = Modifier.size(20.dp),
                tint = TravelColors.TextPrimary
            )

            // Tiny badge dot
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 11.dp, end = 12.dp)
                    .size(6.dp)
                    .clip(CircleShape)
                    .background(TravelColors.TealPrimary)
            )
        }
    }
}

@Composable
fun ExperiencesTopBar(
    onBackClick: () -> Unit,
    onToggleView: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Left: Back button
        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(TravelColors.SurfaceWhite)
                .border(BorderStroke(1.dp, TravelColors.SurfaceBorder), CircleShape)
                .clickable { onBackClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_arrow_back),
                contentDescription = "Back",
                modifier = Modifier.size(20.dp),
                tint = TravelColors.TextPrimary
            )
        }

        // Title
        Text(
            text = "Experiences",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = TravelColors.TextPrimary
        )

        // Right: Grid / Layout Toggle Button
        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(TravelColors.SurfaceWhite)
                .border(BorderStroke(1.dp, TravelColors.SurfaceBorder), CircleShape)
                .clickable { onToggleView() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_grid_view),
                contentDescription = "Toggle View",
                modifier = Modifier.size(18.dp),
                tint = TravelColors.TextPrimary
            )
        }
    }
}

@Composable
fun DetailTopBar(
    onBackClick: () -> Unit,
    onFavoriteClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Left: Back button
        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.92f))
                .border(BorderStroke(1.dp, TravelColors.SurfaceBorder.copy(alpha = 0.6f)), CircleShape)
                .clickable { onBackClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_arrow_back),
                contentDescription = "Back",
                modifier = Modifier.size(20.dp),
                tint = TravelColors.TextPrimary
            )
        }

        // Right: Favorite & Share
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.92f))
                    .border(BorderStroke(1.dp, TravelColors.SurfaceBorder.copy(alpha = 0.6f)), CircleShape)
                    .clickable { onFavoriteClick() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(Res.drawable.ic_heart),
                    contentDescription = "Favorite",
                    modifier = Modifier.size(19.dp),
                    tint = TravelColors.TextPrimary
                )
            }

            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.92f))
                    .border(BorderStroke(1.dp, TravelColors.SurfaceBorder.copy(alpha = 0.6f)), CircleShape)
                    .clickable { onShareClick() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(Res.drawable.ic_share),
                    contentDescription = "Share",
                    modifier = Modifier.size(19.dp),
                    tint = TravelColors.TextPrimary
                )
            }
        }
    }
}
