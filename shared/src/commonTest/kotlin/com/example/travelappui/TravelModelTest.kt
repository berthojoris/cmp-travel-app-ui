package com.example.travelappui

import com.example.travelappui.model.TravelMockData
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TravelModelTest {

    @Test
    fun testCategoriesContainRequiredEntries() {
        val categories = TravelMockData.categories
        assertEquals(5, categories.size)
        assertEquals("All", categories[0].title)
        assertEquals("Private Jets", categories[1].title)
        assertEquals("Yachts", categories[2].title)
        assertEquals("Fine Dining", categories[3].title)
        assertEquals("Events", categories[4].title)
    }

    @Test
    fun testConciergeBookings() {
        val bookings = TravelMockData.conciergeBookings
        assertEquals(2, bookings.size)
        assertEquals("Private Jet to Nice", bookings[0].title)
        assertEquals("Confirmed", bookings[0].status)
        assertEquals("Dinner Reservation", bookings[1].title)
        assertEquals("7:00 PM", bookings[1].time)
    }

    @Test
    fun testYachtSpecs() {
        val specs = TravelMockData.yachtSpecs
        assertEquals(3, specs.size)
        assertTrue(specs.any { it.label == "10 Guests" })
        assertTrue(specs.any { it.label == "5 Cabins" })
        assertTrue(specs.any { it.label == "6 Crew" })
    }

    @Test
    fun testCalendarDays() {
        val days = TravelMockData.calendarDays
        assertEquals(7, days.size)
        val selectedDay = days.firstOrNull { it.isSelected }
        assertEquals(15, selectedDay?.date)
        assertEquals("THU", selectedDay?.dayOfWeek)
    }
}
