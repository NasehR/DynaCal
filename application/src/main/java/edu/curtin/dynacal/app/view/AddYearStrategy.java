package edu.curtin.dynacal.app.view;

import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Implementation of the IDateStrategy interface for moving forward a year.
 */
public class AddYearStrategy implements IDateStrategy {

    // Class Field
    private ResourceBundle resourceBundle;

    /**
     * Constructor to initialize AddYearStrategy with a resource bundle.
     *
     * @param resourceBundle The resource bundle for localization.
     */
    public AddYearStrategy(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    /**
     * Moves the current view date forward by one year.
     *
     * @param currentViewDate The current view date.
     * @return The new date after moving forward by one year.
     */
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return currentViewDate.plusYears(1);
    }

    /**
     * Provides a string representation of the strategy, typically for display purposes.
     *
     * @return A string representation of the strategy.
     */
    @Override
    public String toString() {
        return resourceBundle.getString("Move_Forward_a_Year");
    }
}
