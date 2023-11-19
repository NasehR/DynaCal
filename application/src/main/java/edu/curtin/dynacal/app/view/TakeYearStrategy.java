package edu.curtin.dynacal.app.view;

import java.time.LocalDate;

public class TakeYearStrategy implements IDateStrategy {
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        System.out.println("TakeDayStrategy");
        return currentViewDate.minusYears(1);
    }
}
