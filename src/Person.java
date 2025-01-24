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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String formalName(){
        return title + " " + getFullName();
    }

    public String toCSV(){
        return id + ", " + firstName + ", " + lastName + ", " + title + ", " + yob;
    }

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

    public String toXML(){
        return "<Person>" +
                "<ID>" + id + "</ID>" +
                "<firstName>" + firstName + "</firstName>" +
                "<lastName>" + lastName + "</lastName>" +
                "<title>" + title + "</title>" +
                "<yob>" + yob + "</yob>" + "</Person>";
    }


    public String getAge() {
        int age = Calendar.getInstance().get(Calendar.YEAR) - yob;
        return "" + age;
    }

    // overloading getAge
    public String getAge(int year) {
        int age = year - yob;
        return "" + age;
    }

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return yob == person.yob && Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(title, person.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, title, yob);
    }
}
