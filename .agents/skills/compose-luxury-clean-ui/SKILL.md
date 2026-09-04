---
name: compose-luxury-clean-ui
description: Comprehensive UI/UX design system and component engineering guide for modern, clean, luxury, and professional production-grade Jetpack Compose and Compose Multiplatform mobile applications. Enforces universal zero-shadow Flat UI aesthetics, 1px crisp borders, pure white surfaces, high-contrast typography, editorial serif display titles, and complete recipes for cards, headers, search bars, filter pills, hero banners, detail screens, and bottom navigation bars without dot indicators.
---

# Modern Clean Luxury UI/UX Design System for Jetpack Compose

A comprehensive engineering guide and component specification for building **ultra-clean, modern, minimalist, luxury, and production-grade mobile interfaces** using Kotlin Jetpack Compose and Compose Multiplatform.

---

## 1. Core Philosophy & Aesthetic Principles

This design system delivers an editorial, high-end mobile experience that feels refined, fast, and timeless. It eliminates visual clutter, blurry drop shadows, and gaudy gradients in favor of structural clarity, crisp typography, and disciplined spacing.

### Key Tenets:
1. **Universal Zero-Shadow Standard**:
   - **Strictly Prohibited**: `Modifier.shadow()`, blurred drop shadows, ambient shadow elevation, and `defaultElevation > 0.dp` across all buttons, cards, sheets, dialogs, and navigation bars.
   - **Crisp Structural Depth**: Depth is created purely through **1px crisp stroke borders** (`BorderStroke(1.dp, SurfaceBorder)`), pure white surfaces (`#FFFFFF`), and soft background canvases (`#F8F9FA` / `#F9FAFB`).
2. **Editorial Typography Pairing**:
   - **Display & Headlines**: High-contrast Serif typography (`FontFamily.Serif`) for hero headlines, screen titles, and luxury item naming. Adds elegance and editorial prestige.
   - **Body, Navigation & Metadata**: Clean, geometric Sans-Serif system typography (`FontWeight.Normal`, `FontWeight.Medium`, `FontWeight.Bold`) with strict line-height and letter-spacing for effortless legibility.
3. **Restrained Luxury Color Hierarchy**:
   - **Deep Obsidian / Forest Teal (`#0A332C`)**: Primary brand color for high-impact CTAs, active states, and dominant filter pills.
   - **Soft Mint / Muted Emerald (`#E8F5E9` / `#10B981`)**: Subtle status badges, confirmed states, and secondary accents.
   - **Crisp Monochrome Foundation**: `#FFFFFF` for cards, `#F8F9FA` for page background, `#111827` for headings, `#4B5563` for secondary copy, `#9CA3AF` for placeholders/muted icons, and `#E5E7EB` for 1px borders.
4. **Fluid Edge-to-Edge & Safe Inset Discipline**:
   - Zero double-padding bugs. Transparent status and navigation bars with intentional padding hierarchy.

---

## 2. Design Tokens & Palette Specifications

### 2.1 Color Palette (`TravelColors` / `LuxuryColors`)
```kotlin
package com.example.app.theme

import androidx.compose.ui.graphics.Color

object LuxuryColors {
    // Primary Brand
    val TealPrimary = Color(0xFF0A332C)       // Deep luxury forest teal
    val TealDark = Color(0xFF06231E)          // Ultra deep teal
    val TealLight = Color(0xFFE8F5E9)         // Very soft mint tint

    // Status Accents
    val ConfirmedGreen = Color(0xFF10B981)    // Emerald green for status
    val GreenBadgeBg = Color(0xFFE8F5E9)      // Soft green background

    // Surfaces & Backgrounds
    val Background = Color(0xFFF8F9FA)        // Soft neutral canvas
    val SurfaceWhite = Color(0xFFFFFFFF)      // Pure white for all cards/bars
    val SurfaceMuted = Color(0xFFF3F4F6)      // Icon containers & inner pills

    // Borders & Dividers
    val SurfaceBorder = Color(0xFFE5E7EB)     // Crisp 1px universal border
    val DividerColor = Color(0xFFF3F4F6)      // Subtle divider lines

    // Typography
    val TextPrimary = Color(0xFF111827)       // High-contrast charcoal/black
    val TextSecondary = Color(0xFF4B5563)     // Slate secondary text
    val TextMuted = Color(0xFF9CA3AF)         // Muted gray for inactive states
}
```

