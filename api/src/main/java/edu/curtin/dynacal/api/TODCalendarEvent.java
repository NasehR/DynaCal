package edu.curtin.dynacal.api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public class TODCalendarEvent implements IEvent {
    // Class Fields
    private String title;
    private LocalDate startDate;
    private LocalTime startTime;
    private int duration;

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
        return null;
    }

    @Override
    public LocalDate getStartDate() {
        return null;
    }

    @Override
    public Optional<LocalTime> getStartTime() {
        return Optional.empty();
    }

    @Override
    public Optional<Integer> getDuration() {
        return Optional.empty();
    }
}
