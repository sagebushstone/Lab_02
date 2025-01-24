import java.util.Calendar;
import java.util.Objects;

public class Person {
    private String id = "";
    private String firstName = "";
    private String lastName = "";
    private String title = "";
    private int yob = 0;

    // empty constructor to create an uninitialized Person
    public Person(){

    }
    public Person(String id, String firstName, String lastName, String title, int yob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.yob = yob;
    }

    /**
     * @return - the id of the Person
     */
    public String getId() {
        return id;
    }

    /**
     * @param id - what the ID should be set to for the Person
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return - the first name of the Person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName - what the firstName should be set to for the Person
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return - the last name of the Person
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return - the title of the Person
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return - the birth year of the Person
     */
    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    /**
     * @return - the full name, first and last, of the Person
     */
    public String getFullName(){
        return firstName + " " + lastName;
    }

    /**
     * @return - the formal name of the Person, including title
     */
    public String formalName(){
        return title + " " + getFullName();
    }

    /**
     * @return - the Person object in CSV format
     */
    public String toCSV(){
        return id + ", " + firstName + ", " + lastName + ", " + title + ", " + yob;
    }

    /**
     * @return - the Person object in JSON format
     */
    public String toJSON(){
        String Q = "\"";
        String QCM = "\", ";
        String QC = "\": \"";
        return "{" + Q + "ID" + QC + id + QCM
                + Q + "firstName" + QC +  firstName + QCM
                + Q + "lastName" + QC + lastName + QCM
                + Q + "title" + QC + title + QCM
                + Q + "yob" + Q + ": " + yob  + "}";
    }

    /**
     * @return - the Person object in XML format
     */
    public String toXML(){
        return "<Person>" +
                "<ID>" + id + "</ID>" +
                "<firstName>" + firstName + "</firstName>" +
                "<lastName>" + lastName + "</lastName>" +
                "<title>" + title + "</title>" +
                "<yob>" + yob + "</yob>" + "</Person>";
    }


    /**
     * @return the age of the Person based on the current year
     */
    public String getAge() {
        int age = Calendar.getInstance().get(Calendar.YEAR) - yob;
        return "" + age;
    }

    // overloading getAge
    /**
     * @return - the age of the Person based on a given year ("how old is this person in 2000?")
     */
    public String getAge(int year) {
        int age = year - yob;
        return "" + age;
    }

    /**
     * @return - the object in String format
     */
    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", yob=" + yob +
                '}';
    }
}