### 2.2 Typography Architecture
```kotlin
package com.example.app.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object LuxuryTypography {
    // Editorial Serif Headlines
    val DisplayLargeSerif = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 34.sp,
        letterSpacing = (-0.5).sp
    )

    val DisplayMediumSerif = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = (-0.3).sp
    )

    // Clean Sans-Serif UI Text
    val TitleMediumSans = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp,
        lineHeight = 22.sp
    )

    val BodyMediumSans = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 21.sp
    )

    val LabelSmallSans = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 11.sp,
        lineHeight = 14.sp
    )
}
```

---

## 3. Production Component Recipes & Specifications

### 3.1 Modern Flat Bottom Navigation Bar (No-Dot Standard)

#### Specifications:
- **No Dot Indicator**: Eliminate dots or bars below labels. The active state is communicated purely by **`FontWeight.Bold`** and **Primary Brand Color (`#0A332C`)** on both icon and label.
- **Low Bottom Positioning**: Sit lower on the viewport by applying `.navigationBarsPadding()` followed by a small bottom padding (`top = 8.dp, bottom = 4.dp`) to avoid huge bottom gaps on devices with system gesture or 3-button bars.
- **Instant Touch**: Disable ripple blur via `indication = null` with `remember { MutableInteractionSource() }`.
- **Top Curved Container**: `RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)` with a 1px border (`BorderStroke(1.dp, SurfaceBorder)`) and pure white surface. Zero shadow.

```kotlin
@Composable
fun LuxuryBottomNavigation(
    tabs: List<NavTabItem>,
    selectedTab: NavTabItem,
    onTabSelected: (NavTabItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(LuxuryColors.SurfaceWhite)
            .border(
                border = BorderStroke(1.dp, LuxuryColors.SurfaceBorder),
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            )
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .navigationBarsPadding()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            tabs.forEach { tab ->
                val isSelected = tab == selectedTab
                val interactionSource = remember { MutableInteractionSource() }

                Column(
                    modifier = Modifier
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            onClick = { onTabSelected(tab) }
                        )
                        .padding(start = 12.dp, end = 12.dp, top = 4.dp, bottom = 2.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(tab.iconRes),
                        contentDescription = tab.label,
                        modifier = Modifier.size(22.dp),
                        tint = if (isSelected) LuxuryColors.TealPrimary else LuxuryColors.TextMuted
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = tab.label,
                        fontSize = 11.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSelected) LuxuryColors.TealPrimary else LuxuryColors.TextMuted,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}
```

---

### 3.2 Concierge & Status Cards ("Your Concierge")

#### Specifications:
- Pure white container (`SurfaceWhite`), `RoundedCornerShape(20.dp)`, 1px stroke border (`SurfaceBorder`).
- Left icon badge: `size = 48.dp`, `RoundedCornerShape(14.dp)`, subtle soft gray background (`#F3F4F6`), centered icon (`#111827`, 22.dp).
- Content: Title (`15.sp`, `FontWeight.SemiBold`, `#111827`) + Date/Subtitle (`13.sp`, `#9CA3AF`).
- Status Badge: Mint green pill (`#E8F5E9`), emerald text (`#10B981`, `12.sp`, `FontWeight.SemiBold`), `RoundedCornerShape(12.dp)`, padding `horizontal = 10.dp, vertical = 5.dp`.

```kotlin
@Composable
fun ConciergeStatusCard(
    iconPainter: Painter,
    title: String,
    subtitle: String,
    badgeText: String? = null,
    timeText: String? = null,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        color = LuxuryColors.SurfaceWhite,
        border = BorderStroke(1.dp, LuxuryColors.SurfaceBorder),
        shadowElevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left Soft Rounded Icon Container
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(LuxuryColors.SurfaceMuted),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = iconPainter,
                    contentDescription = null,
                    modifier = Modifier.size(22.dp),
                    tint = LuxuryColors.TextPrimary
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            // Title & Subtitle Column
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = LuxuryColors.TextPrimary
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = subtitle,
                    fontSize = 13.sp,
                    color = LuxuryColors.TextMuted
                )
            }

            // Right Status Badge or Time Text
            if (badgeText != null) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(LuxuryColors.GreenBadgeBg)
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = badgeText,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = LuxuryColors.ConfirmedGreen
                    )
                }
            } else if (timeText != null) {
                Text(
                    text = timeText,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = LuxuryColors.TextSecondary
                )
            }
        }
    }
}
```

