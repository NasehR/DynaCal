package edu.curtin.dynacal.app.view;

import java.time.LocalDate;

public class AddMonthStrategy implements IDateStrategy {
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        System.out.println("AddMonthStrategy");
        return currentViewDate.plusMonths(1);
    }
}
