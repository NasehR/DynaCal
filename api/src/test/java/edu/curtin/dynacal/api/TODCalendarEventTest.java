package edu.curtin.dynacal.api;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TODCalendarEventTest {

    @Test
    void testGetName() {
        LocalDate startDate = LocalDate.of(2023, 11, 20);
        LocalTime startTime = LocalTime.of(10, 30);
        int duration = 60;
        IEvent event = new TODCalendarEvent("Test Event", startDate, startTime, duration);
        assertEquals("Test Event", event.getName(), "Event name should be: \"Test Event\"");
    }

    @Test
    void testGetStartDate() {
        LocalDate startDate = LocalDate.of(2023, 11, 20);
        LocalTime startTime = LocalTime.of(10, 30);
        int duration = 60;
        IEvent event = new TODCalendarEvent("Test Event", startDate, startTime, duration);
        assertEquals(startDate, event.getStartDate(), "Event start date should be: 2023-11-20");
    }

    @Test
    void testGetStartTime() {
        LocalDate startDate = LocalDate.of(2023, 11, 20);
        LocalTime startTime = LocalTime.of(10, 30);
        int duration = 60;
        IEvent event = new TODCalendarEvent("Test Event", startDate, startTime, duration);
        assertEquals(Optional.of(startTime), event.getStartTime(), "Event start time should be: 10:30");
    }

    @Test
    void testGetDuration() {
        LocalDate startDate = LocalDate.of(2023, 11, 20);
        LocalTime startTime = LocalTime.of(10, 30);
        int duration = 60;
        IEvent event = new TODCalendarEvent("Test Event", startDate, startTime, duration);
        assertEquals(Optional.of(duration), event.getDuration(), "Event duration should be: 60");
    }
}
