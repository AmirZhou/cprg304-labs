package app;

import service.*;
import ui.*;

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
