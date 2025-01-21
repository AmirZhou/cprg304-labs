package ui;

import java.util.Scanner;

public class ConsoleUi implements Ui {
    private final Scanner scanner;

    public ConsoleUi() {
        this.scanner = new Scanner(System.in);
    }

    // Displays a general message to the user
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    // Displays a menu for the user
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

    // Gets a numeric option from the user
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

    // Gets a string input from the user
    @Override
    public String getUserInput() {
        System.out.print("> ");
        return scanner.nextLine().trim();
    }
}
