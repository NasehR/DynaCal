package edu.curtin.dynacal.api;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllDayCalendarEventTest {

    @Test
    void testGetName() {
        LocalDate startDate = LocalDate.of(2023, 11, 20);
        IEvent event = new AllDayCalendarEvent("Test Event", startDate);
        assertEquals("Test Event", event.getName(), "Event name should be: \"Test Event\"");
    }

    @Test
    void testGetStartDate() {
        LocalDate startDate = LocalDate.of(2023, 11, 20);
        IEvent event = new AllDayCalendarEvent("Test Event", startDate);
        assertEquals(startDate, event.getStartDate(), "Event start date should be: 2023-11-20");
    }

    @Test
    void testGetStartTime() {
        LocalDate startDate = LocalDate.of(2023, 11, 20);
        IEvent event = new AllDayCalendarEvent("Test Event", startDate);
        assertEquals(Optional.empty(), event.getStartTime(), "Event does not have a start time");
    }

    @Test
    void testGetDuration() {
        LocalDate startDate = LocalDate.of(2023, 11, 20);
        IEvent event = new AllDayCalendarEvent("Test Event", startDate);
        assertEquals(Optional.empty(), event.getDuration(), "Event does not have a duration");
    }
}
