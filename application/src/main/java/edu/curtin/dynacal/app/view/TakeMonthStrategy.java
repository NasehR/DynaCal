package edu.curtin.dynacal.app.view;

import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Strategy for moving the current view date backward by one month.
 */
public class TakeMonthStrategy implements IDateStrategy {
    private ResourceBundle resourceBundle;

    /**
     * Constructs the strategy with a resource bundle.
     *
     * @param resourceBundle The resource bundle for obtaining display text.
     */
    public TakeMonthStrategy(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    /**
     * Moves the current view date backward by one month.
     *
     * @param currentViewDate The current view date.
     * @return The new date after moving backward by one month.
     */
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return currentViewDate.minusMonths(1);
    }

    /**
     * Provides a string representation of the strategy.
     *
     * @return A string representation of moving backward by one month.
     */
    @Override
    public String toString() {
        return resourceBundle.getString("Move_Backward_a_Month");
    }
}
