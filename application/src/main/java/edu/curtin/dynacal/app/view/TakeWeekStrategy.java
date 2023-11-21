package edu.curtin.dynacal.app.view;

import java.time.LocalDate;

public class TakeWeekStrategy implements IDateStrategy {
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return currentViewDate.minusWeeks(1);
    }

    @Override
    public String toString() {
        return "Move Backwards a Week";
    }
}
