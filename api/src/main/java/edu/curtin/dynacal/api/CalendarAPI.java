package edu.curtin.dynacal.api;

public interface CalendarAPI {
    void addEvent(CalendarEvent event);
    void registerEventHandler(String evName, EventHandler handler);
}
