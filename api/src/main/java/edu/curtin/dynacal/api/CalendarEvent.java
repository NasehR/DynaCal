package edu.curtin.dynacal.api;

import java.time.LocalDate;

public abstract class CalendarEvent {
    protected String title;
    protected LocalDate startDate;

    public String getTitle() {
        return title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}
