package model;

/**
 * The Fauna class represents a fauna species, extending the Species class.
 */
public class Fauna extends Species {

    private boolean isMigratory;
    private double maxWeight;

    /**
     * Constructor to initialize a Fauna object.
     * 
     * @param name            the name of the fauna species
     * @param scientificName  the scientific name of the fauna species
     * @param isMigratory     whether the species is migratory
     * @param maxWeight       the maximum weight of the species
     */
    public Fauna(String name, String scientificName, boolean isMigratory, double maxWeight) {
        super(name, scientificName);
        this.isMigratory = isMigratory;
        this.maxWeight = maxWeight;
    }

    /**
     * Checks if the species is migratory.
     * 
     * @return true if the species is migratory, false otherwise
     */
    public boolean isMigratory() {
        return isMigratory;
    }

    /**
     * Sets whether the species is migratory.
     * 
     * @param isMigratory  true if the species is migratory, false otherwise
     */
    public void setMigratory(boolean isMigratory) {
        this.isMigratory = isMigratory;
    }

    /**
     * Gets the maximum weight of the species.
     * 
     * @return the maximum weight of the species
     */
    public double getMaxWeight() {
        return maxWeight;
    }

    /**
     * Sets the maximum weight of the species.
     * 
     * @param maxWeight  the new maximum weight of the species
     */
    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    /**
     * Returns a string representation of the Fauna object.
     * 
     * @return a string with the details of the fauna species
     */
    @Override
    public String toString() {
        return super.toString() + ", Is migratory: " + isMigratory + ", Max weight: " + maxWeight;
    }
}
