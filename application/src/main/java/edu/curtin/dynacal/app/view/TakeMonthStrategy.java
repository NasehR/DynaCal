package edu.curtin.dynacal.app.view;

import java.time.LocalDate;

public class TakeMonthStrategy implements IDateStrategy {
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return currentViewDate.minusMonths(1);
    }

    public String toString() {
        return "Move Backwards a Month";
    }
}
