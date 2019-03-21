package people;
/*
 * Person functionality
 */
public interface PersonSpecification {
    public String firstName();
    public String lastName();
    public int month();
    public int day();
    public int year();
    public String initials();
    public boolean isBoomer();
}