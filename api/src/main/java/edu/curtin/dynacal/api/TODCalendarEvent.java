package edu.curtin.dynacal.api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

/**
 * Represents a calendar event with a specific start time and duration.
 */
public class TODCalendarEvent implements IEvent {
    // Class Fields
    private String title;
    private LocalDate startDate;
    private LocalTime startTime;
    private Integer duration;

    /**
     * Constructs a TODCalendarEvent with the specified parameters.
     *
     * @param title     The title of the event.
     * @param startDate The date when the event starts.
     * @param startTime The time when the event starts.
     * @param duration  The duration of the event in minutes.
     */
    public TODCalendarEvent(String title, LocalDate startDate, LocalTime startTime, int duration) {
        this.title = title;
        this.startDate = startDate;
        this.startTime = startTime;
        this.duration = duration;
    }

    /**
     * Gets the name/title of the calendar event.
     *
     * @return The name/title of the event.
     */
    @Override
    public String getName() {
        return title;
    }

    /**
     * Gets the start date of the calendar event.
     *
     * @return The start date of the event.
     */
    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Gets the optional start time of the calendar event.
     *
     * @return The optional start time of the event.
     */
    @Override
    public Optional<LocalTime> getStartTime() {
        return Optional.of(startTime);
    }

    /**
     * Gets the optional duration of the calendar event.
     *
     * @return The optional duration of the event in minutes.
     */
    @Override
    public Optional<Integer> getDuration() {
        return Optional.of(duration);
    }
}
