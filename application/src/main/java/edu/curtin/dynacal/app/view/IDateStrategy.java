package edu.curtin.dynacal.app.view;

import java.time.LocalDate;

public interface IDateStrategy {
    LocalDate moveToNewDate(LocalDate currentViewDate);
    @Override
    String toString();
}
