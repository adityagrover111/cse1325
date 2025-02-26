package message;

/**
 * Depicts a group with a name and status showing if it is active or not
 * 
 * @author Aditya Grover
 * @version 1.0
 * @since 1.0S
 */
public class Group {
    private String name;
    private boolean active;

    /**
     * creates a Group instance
     * 
     * @param name name of the group
     * @throws IllegalArgumentException if name is null or empty
     * @since 1.0
     * 
     */
    public Group(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("name cannot be empty");
        }
        this.name = name;
        this.active = true;
    }

    /**
     * Tells if the group is active
     * 
     * @return true if the account is active
     * @since 1.0
     */

    public boolean isActive() {
        return active;
    }

    /**
     * disables the group and sets active field to false
     * 
     * @since 1.0
     * 
     */
    public void disable() {
        active = false;
    }

    /**
     * enaables the group and sets active field to true
     * 
     * @since 1.0
     * 
     */
    public void enable() {
        active = true;
    }

    /**
     * returns the string representation of the group.
     *
     * @return the name of the group, with " [inactive]" if it is inactive
     * @since 1.0
     */
    @Override
    public String toString() {
        if (active == true)
            return name;
        else
            return name + " [inactive]";
    }
}