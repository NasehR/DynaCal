package edu.curtin.dynacal.app.view;

import java.time.LocalDate;

public class AddYearStrategy implements IDateStrategy {
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return currentViewDate.plusYears(1);
    }

    @Override
    public String toString() {
        return "Move Forward an Year";
    }
}
