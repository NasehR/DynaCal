package edu.curtin.dynacal.app.view;

import java.time.LocalDate;

public class TakeWeekStrategy implements IDateStrategy {
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        System.out.println("TakeWeekStrategy");
        return currentViewDate.minusWeeks(1);
    }
}
