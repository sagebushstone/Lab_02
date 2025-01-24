import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
public class PersonTest {
    Person p1 = new Person("000001", "Sage", "Bushstone", "Ms.", 2005);

    /*@BeforeEach
    void setUp() {
        p1 = ;
    }*/

    @Test
    public void setId() {
        p1.setId("000002");
        assertEquals("000002", p1.getId());
    }

    @Test
    public void setFirstName() {
        p1.setFirstName("Jack");
        assertEquals("Jack", p1.getFirstName());
    }

    @Test
    public void setLastName() {
        p1.setLastName("Smith");
        assertEquals("Smith", p1.getLastName());
    }

    @Test
    public void setTitle() {
        p1.setTitle("Dr.");
        assertEquals("Dr.", p1.getTitle());
    }

    @Test
    public void setYob() {
        p1.setYob(2000);
        assertEquals(2000, p1.getYob());
    }

    @Test
    public void getFullName() {
        assertEquals("Sage Bushstone", p1.getFullName());
    }

    @Test
    public void formalName() {
        assertEquals("Ms. Sage Bushstone", p1.formalName());
    }

    @Test
    public void toCSV() {
        assertEquals("000001, Sage, Bushstone, Ms., 2005", p1.toCSV());
    }

    @Test
    public void toJSON(){
        String Q = "\"";
        String QCM = "\", ";
        String QC = "\": \"";
        String expected = "{" + Q + "ID" + QC + "000001" + QCM
                            + Q + "firstName" + QC +  "Sage" + QCM
                            + Q + "lastName" + QC + "Bushstone" + QCM
                            + Q + "title" + QC + "Ms." + QCM
                            + Q + "yob" + Q + ": " + "2005" + "}";
        assertEquals(expected, p1.toJSON());
    }

    @Test
    public void toXML(){
        String expected = "<Person>" +
                "<ID>000001</ID>" +
                "<firstName>Sage</firstName>" +
                "<lastName>Bushstone</lastName>" +
                "<title>Ms.</title>" +
                "<yob>2005</yob>" + "</Person>";
        assertEquals(expected, p1.toXML());
    }

}