package edu.curtin.dynacal.app.view;

import java.time.LocalDate;

public class AddYearStrategy implements IDateStrategy {
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        System.out.println("AddYearStrategy");
        return currentViewDate.plusYears(1);
    }
}