---

### 3.3 Search Bar & Standalone Action Filter Button

#### Specifications:
- Search Bar: Pure white pill, `RoundedCornerShape(24.dp)`, 1px border (`SurfaceBorder`), height ~48.dp, leading search icon, subtle placeholder text.
- Filter Button: Standalone square/rounded button (`size = 48.dp`, `RoundedCornerShape(14.dp)`), solid `#0A332C` background, white icon.

```kotlin
@Composable
fun LuxurySearchBarRow(
    query: String,
    onQueryChange: (String) -> Unit,
    onFilterClick: () -> Unit,
    placeholder: String = "Search for experiences...",
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Search Input Pill
        Row(
            modifier = Modifier
                .weight(1f)
                .height(48.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(LuxuryColors.SurfaceWhite)
                .border(BorderStroke(1.dp, LuxuryColors.SurfaceBorder), RoundedCornerShape(24.dp))
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_search),
                contentDescription = "Search",
                modifier = Modifier.size(20.dp),
                tint = LuxuryColors.TextMuted
            )
            Spacer(modifier = Modifier.width(10.dp))
            BasicTextField(
                value = query,
                onValueChange = onQueryChange,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    color = LuxuryColors.TextPrimary,
                    fontWeight = FontWeight.Normal
                ),
                decorationBox = { innerTextField ->
                    if (query.isEmpty()) {
                        Text(
                            text = placeholder,
                            fontSize = 14.sp,
                            color = LuxuryColors.TextMuted
                        )
                    }
                    innerTextField()
                }
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        // Standalone Filter Action Button
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(LuxuryColors.TealPrimary)
                .clickable { onFilterClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_filter),
                contentDescription = "Filter",
                modifier = Modifier.size(20.dp),
                tint = Color.White
            )
        }
    }
}
```

---

### 3.4 Hero Banners & Cards

#### Specifications:
- Aspect ratio / height: `220.dp` (compact banner) to `315.dp` (detail hero).
- Border Radius: `RoundedCornerShape(24.dp)` on all corners, or bottom curved (`RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)`) for detail screens.
- Photographic Imagery: High-resolution photo with `ContentScale.Crop`.
- Editorial Headline: `DisplayLargeSerif` or `DisplayMediumSerif` in pure white.
- CTA Pill Button: `RoundedCornerShape(24.dp)`, pure white background, `#0A332C` bold text, trailing arrow icon.
- Carousel Indicator: Horizontal pill row (active: 14.dp x 3.dp white pill; inactive: 4.dp dots).

```kotlin
@Composable
fun LuxuryHeroBanner(
    eyebrowText: String,
    title: String,
    subtitle: String,
    ctaText: String,
    imagePainter: Painter,
    onCtaClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp)
            .clip(RoundedCornerShape(24.dp))
    ) {
        // High-res Background Image
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Soft Legibility Scrim
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.15f),
                            Color.Black.copy(alpha = 0.55f)
                        )
                    )
                )
        )

        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = eyebrowText.uppercase(),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 1.sp,
                    color = Color.White.copy(alpha = 0.85f)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = title,
                    style = LuxuryTypography.DisplayMediumSerif,
                    color = Color.White
                )
                Text(
                    text = subtitle,
                    fontSize = 13.sp,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }

            // Bottom CTA Pill & Indicator Dots
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // CTA Button
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(LuxuryColors.SurfaceWhite)
                        .clickable { onCtaClick() }
                        .padding(horizontal = 16.dp, vertical = 9.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = ctaText,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = LuxuryColors.TealPrimary
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(
                        painter = painterResource(Res.drawable.ic_arrow_right),
                        contentDescription = null,
                        modifier = Modifier.size(14.dp),
                        tint = LuxuryColors.TealPrimary
                    )
                }

                // Dot Indicators
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .width(14.dp)
                            .height(3.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(Color.White)
                    )
                    Box(
                        modifier = Modifier
                            .size(3.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.5f))
                    )
                }
            }
        }
    }
}
```

