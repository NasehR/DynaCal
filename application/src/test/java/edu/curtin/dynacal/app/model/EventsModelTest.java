package edu.curtin.dynacal.app.model;

import edu.curtin.dynacal.api.AllDayCalendarEvent;
import edu.curtin.dynacal.api.IEvent;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventsModelTest {
    @Test
    public void testAddEvent() {
        List<IEvent> eventsList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String title = "Test Event " + i;
            IEvent event = new AllDayCalendarEvent(title, LocalDate.now().plusDays(i));
            eventsList.add(event);
        }

        EventsModel eventsModel = new EventsModel(eventsList);

        eventsModel.addEvent(new AllDayCalendarEvent("Test Event 3", LocalDate.now().plusDays(3)));

        assertEquals("Test Event 3", eventsModel.getEventsList().get(eventsModel.getEventsList().size() - 1).getName());
    }

    @Test
    public void testGetEventsList() {
        List<IEvent> eventsList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String title = "Test Event " + i;
            IEvent event = new AllDayCalendarEvent(title, LocalDate.now().plusDays(i));
            eventsList.add(event);
        }

        EventsModel eventsModel = new EventsModel(eventsList);

        assertEquals(eventsList, eventsModel.getEventsList());
        assertEquals(3, eventsModel.getEventsList().size());

        for (IEvent event : eventsModel.getEventsList()) {
            int i = eventsModel.getEventsList().indexOf(event);
            assertEquals("Test Event " + i, event.getName());
            assertEquals(LocalDate.now().plusDays(i), event.getStartDate());
        }
    }
}
