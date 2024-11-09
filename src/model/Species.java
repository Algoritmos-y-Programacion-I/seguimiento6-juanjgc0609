package model;

/**
 * The Species class represents a species with a name and scientific name.
 */
public class Species {

    private String name;
    private String scientificName;

    /**
     * Constructor to initialize a Species object.
     * 
     * @param name            the name of the species
     * @param scientificName  the scientific name of the species
     */
    public Species(String name, String scientificName) {
        this.name = name;
        this.scientificName = scientificName;
    }

    /**
     * Gets the name of the species.
     * 
     * @return the name of the species
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the species.
     * 
     * @param name  the new name of the species
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the scientific name of the species.
     * 
     * @return the scientific name of the species
     */
    public String getScientificName() {
        return scientificName;
    }

    /**
     * Sets the scientific name of the species.
     * 
     * @param scientificName  the new scientific name of the species
     */
    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }
}
