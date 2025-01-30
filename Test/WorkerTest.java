import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class WorkerTest {
    Worker w = new Worker("000001", "Sage", "Bushstone", "Ms.", 2005, 32.50);

    @Test
    void calculateWeeklyPay() {
        assertEquals(1397.5, w.calculateWeeklyPay(42));
        assertEquals(1300, w.calculateWeeklyPay(40));
    }

    @Test
    void setHourlyPayRate() {
        w.setHourlyPayRate(55000);
        assertEquals(55000, w.getHourlyPayRate());
    }

    @Test
    void toCSV() {
        String csv = "000001, Sage, Bushstone, Ms., 2005, 32.5";
        assertEquals(csv, w.toCSV());
    }

    @Test
    void toJSON() {
        String json = "{\"ID\": \"000001\", \"firstName\": \"Sage\", \"lastName\": \"Bushstone\", \"title\": \"Ms.\", \"yob\": 2005, \"hourlyPayRate\": 32.5}";
        assertEquals(json, w.toJSON());
    }

    @Test
    void toXML() {
        String xml = "<Worker><ID>000001</ID><firstName>Sage</firstName><lastName>Bushstone</lastName><title>Ms.</title><yob>2005</yob><hourlyPayRate>32.5</hourlyPayRate></Worker>";
        assertEquals(xml, w.toXML());
    }
}