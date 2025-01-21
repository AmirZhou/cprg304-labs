package ui;

/**
 * Ui Interface
 * 
 * Provides methods for user interaction, including displaying messages, menus,
 * and receiving user inputs.
 * 
 * Author: Yue Zhou (Amir)
 * 
 * Functionality:
 * - Display general messages and menus to the user.
 * - Receive numeric and text inputs from the user.
 * 
 * Implementing Class:
 * - ConsoleUi: Implementation for console-based user interaction.
 */

public interface Ui {
	
	/**
     * Displays a message to the user.
     *
     * @param message The message to display.
     */
	public void displayMessage(String message);
	
	/**
     * Displays the main menu for user selection.
     */
	public void displayMenu();
	
	/**
     * Prompts and retrieves a numeric option from the user.
     *
     * @return The user's numeric selection.
     */
	public int getUserOption();
	
	/**
     * Prompts and retrieves a text input from the user.
     *
     * @return The user's input as a string.
     */
	public String getUserInput();
}
