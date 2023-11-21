package edu.curtin.dynacal.app.view;

import java.time.LocalDate;

public class TakeDayStrategy implements IDateStrategy {
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return currentViewDate.minusDays(1);
    }

    @Override
    public String toString() {
        return "Move Backwards a Day";
    }
}
