package edu.curtin.dynacal.app.view;

import java.time.LocalDate;
import java.util.ResourceBundle;

public class TakeMonthStrategy implements IDateStrategy {
    private ResourceBundle resourceBundle;

    public TakeMonthStrategy(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return currentViewDate.minusMonths(1);
    }

    @Override
    public String toString() {
        return resourceBundle.getString("Move_Backward_a_Month");
    }
}
