package edu.curtin.dynacal.app.view;

import java.time.LocalDate;

/**
 * Interface for date strategies.
 */
public interface IDateStrategy {

    /**
     * Moves the current view date based on the strategy.
     *
     * @param currentViewDate The current view date.
     * @return The new date after applying the strategy.
     */
    LocalDate moveToNewDate(LocalDate currentViewDate);

    /**
     * Provides a string representation of the strategy.
     *
     * @return A string representation of the strategy.
     */
    @Override
    String toString();
}
