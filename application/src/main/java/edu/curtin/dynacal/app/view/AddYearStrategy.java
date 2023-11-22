package edu.curtin.dynacal.app.view;

import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddYearStrategy implements IDateStrategy {
    private ResourceBundle resourceBundle;

    public AddYearStrategy(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return currentViewDate.plusYears(1);
    }

    @Override
    public String toString() {
        return resourceBundle.getString("Move_Forward_a_Year");
    }
}