---

### 3.5 Filter Pill Chips (Category Filter Row)

#### Specifications:
- Active State: Solid `#0A332C` background, pure white icon & text, 0 border.
- Inactive State: Pure white background, 1px border (`#E5E7EB`), `#111827` icon & text.
- Shape: `RoundedCornerShape(16.dp)`. Padding: `horizontal = 16.dp, vertical = 10.dp`.

```kotlin
@Composable
fun FilterPillChip(
    label: String,
    isSelected: Boolean,
    iconPainter: Painter? = null,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val bgColor = if (isSelected) LuxuryColors.TealPrimary else LuxuryColors.SurfaceWhite
    val contentColor = if (isSelected) Color.White else LuxuryColors.TextPrimary

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(bgColor)
            .then(
                if (!isSelected) {
                    Modifier.border(BorderStroke(1.dp, LuxuryColors.SurfaceBorder), RoundedCornerShape(16.dp))
                } else Modifier
            )
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (iconPainter != null) {
            Icon(
                painter = iconPainter,
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = contentColor
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text = label,
            fontSize = 13.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            color = contentColor
        )
    }
}
```

---

### 3.6 Quick Access Category Buttons

#### Specifications:
- Square-ish rounded button: `size = 56.dp`, `RoundedCornerShape(16.dp)`, pure white, 1px border.
- Centered icon: `22.dp`, `#111827`.
- Label underneath: `12.sp`, `FontWeight.Medium`, centered.
- Horizontal scroll arrangement: `spacedBy(16.dp)`.

```kotlin
@Composable
fun QuickAccessButton(
    iconPainter: Painter,
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(LuxuryColors.SurfaceWhite)
                .border(BorderStroke(1.dp, LuxuryColors.SurfaceBorder), RoundedCornerShape(16.dp))
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = iconPainter,
                contentDescription = label,
                modifier = Modifier.size(22.dp),
                tint = LuxuryColors.TextPrimary
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = LuxuryColors.TextPrimary
        )
    }
}
```

---

### 3.7 Top Experiences Grid Cards (2x2 Grid)

#### Specifications:
- Container: `RoundedCornerShape(20.dp)`, pure white surface, 1px crisp border (`SurfaceBorder`), zero shadow.
- Image Header: `height = 140.dp`, `ContentScale.Crop`, clipped to top corners.
- Metadata: Title (`15.sp`, `FontWeight.Bold`, `#111827`) + Subtitle (`12.sp`, `#4B5563`).

```kotlin
@Composable
fun ExperienceGridCard(
    imagePainter: Painter,
    title: String,
    countText: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        color = LuxuryColors.SurfaceWhite,
        border = BorderStroke(1.dp, LuxuryColors.SurfaceBorder),
        shadowElevation = 0.dp
    ) {
        Column {
            // Image Header
            Image(
                painter = imagePainter,
                contentDescription = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(135.dp),
                contentScale = ContentScale.Crop
            )

            // Bottom Label Area
            Column(modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp)) {
                Text(
                    text = title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = LuxuryColors.TextPrimary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = countText,
                    fontSize = 12.sp,
                    color = LuxuryColors.TextSecondary
                )
            }
        }
    }
}
```

---

### 3.8 Detail Screen Components: Date Selector & Sticky Booking Bar

#### Specifications:
- **Interactive Date Strip**: Mon - Sun day names in uppercase (`11.sp`, `FontWeight.Medium`, `#9CA3AF`). Day number (`14.sp`). Active date rendered in solid `#0A332C` circle (`size = 36.dp`) with white bold text.
- **Sticky Bottom Booking Bar**: Positioned at screen bottom with 1px top border. Left side displays price (`$28,500`) + unit (`Per Day`). Right side displays pill CTA button (`"Request Booking →"`).

