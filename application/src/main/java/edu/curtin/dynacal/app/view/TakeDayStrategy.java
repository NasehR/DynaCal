package edu.curtin.dynacal.app.view;

import java.time.LocalDate;
import java.util.ResourceBundle;

public class TakeDayStrategy implements IDateStrategy {
    private ResourceBundle resourceBundle;

    public TakeDayStrategy(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return currentViewDate.minusDays(1);
    }

    @Override
    public String toString() {
        return resourceBundle.getString("Move_Backward_a_Day");
    }
}
