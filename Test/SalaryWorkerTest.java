import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SalaryWorkerTest {
    SalaryWorker sw = new SalaryWorker("000001", "Sage", "Bushstone", "Ms.", 2005, 32.50, 70000);

    @Test
    void setAnnualSalary() {
        sw.setAnnualSalary(55000);
        assertEquals(55000, sw.getAnnualSalary());
    }

    @Test
    void calculateWeeklyPay() {
        assertEquals(1346.15, (double) Math.round(sw.calculateWeeklyPay(0) * 100) /100);
    }

    @Test
    void toCSV() {
        String csv = "000001, Sage, Bushstone, Ms., 2005, 32.5, 70000.0";
        assertEquals(csv, sw.toCSV());
    }

    @Test
    void toJSON() {
        String json = "{\"ID\": \"000001\", \"firstName\": \"Sage\", \"lastName\": \"Bushstone\", \"title\": \"Ms.\", \"yob\": 2005, \"hourlyPayRate\": 32.5, \"annualSalary\": 70000.0}";
        assertEquals(json, sw.toJSON());
    }

    @Test
    void toXML() {
        String xml = "<SalaryWorker><ID>000001</ID><firstName>Sage</firstName><lastName>Bushstone</lastName><title>Ms.</title><yob>2005</yob><hourlyPayRate>32.5</hourlyPayRate><annualSalary>70000.0</annualSalary></SalaryWorker>";
        assertEquals(xml, sw.toXML());
    }
}