package model;

/**
 * The Flora class represents a flora species, extending the Species class.
 */
public class Flora extends Species {

    private boolean hasFlowers;
    private boolean hasFruits;
    private double maxHeight;

    /**
     * Constructor to initialize a Flora object.
     * 
     * @param name            the name of the flora species
     * @param scientificName  the scientific name of the flora species
     * @param hasFlowers      whether the species has flowers
     * @param hasFruits       whether the species has fruits
     * @param maxHeight       the maximum height of the species
     */
    public Flora(String name, String scientificName, boolean hasFlowers, boolean hasFruits, double maxHeight) {
        super(name, scientificName);
        this.hasFlowers = hasFlowers;
        this.hasFruits = hasFruits;
        this.maxHeight = maxHeight;
    }

    /**
     * Checks if the species has flowers.
     * 
     * @return true if the species has flowers, false otherwise
     */
    public boolean hasFlowers() {
        return hasFlowers;
    }

    /**
     * Sets whether the species has flowers.
     * 
     * @param hasFlowers  true if the species has flowers, false otherwise
     */
    public void setHasFlowers(boolean hasFlowers) {
        this.hasFlowers = hasFlowers;
    }

    /**
     * Checks if the species has fruits.
     * 
     * @return true if the species has fruits, false otherwise
     */
    public boolean hasFruits() {
        return hasFruits;
    }

    /**
     * Sets whether the species has fruits.
     * 
     * @param hasFruits  true if the species has fruits, false otherwise
     */
    public void setHasFruits(boolean hasFruits) {
        this.hasFruits = hasFruits;
    }

    /**
     * Gets the maximum height of the species.
     * 
     * @return the maximum height of the species
     */
    public double getMaxHeight() {
        return maxHeight;
    }

    /**
     * Sets the maximum height of the species.
     * 
     * @param maxHeight  the new maximum height of the species
     */
    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    /**
     * Returns a string representation of the Flora object.
     * 
     * @return a string with the details of the flora species
     */
    @Override
    public String toString() {
        return super.toString() + ", Has flowers: " + hasFlowers + ", Has fruits: " + hasFruits + ", Max height: " + maxHeight;
    }
}
