package edu.curtin.dynacal.app.view;

import java.time.LocalDate;
import java.util.ResourceBundle;

public class TakeWeekStrategy implements IDateStrategy {
    private ResourceBundle resourceBundle;

    public TakeWeekStrategy(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return currentViewDate.minusWeeks(1);
    }

    @Override
    public String toString() {
        return resourceBundle.getString("Move_Backward_a_Week");
    }
}
