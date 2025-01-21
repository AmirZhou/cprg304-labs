package ui;

import java.util.Scanner;

/**
 * ConsoleUi Class
 * 
 * Provides a console-based implementation of the Ui interface.
 * Handles user interactions through the terminal using a Scanner for input.
 * 
 * Author: Yue Zhou (Amir)
 * 
 * Functionality:
 * - Displays messages and menus in the console.
 * - Reads numeric and text inputs from the user.
 */

public class ConsoleUi implements Ui {
    private final Scanner scanner;
    
    /**
     * Constructs a ConsoleUi with a Scanner for input handling.
     */
    public ConsoleUi() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays a general message to the user in the console.
     *
     * @param message The message to display.
     */
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Displays the main menu for the application.
     * Lists the available options for user selection.
     */
    @Override
    public void displayMenu() {
        System.out.println("Welcome to Modern Appliances!");
        System.out.println("How may we assist you?");
        System.out.println("1 – Check out appliance");
        System.out.println("2 – Find appliances by brand");
        System.out.println("3 – Display appliances by type");
        System.out.println("4 – Produce random appliance list");
        System.out.println("5 – Save & exit");
    }

    /**
     * Prompts the user for a numeric option and validates the input.
     *
     * @return The validated numeric option.
     */
    @Override
    public int getUserOption() {
        while (true) {
            try {
                System.out.print("> ");
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                displayMessage("Invalid input. Please enter a number.");
            }
        }
    }

    /**
     * Prompts the user for a text input.
     *
     * @return The user's input as a trimmed string.
     */
    @Override
    public String getUserInput() {
        System.out.print("> ");
        return scanner.nextLine().trim();
    }
}
