package edu.curtin.dynacal.api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

/**
 * Represents an all-day calendar event.
 *
 * This class implements the {@code IEvent} interface, providing details for events
 * that occur throughout an entire day.
 */
public class AllDayCalendarEvent implements IEvent {
    // Class Fields
    private String title;           // The title of the event
    private LocalDate startDate;    // The start date of the event

    /**
     * Constructs an all-day calendar event with the specified title and start date.
     *
     * @param title      The title of the event.
     * @param startDate  The start date of the event.
     */
    public AllDayCalendarEvent(String title, LocalDate startDate) {
        this.title = title;
        this.startDate = startDate;
    }

    /**
     * Gets the name/title of the event.
     *
     * @return The title of the event.
     */
    @Override
    public String getName() {
        return title;
    }

    /**
     * Gets the start date of the event.
     *
     * @return The start date of the event.
     */
    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Gets the start time of the event.
     *
     * Since this represents an all-day event, an empty {@code Optional} is returned.
     *
     * @return An empty {@code Optional} since all-day events have no specific start time.
     */
    @Override
    public Optional<LocalTime> getStartTime() {
        return Optional.empty();
    }

    /**
     * Gets the duration of the event.
     *
     * Since this represents an all-day event, an empty {@code Optional} is returned.
     *
     * @return An empty {@code Optional} since all-day events have no specific duration.
     */
    @Override
    public Optional<Integer> getDuration() {
        return Optional.empty();
    }
}
