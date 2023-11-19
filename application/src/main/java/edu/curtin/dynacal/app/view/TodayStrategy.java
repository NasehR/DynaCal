package edu.curtin.dynacal.app.view;

import java.time.LocalDate;

public class TodayStrategy implements IDateStrategy {
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        System.out.println("TodayStrategy");
        return LocalDate.now();
    }
}
