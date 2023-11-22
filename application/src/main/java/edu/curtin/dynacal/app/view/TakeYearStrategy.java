package edu.curtin.dynacal.app.view;

import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Strategy for moving the current view date backward by one year.
 */
public class TakeYearStrategy implements IDateStrategy {

    private ResourceBundle resourceBundle;

    /**
     * Constructs the strategy with a resource bundle.
     *
     * @param resourceBundle The resource bundle for obtaining display text.
     */
    public TakeYearStrategy(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    /**
     * Moves the current view date backward by one year.
     *
     * @param currentViewDate The current view date.
     * @return The new date after moving backward by one year.
     */
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return currentViewDate.minusYears(1);
    }

    /**
     * Provides a string representation of the strategy.
     *
     * @return A string representation of moving backward by one year.
     */
    @Override
    public String toString() {
        return resourceBundle.getString("Move_Backward_a_Year");
    }
}
