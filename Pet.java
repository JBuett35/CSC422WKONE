/** Created by James Buettner on Wednesday, October 28, 2020 for CSC 422. */

package pets;

/**
 * The Class Pet.
 */
public class Pet {
    /** The name. */
    private String name;
    /** The age. */
    private int age;
    /**
     * Instantiates a new pet.
     *
     * @param name the name
     * @param age the age
     */
    public Pet(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Gets the age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }
    /**
     * Sets the age.
     *
     * @param age the new age
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        String s = "";
        s = String.format("%5s%10s%10s%5d%5s\n", "|", name, "|", age, "|");
        return s;
    }
}