package edu.curtin.dynacal.api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

/**
 * Interface representing an event in a calendar system.
 */
public interface IEvent {

    /**
     * Get the name of the event.
     *
     * @return The name of the event.
     */
    String getName();

    /**
     * Get the start date of the event.
     *
     * @return The start date of the event.
     */
    LocalDate getStartDate();

    /**
     * Get the optional start time of the event.
     *
     * @return Optional start time of the event.
     */
    Optional<LocalTime> getStartTime();

    /**
     * Get the optional duration of the event.
     *
     * @return Optional duration of the event.
     */
    Optional<Integer> getDuration();
}
