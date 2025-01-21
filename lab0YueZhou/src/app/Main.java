package app;

import service.*;
import ui.*;


/**
 * Main Class
 * 
 * Author: Yue Zhou (Amir)
 * 
 * Description:
 * Entry point of the Modern Appliances application. Sets up the dependencies,
 * initializes services, and starts the application.
 * 
 * Injected Dependencies:
 * - `Ui`: Console-based user interface for interactions.
 * - `FileHandler`: Reads and writes appliance data to/from the filesystem.
 * - `ApplianceService`: Core logic for managing appliances.
 * - `ApplianceParser`: Parses appliance data from text files.
 * 
 * Interfaces:
 * - `Ui`: Provides a contract for user interaction.
 * - `FileHandler`: Manages file operations.
 * 
 * Key Responsibilities:
 * - Establish resources and services required by the application.
 * - Initialize the `App` class with its dependencies.
 * - Handle runtime errors and ensure a graceful application lifecycle.
 */

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize the Ui
            Ui ui = new ConsoleUi();

            // Initialize the FileHandler
            String resourceName = "appliances.txt";
            String writableDir = System.getProperty("user.dir") + "/data";
           
            FileHandler fileHandler = FileHandler.fromResource(resourceName, writableDir);
            
            ApplianceParser parser = new ApplianceParser();
            ApplianceService applianceService = new ApplianceService(fileHandler, parser);

            // Initialize and run the App
            App app = new App(ui, applianceService);
            app.run();

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
