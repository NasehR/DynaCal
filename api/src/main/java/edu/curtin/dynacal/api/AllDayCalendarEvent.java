package edu.curtin.dynacal.api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

//TODO:
// Comments
// Documentation

public class AllDayCalendarEvent implements IEvent {
    private String title;
    private LocalDate startDate;

    public AllDayCalendarEvent(String title, LocalDate startDate) {
        this.title = title;
        this.startDate = startDate;
    }

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
        return Optional.empty();
    }

    @Override
    public Optional<Integer> getDuration() {
        return Optional.empty();
    }
}
