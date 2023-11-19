package edu.curtin.dynacal.app.view;

import java.time.LocalDate;

public class AddDayStrategy implements IDateStrategy{

    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        System.out.println("AddDayStrategy");
        return currentViewDate.plusDays(1);
    }
}