```kotlin
@Composable
fun InteractiveDateStrip(
    days: List<Pair<String, Int>>,
    selectedDay: Int,
    onDaySelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        days.forEach { (dayName, dayNumber) ->
            val isSelected = dayNumber == selectedDay

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable { onDaySelected(dayNumber) }
            ) {
                Text(
                    text = dayName,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    color = LuxuryColors.TextMuted
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(if (isSelected) LuxuryColors.TealPrimary else Color.Transparent),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "$dayNumber",
                        fontSize = 14.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = if (isSelected) Color.White else LuxuryColors.TextPrimary
                    )
                }
            }
        }
    }
}

@Composable
fun StickyBookingBottomBar(
    priceText: String,
    unitText: String,
    ctaText: String = "Request Booking",
    onCtaClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = LuxuryColors.SurfaceWhite,
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        border = BorderStroke(1.dp, LuxuryColors.SurfaceBorder),
        shadowElevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(start = 24.dp, end = 24.dp, top = 14.dp, bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = priceText,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = LuxuryColors.TextPrimary
                )
                Text(
                    text = unitText,
                    fontSize = 12.sp,
                    color = LuxuryColors.TextMuted
                )
            }

            // High-impact CTA Pill Button
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(24.dp))
                    .background(LuxuryColors.TealPrimary)
                    .clickable { onCtaClick() }
                    .padding(horizontal = 22.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = ctaText,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
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
```

---

## 4. Inset Handling & Safe Edge-to-Edge Hierarchy

To prevent double-padding bugs and layout jumping across Android devices:
1. **Scaffold Insets**:
   - `Scaffold`'s `paddingValues.calculateTopPadding()` handles the status bar. Do **NOT** add `Modifier.statusBarsPadding()` inside child composables if `Scaffold` padding is applied.
2. **Transparent System Overlays**:
   - For detail screens with full-bleed hero images, pass `0.dp` top padding in `Scaffold` and place the top navigation bar with `.statusBarsPadding()`.
3. **Navigation Bars Padding**:
   - Apply `.navigationBarsPadding()` on bottom bars directly on their root background Box/Surface so the white background flows seamlessly behind system navigation buttons.

---

## 5. System Back Button & Stack Navigation Discipline

To prevent accidental app closes and provide true Android back-stack UX:
1. **Multiplatform BackHandler Expect/Actual**:
   - Define `@Composable expect fun BackHandler(enabled: Boolean = true, onBack: () -> Unit)` in `commonMain`.
   - On Android: delegate to `androidx.activity.compose.BackHandler(enabled = enabled, onBack = onBack)`.
   - On iOS: implement as no-op.
2. **Predictable Pop Order**:
   - If a Dialog / BottomSheet is open, intercept back to close it first.
   - If on a nested/detail screen (e.g. `YACHT_DETAIL`), pop back to the previous screen.
   - If on a secondary tab screen (e.g. `EXPERIENCES`), pop back to `HOME` screen and reset active tab to `Home`.
   - Only when user is on the root `HOME` screen with `Home` tab active, disable the `BackHandler` (`enabled = false`), allowing the OS to exit/minimize the app cleanly.

---

## 6. Production Quality & Anti-Regression Checklist

Before finalizing any screen built with this skill, verify:
- [ ] **Universal Zero-Shadow**: No `Modifier.shadow()`, no `cardElevation`, no `shadowElevation > 0.dp`.
- [ ] **Crisp 1px Boundaries**: All card containers, top bars, and buttons use explicit `BorderStroke(1.dp, SurfaceBorder)`.
- [ ] **Editorial Typography**: Hero headlines use `FontFamily.Serif` with negative letter-spacing for premium feel.
- [ ] **Clean Bottom Navigation**: No dot indicator underneath labels. Active tab has `FontWeight.Bold` and `TealPrimary` color. Compact bottom padding.
- [ ] **System Back Navigation**: Android hardware/gesture back pops active sub-screens and dialogs back to Home before exiting.
- [ ] **Contrast Verification**: All body text strictly adheres to `#111827` (primary) or `#4B5563` (secondary). Never use unreadable light grays.
- [ ] **Zero UI Lag & Allocations**: No lambda or object instantiation inside heavy recomposition loops; use `remember` for interaction sources.
