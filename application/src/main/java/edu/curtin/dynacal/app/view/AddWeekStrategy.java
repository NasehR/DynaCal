package edu.curtin.dynacal.app.view;

import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddWeekStrategy implements IDateStrategy {
    private ResourceBundle resourceBundle;

    public AddWeekStrategy(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return currentViewDate.plusWeeks(1);
    }

    @Override
    public String toString() {
        return resourceBundle.getString("Move_Forward_a_Week");
    }
}
