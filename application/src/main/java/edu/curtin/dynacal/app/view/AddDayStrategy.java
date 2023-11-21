package edu.curtin.dynacal.app.view;

import java.time.LocalDate;

public class AddDayStrategy implements IDateStrategy{

    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return currentViewDate.plusDays(1);
    }
    @Override
    public String toString() {
        return "Move Forward a Day";
    }
}
