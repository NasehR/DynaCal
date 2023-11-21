package edu.curtin.dynacal.app.view;

import java.time.LocalDate;

public class TodayStrategy implements IDateStrategy {
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return LocalDate.now();
    }

    @Override
    public String toString() {
        return "Move to today";
    }
}
