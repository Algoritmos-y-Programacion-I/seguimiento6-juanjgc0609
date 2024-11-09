package model;

import java.util.ArrayList;

/**
 * The SpeciesController class manages a list of species, providing methods
 * to register, edit, remove, and retrieve species information.
 */
public class SpeciesController {

    // List to hold all species
    private ArrayList<Species> species;

    /**
     * Constructor initializes the species list.
     */
    public SpeciesController() {
        this.species = new ArrayList<>();
    }

    /**
     * Registers a new Flora species.
     * 
     * @param name            Name of the species
     * @param scientificName  Scientific name of the species
     * @param hasFlowers      Whether the species has flowers
     * @param hasFruits       Whether the species has fruits
     * @param maxHeight       Maximum height of the species
     * @return                True if the species was added, false otherwise
     */
    public boolean registerFlora(String name, String scientificName, boolean hasFlowers, boolean hasFruits, double maxHeight) {
        Flora newFlora = new Flora(name, scientificName, hasFlowers, hasFruits, maxHeight);
        return species.add(newFlora);
    }

    /**
     * Registers a new Fauna species.
     * 
     * @param name            Name of the species
     * @param scientificName  Scientific name of the species
     * @param isMigratory     Whether the species is migratory
     * @param maxWeight       Maximum weight of the species
     * @return                True if the species was added, false otherwise
     */
    public boolean registerFauna(String name, String scientificName, boolean isMigratory, double maxWeight) {
        Fauna newFauna = new Fauna(name, scientificName, isMigratory, maxWeight);
        return species.add(newFauna);
    }

    /**
     * Edits an existing Flora species.
     * 
     * @param index           Index of the species to be edited
     * @param name            Name of the species
     * @param scientificName  Scientific name of the species
     * @param hasFlowers      Whether the species has flowers
     * @param hasFruits       Whether the species has fruits
     * @param maxHeight       Maximum height of the species
     * @return                True if the species was edited, false otherwise
     */
    public boolean editFlora(int index, String name, String scientificName, boolean hasFlowers, boolean hasFruits, double maxHeight) {
        if (index >= 0 && index < species.size() && species.get(index) instanceof Flora) {
            species.set(index, new Flora(name, scientificName, hasFlowers, hasFruits, maxHeight));
            return true;
        }
        return false;
    }

    /**
     * Edits an existing Fauna species.
     * 
     * @param index           Index of the species to be edited
     * @param name            Name of the species
     * @param scientificName  Scientific name of the species
     * @param isMigratory     Whether the species is migratory
     * @param maxWeight       Maximum weight of the species
     * @return                True if the species was edited, false otherwise
     */
    public boolean editFauna(int index, String name, String scientificName, boolean isMigratory, double maxWeight) {
        if (index >= 0 && index < species.size() && species.get(index) instanceof Fauna) {
            species.set(index, new Fauna(name, scientificName, isMigratory, maxWeight));
            return true;
        }
        return false;
    }

    /**
     * Removes a species at the given index.
     * 
     * @param index  Index of the species to be removed
     * @return       True if the species was removed, false otherwise
     */
    public boolean removeSpecies(int index) {
        if (index >= 0 && index < species.size() && species.get(index) != null) {
            species.remove(index);
            return true;
        }
        return false;
    }

    /**
     * Retrieves the table of all species.
     * 
     * @return  A 2D array representing the species table
     */
    public String[][] getSpeciesTable() {
        // Create the species table
        String[][] table = new String[species.size()][];
        int count = 0;

        // Fill the table
        for (Species s : species) {
            if (s instanceof Flora) {
                Flora flora = (Flora) s;
                table[count++] = new String[]{
                        "Flora", flora.getName(), flora.getScientificName(),
                        String.valueOf(flora.hasFlowers()), String.valueOf(flora.hasFruits()),
                        String.valueOf(flora.getMaxHeight())
                };
            } else if (s instanceof Fauna) {
                Fauna fauna = (Fauna) s;
                table[count++] = new String[]{
                        "Fauna", fauna.getName(), fauna.getScientificName(),
                        String.valueOf(fauna.isMigratory()), String.valueOf(fauna.getMaxWeight())
                };
            }
        }

        // If there are no species, return an empty table
        return table.length > 0 ? table : new String[0][0];
    }
}
