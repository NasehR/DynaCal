package edu.curtin.dynacal.app.view;

import java.time.LocalDate;

public class TakeWeekStrategy implements IDateStrategy {
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        System.out.println("TakeDayStrategy");
        return currentViewDate.minusWeeks(1);
    }
}
