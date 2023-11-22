package edu.curtin.dynacal.app.view;

import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * The TodayStrategy class represents a strategy to move the current view date to today.
 * It implements the IDateStrategy interface.
 */
public class TodayStrategy implements IDateStrategy {
    private ResourceBundle resourceBundle;

    /**
     * Constructs a TodayStrategy with the specified ResourceBundle.
     *
     * @param resourceBundle The ResourceBundle for localized strings.
     */
    public TodayStrategy(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    /**
     * Moves the current view date to today.
     *
     * @param currentViewDate The current view date.
     * @return The new date after moving to today.
     */
    @Override
    public LocalDate moveToNewDate(LocalDate currentViewDate) {
        return LocalDate.now();
    }

    /**
     * Returns a localized string representation of moving to today.
     *
     * @return A string representing moving to today.
     */
    @Override
    public String toString() {
        return resourceBundle.getString("Move_to_Today");
    }
}
