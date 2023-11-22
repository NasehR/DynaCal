package edu.curtin.dynacal.app.view;

import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Implementation of the IDateStrategy interface for moving forward a month.
 */
public class AddMonthStrategy implements IDateStrategy {

    // Class Field
    private ResourceBundle resourceBundle;

    /**
     * Constructor to initialize AddMonthStrategy with a resource bundle.
     *
     * @param resourceBundle The resource bundle for localization.
     */
    public AddMonthStrategy(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    /**
     * Moves the current view date forward by one month.
     *
     * @param currentViewDate The current view date.
     * @return The new date after moving forward by one month.
     */
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return currentViewDate.plusMonths(1);
    }

    /**
     * Provides a string representation of the strategy, typically for display purposes.
     *
     * @return A string representation of the strategy.
     */
    @Override
    public String toString() {
        return resourceBundle.getString("Move_Forward_a_Month");
    }
}
