package edu.curtin.dynacal.app.view;

import java.time.LocalDate;

public class TakeYearStrategy implements IDateStrategy {
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return currentViewDate.minusYears(1);
    }

    @Override
    public String toString() {
        return "Move Backwards an Year";
    }
}