import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product p1 = new Product("000001", "Apple", "Fuji", 3.25);

    @Test
    void setName() {
        p1.setName("Bread");
        assertEquals("Bread", p1.getName());
    }

    @Test
    void setDescription() {
        p1.setDescription("Granny Smith");
        assertEquals("Granny Smith", p1.getDescription());
    }

    @Test
    void setID() {
        p1.setID("000002");
        assertEquals("000002", p1.getID());
    }

    @Test
    void setCost() {
        p1.setCost(4.25);
        assertEquals(4.25, p1.getCost());
    }

    @Test
    public void toCSV(){
        assertEquals("000001, Apple, Fuji, 3.25", p1.toCSV());
    }

    @Test
    public void toJSON(){
        String Q = "\"";
        String QCM = "\", ";
        String QC = "\": \"";
        String expected = "{" + Q + "ID" + QC + "000001" + QCM
                + Q + "name" + QC +  "Apple" + QCM
                + Q + "description" + QC + "Fuji" + QCM
                + Q + "cost" + Q + ": " + 3.25 + "}";
        assertEquals(expected, p1.toJSON());
    }

    @Test
    public void toXML(){
        String expected = "<Product>" +
                "<ID>000001</ID>" +
                "<name>Apple</name>" +
                "<description>Fuji</description>" +
                "<cost>3.25</cost>" + "</Product>";
        assertEquals(expected, p1.toXML());
    }
}