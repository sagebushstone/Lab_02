import java.util.Objects;

public class Worker extends Person {
    private double hourlyPayRate;

    public Worker(Person person, double hourlyPayRate) {
        super(person.getId(), person.getFirstName(), person.getLastName(), person.getTitle(), person.getYob());
        this.hourlyPayRate = hourlyPayRate;
    }

    public Worker(String id, String firstName, String lastName, String title, int yob, double hourlyPayRate) {
        super(id, firstName, lastName, title, yob);
        this.hourlyPayRate = hourlyPayRate;
    }


    public double calculateWeeklyPay(double hoursWorked){
        double overtime = hoursWorked - 40;
        if(overtime > 0){
            return (40 + (overtime * 1.5)) * hourlyPayRate;
        }
        return hoursWorked * hourlyPayRate;
    }

    public void displayWeeklyPay(double hoursWorked){
        double overtime = hoursWorked - 40;
        double weeklyHours = hoursWorked - overtime;
        System.out.printf("Hours of regular pay: %.2f", weeklyHours);
        System.out.printf("\nPay without overtime: $%.2f", weeklyHours * hourlyPayRate);
        System.out.printf("\nHours of overtime pay: %.2f", overtime);
        System.out.printf("\nOvertime pay: $%.2f", (overtime *1.5)*hourlyPayRate);
        System.out.printf("\nTotal hours: %.2f", hoursWorked);
        System.out.printf("\nTotal combined pay: $%.2f", calculateWeeklyPay(hoursWorked));
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    /**
     * @return - the Worker object in CSV format
     */
    public String toCSV(){
        return super.toCSV() + ", " + hourlyPayRate;
    }

    /**
     * @return - the Worker object in JSON format
     */
    public String toJSON(){
        String personSub = super.toJSON().substring(1, super.toJSON().length()-1);
        String Q = "\"";
        String QCM = "\", ";
        String QC = "\": \"";
        return "{" + personSub + ", " + Q + "hourlyPayRate" + "\": " + hourlyPayRate + "}";
    }

    /**
     * @return - the Worker object in XML format
     */
    public String toXML(){
        String personSub = super.toXML().substring(8, super.toXML().length()-9);
        return "<Worker>" + personSub + "<hourlyPayRate>" + hourlyPayRate + "</hourlyPayRate></Worker>";
    }

    @Override
    public String toString() {
        return "Worker{" + super.toString() +
                "hourlyPayRate=" + hourlyPayRate +
                '}';
    }

}
