package ui;

import java.util.Scanner;
import model.SpeciesController;

/**
 * The SpeciesExecutable class provides a console-based interface for managing species.
 */
public class SpeciesExecutable {

    private Scanner reader;
    private SpeciesController speciesController;

    /**
     * Main method to run the SpeciesExecutable program.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        SpeciesExecutable exe = new SpeciesExecutable();
        exe.showMainMenu();
    }

    /**
     * Constructor to initialize the SpeciesExecutable object.
     */
    public SpeciesExecutable() {
        reader = new Scanner(System.in);
        speciesController = new SpeciesController();
    }

    /**
     * Displays the main menu and handles user input.
     */
    public void showMainMenu() {
        System.out.println("Welcome to Icesi Species");

        boolean stopFlag = false;

        while (!stopFlag) {
            System.out.println("\nType an option");
            System.out.println("1. Register a Species");
            System.out.println("2. Edit a Species");
            System.out.println("3. Delete a Species");
            System.out.println("4. Show all Species");
            System.out.println("0. Exit");

            int mainOption = reader.nextInt();

            switch (mainOption) {
                case 1:
                    registerSpecies();
                    break;
                case 2:
                    editSpecies();
                    break;
                case 3:
                    deleteSpecies();
                    break;
                case 4:
                    showAllSpecies();
                    break;
                case 0:
                    System.out.println("Thanks for using our system");
                    stopFlag = true;
                    break;
                default:
                    System.out.println("You must type a valid option");
                    break;
            }
        }
    }

    /**
     * Registers a new species.
     */
    public void registerSpecies() {
        System.out.println("Type the new Species' name: ");
        String name = reader.next();

        System.out.println("Type the new Species' scientific name: ");
        String scientificName = reader.next();

        System.out.println("Is it flora or fauna? (Type 'flora' or 'fauna')");
        String type = reader.next().toLowerCase();

        boolean result = false;

        if (type.equals("flora")) {
            System.out.println("Does it have flowers? (true/false)");
            boolean hasFlowers = reader.nextBoolean();

            System.out.println("Does it have fruits? (true/false)");
            boolean hasFruits = reader.nextBoolean();

            System.out.println("Type the maximum height (in meters) it can reach: ");
            double maxHeight = reader.nextDouble();

            result = speciesController.registerFlora(name, scientificName, hasFlowers, hasFruits, maxHeight);

        } else if (type.equals("fauna")) {
            System.out.println("Is it migratory? (true/false)");
            boolean isMigratory = reader.nextBoolean();

            System.out.println("Type the maximum weight (in kilograms) it can reach: ");
            double maxWeight = reader.nextDouble();

            result = speciesController.registerFauna(name, scientificName, isMigratory, maxWeight);
        }

        if (result) {
            System.out.println("Species registered successfully");
        } else {
            System.out.println("Error, Species couldn't be registered");
        }
    }

    /**
     * Edits an existing species.
     */
    public void editSpecies() {
        System.out.println("Which Species do you want to edit?");

        showAllSpecies();

        int index = reader.nextInt() - 1;

        System.out.println("Type the new Species' name: ");
        String name = reader.next();

        System.out.println("Type the new Species' scientific name: ");
        String scientificName = reader.next();

        System.out.println("Is it flora or fauna? (Type 'flora' or 'fauna')");
        String type = reader.next().toLowerCase();

        boolean result = false;

        if (type.equals("flora")) {
            System.out.println("Does it have flowers? (true/false)");
            boolean hasFlowers = reader.nextBoolean();

            System.out.println("Does it have fruits? (true/false)");
            boolean hasFruits = reader.nextBoolean();

            System.out.println("Type the maximum height (in meters) it can reach: ");
            double maxHeight = reader.nextDouble();

            result = speciesController.editFlora(index, name, scientificName, hasFlowers, hasFruits, maxHeight);

        } else if (type.equals("fauna")) {
            System.out.println("Is it migratory? (true/false)");
            boolean isMigratory = reader.nextBoolean();

            System.out.println("Type the maximum weight (in kilograms) it can reach: ");
            double maxWeight = reader.nextDouble();

            result = speciesController.editFauna(index, name, scientificName, isMigratory, maxWeight);
        }

        if (result) {
            System.out.println("Species edited successfully");
        } else {
            System.out.println("Error, Species couldn't be edited");
        }
    }

    /**
     * Deletes an existing species.
     */
    public void deleteSpecies() {
        System.out.println("Which Species do you want to delete?");

        showAllSpecies();

        int index = reader.nextInt() - 1;

        if (speciesController.removeSpecies(index)) {
            System.out.println("Species deleted successfully");
        } else {
            System.out.println("Error, Species couldn't be deleted");
        }
    }

    /**
     * Displays all registered species in a formatted table.
     */
    public void showAllSpecies() {
        String[][] speciesTable = speciesController.getSpeciesTable();

        if (speciesTable.length > 0) {
            System.out.println("Species List:");
            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.println("| Index | Name         | Scientific Name | Type   | Flowers | Fruits | Max Height | Migratory | Max Weight |");
            System.out.println("------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < speciesTable.length; i++) {
                String[] species = speciesTable[i];
                System.out.printf("| %-5d | %-12s | %-15s | %-6s | %-7s | %-6s | %-9s | %-9s | %-9s |\n",
                        (i + 1), species[1], species[2], species[0],
                        (species[0].equals("Flora") ? species[3] : "N/A"),
                        (species[0].equals("Flora") ? species[4] : "N/A"),
                        (species[0].equals("Flora") ? species[5] : "N/A"),
                        (species[0].equals("Fauna") ? species[3] : "N/A"),
                        (species[0].equals("Fauna") ? species[4] : "N/A"));
            }
            System.out.println("------------------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("There aren't any species registered yet");
        }
    }
}
