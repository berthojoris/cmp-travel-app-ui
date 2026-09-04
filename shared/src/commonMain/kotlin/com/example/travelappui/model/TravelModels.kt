package com.example.travelappui.model

import org.jetbrains.compose.resources.DrawableResource
import travelappui.shared.generated.resources.*

enum class NavigationTab(val label: String, val iconRes: DrawableResource) {
    Home("Home", Res.drawable.ic_home),
    Bookings("Bookings", Res.drawable.ic_calendar),
    Wishlist("Wishlist", Res.drawable.ic_heart),
    Profile("Profile", Res.drawable.ic_profile)
}

enum class ScreenType {
    HOME,
    EXPERIENCES,
    YACHT_DETAIL
}

data class ExperienceCategory(
    val id: String,
    val title: String,
    val iconRes: DrawableResource
)

data class ConciergeBooking(
    val id: String,
    val title: String,
    val subtitle: String,
    val iconRes: DrawableResource,
    val status: String? = null,
    val time: String? = null
)

data class QuickAccessItem(
    val id: String,
    val label: String,
    val iconRes: DrawableResource
)

data class ExperienceCardItem(
    val id: String,
    val title: String,
    val countText: String,
    val imageRes: DrawableResource
)

data class SpecItem(
    val label: String,
    val iconRes: DrawableResource
)

data class DayItem(
    val dayOfWeek: String,
    val date: Int,
    val isSelected: Boolean = false
)

object TravelMockData {
    val categories = listOf(
        ExperienceCategory("all", "All", Res.drawable.ic_grid_view),
        ExperienceCategory("jets", "Private Jets", Res.drawable.ic_plane),
        ExperienceCategory("yachts", "Yachts", Res.drawable.ic_yacht),
        ExperienceCategory("dining", "Fine Dining", Res.drawable.ic_dining),
        ExperienceCategory("events", "Events", Res.drawable.ic_ticket)
    )

    val conciergeBookings = listOf(
        ConciergeBooking(
            id = "1",
            title = "Private Jet to Nice",
            subtitle = "22 May 2025 · 11:30 AM",
            iconRes = Res.drawable.ic_plane,
            status = "Confirmed"
        ),
        ConciergeBooking(
            id = "2",
            title = "Dinner Reservation",
            subtitle = "Le Chantecler, Monaco",
            iconRes = Res.drawable.ic_dining,
            time = "7:00 PM"
        )
    )

    val quickAccessItems = listOf(
        QuickAccessItem("1", "Book a Jet", Res.drawable.ic_plane),
        QuickAccessItem("2", "Yacht Charter", Res.drawable.ic_yacht),
        QuickAccessItem("3", "Fine Dining", Res.drawable.ic_dining),
        QuickAccessItem("4", "Events", Res.drawable.ic_ticket),
        QuickAccessItem("5", "View All", Res.drawable.ic_grid_view)
    )

    val topExperiences = listOf(
        ExperienceCardItem("jets", "Private Jets", "18 Experiences", Res.drawable.img_private_jets),
        ExperienceCardItem("yachts", "Yacht Charters", "24 Experiences", Res.drawable.img_yacht_charters),
        ExperienceCardItem("dining", "Fine Dining", "32 Experiences", Res.drawable.img_fine_dining),
        ExperienceCardItem("events", "Luxury Events", "16 Experiences", Res.drawable.img_luxury_events)
    )

    val yachtSpecs = listOf(
        SpecItem("10 Guests", Res.drawable.ic_guests),
        SpecItem("5 Cabins", Res.drawable.ic_cabin),
        SpecItem("6 Crew", Res.drawable.ic_crew)
    )

    val calendarDays = listOf(
        DayItem("MON", 12),
        DayItem("TUE", 13),
        DayItem("WED", 14),
        DayItem("THU", 15, isSelected = true),
        DayItem("FRI", 16),
        DayItem("SAT", 17),
        DayItem("SUN", 18)
    )
}
