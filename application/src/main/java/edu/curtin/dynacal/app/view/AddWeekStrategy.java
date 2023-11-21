package edu.curtin.dynacal.app.view;

import java.time.LocalDate;

public class AddWeekStrategy implements IDateStrategy {
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return currentViewDate.plusWeeks(1);
    }

    @Override
    public String toString() {
        return "Move Forward a Week";
    }
}
