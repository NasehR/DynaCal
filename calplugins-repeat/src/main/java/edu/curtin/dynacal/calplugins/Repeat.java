package edu.curtin.dynacal.calplugins;

import edu.curtin.dynacal.api.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * The Repeat class is a calendar plugin that generates repeated events based on specified parameters.
 */
public class Repeat implements ICalendarPlugin {

    /**
     * Starts the Repeat plugin by generating repeated events and registering them with the provided API.
     *
     * @param api        The API for interacting with the calendar system.
     * @param parameters A map of parameters that specify the configuration for generating repeated events.
     */
    @Override
    public void start(API api, Map<String, String> parameters) {
        // DateTimeFormatters for parsing dates and times
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        IEvent newEvent;
        String title = parameters.get("title");
        LocalDate startDate = LocalDate.parse(parameters.get("startDate"), dateFormatter);
        int dayDuration = Integer.parseInt(parameters.get("repeat"));
        int counter = 0;

        // Check if the parameters include start time and duration
        if (parameters.containsKey("startTime") && parameters.containsKey("duration")) {
            LocalTime startTime = LocalTime.parse(parameters.get("startTime"), timeFormatter);
            int duration = Integer.parseInt(parameters.get("duration"));

            // Generate repeated events with specific start time and duration
            for (LocalDate currentDate = startDate; currentDate.isBefore(startDate.plusYears(1)); currentDate = currentDate.plusDays(dayDuration)) {
                String t = title + " " + counter;
                newEvent = new TODCalendarEvent(t, currentDate, startTime, duration);
                api.registerEvent(newEvent);
                counter++;
            }
        }
        else {
            // Generate repeated all-day events
            for (LocalDate currentDate = startDate; currentDate.isBefore(startDate.plusYears(1)); currentDate = currentDate.plusDays(dayDuration)) {
                String t = title + " " + counter;
                newEvent = new AllDayCalendarEvent(t, currentDate);
                api.registerEvent(newEvent);
                counter++;
            }
        }
    }
}
