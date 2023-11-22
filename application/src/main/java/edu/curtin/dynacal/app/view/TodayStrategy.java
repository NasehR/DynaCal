package edu.curtin.dynacal.app.view;

import java.time.LocalDate;
import java.util.ResourceBundle;

public class TodayStrategy implements IDateStrategy {
    private ResourceBundle resourceBundle;

    public TodayStrategy(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return LocalDate.now();
    }

    @Override
    public String toString() {
        return resourceBundle.getString("Move_Backward_a_Year");
    }
}
