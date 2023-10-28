package edu.curtin.dynacal.api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public class AllDayCalendarEvent implements IEvent {
    private String title;
    private LocalDate startDate;

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
