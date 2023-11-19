package edu.curtin.dynacal.app.view;

import java.time.LocalDate;

public class AddWeekStrategy implements IDateStrategy {
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        System.out.println("AddWeekStrategy");
        return currentViewDate.plusWeeks(1);
    }
}
