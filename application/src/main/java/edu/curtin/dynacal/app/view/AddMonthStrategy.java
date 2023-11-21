package edu.curtin.dynacal.app.view;

import java.time.LocalDate;

public class AddMonthStrategy implements IDateStrategy {
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return currentViewDate.plusMonths(1);
    }

    @Override
    public String toString() {
        return "Move Forward a Month";
    }
}
