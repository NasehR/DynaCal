package edu.curtin.dynacal.app.controller;

import edu.curtin.dynacal.api.AllDayCalendarEvent;
import edu.curtin.dynacal.api.IEvent;
import edu.curtin.dynacal.app.model.EventsModel;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalendarControllerTest {

    @Test
    public void testRegisterEvent() {
        List<IEvent> eventsList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String title = "Test Event " + i;
            IEvent event = new AllDayCalendarEvent(title, LocalDate.now().plusDays(i));
            eventsList.add(event);
        }
        EventsModel eventModel = new EventsModel(eventsList);
        CalendarController calendarController = new CalendarController(eventModel);

        IEvent newEvent = new AllDayCalendarEvent("Test Event 3", LocalDate.now().plusDays(3));
        calendarController.registerEvent(newEvent);

        List<IEvent> events = calendarController.getEventsList();

        for (IEvent event : events) {
            int i = events.indexOf(event);
            assertEquals("Test Event " + i, event.getName());
            assertEquals(LocalDate.now().plusDays(i), event.getStartDate());
        }
    }

    @Test
    public void testGetEventsList() {
        List<IEvent> eventsList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String title = "Test Event " + i;
            IEvent event = new AllDayCalendarEvent(title, LocalDate.now().plusDays(i));
            eventsList.add(event);
        }
        EventsModel eventModel = new EventsModel(eventsList);
        CalendarController calendarController = new CalendarController(eventModel);
        List<IEvent> events = calendarController.getEventsList();

        for (IEvent event : events) {
            int i = events.indexOf(event);
            assertEquals("Test Event " + i, event.getName());
            assertEquals(LocalDate.now().plusDays(i), event.getStartDate());
        }
    }

    @Test
    public void testGetViewDate() {
        List<IEvent> eventsList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String title = "Test Event " + i;
            IEvent event = new AllDayCalendarEvent(title, LocalDate.now().plusDays(i));
            eventsList.add(event);
        }
        EventsModel eventModel = new EventsModel(eventsList);
        CalendarController calendarController = new CalendarController(eventModel);

        assertEquals(LocalDate.now(), calendarController.getViewDate());
    }

    @Test
    public void testSetViewDate() {
        List<IEvent> eventsList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String title = "Test Event " + i;
            IEvent event = new AllDayCalendarEvent(title, LocalDate.now().plusDays(i));
            eventsList.add(event);
        }
        EventsModel eventModel = new EventsModel(eventsList);
        CalendarController calendarController = new CalendarController(eventModel);

        assertEquals(LocalDate.now(), calendarController.getViewDate());

        calendarController.setViewDate(LocalDate.now().plusDays(10));

        assertEquals(LocalDate.now().plusDays(10), calendarController.getViewDate());
    }
}
