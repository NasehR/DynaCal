package edu.curtin.dynacal.api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

//TODO:
// Comments
// Documentation

public class TODCalendarEvent implements IEvent {
    // Class Fields
    private String title;
    private LocalDate startDate;
    private LocalTime startTime;
    private Integer duration;

    // Constructor
    public TODCalendarEvent(String title, LocalDate startDate, LocalTime startTime, int duration) {
        this.title = title;
        this.startDate = startDate;
        this.startTime = startTime;
        this.duration = duration;
    }

    // Class Methods
    @Override
    public String getName() {
        return title;
    }

    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public Optional<LocalTime> getStartTime() {
        return Optional.of(startTime);
    }

    @Override
    public Optional<Integer> getDuration() {
        return Optional.of(duration);
    }
}
