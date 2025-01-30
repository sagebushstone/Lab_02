import java.util.Objects;

public class SalaryWorker extends Worker {
    private double annualSalary;

    public SalaryWorker(Worker worker, double annualSalary) {
        super(worker.getId(), worker.getFirstName(), worker.getLastName(), worker. getTitle(), worker.getYob(), worker.getHourlyPayRate());
        this.annualSalary = annualSalary;
    }

    public SalaryWorker(String id, String firstName, String lastName, String title, int yob, double hourlyPayRate, double annualSalary) {
        super(id, firstName, lastName, title, yob, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public double calculateWeeklyPay(double hoursWorked){
        return (double) Math.round((annualSalary / 52) * 100) / 100;
    }
    public void displayWeeklyPay(){
        System.out.println("Annual salary: $" + annualSalary);
        System.out.printf("Weekly Salary: $%.2f", calculateWeeklyPay(0));
    }

    public String toCSV(){
        return super.toCSV() + ", " + annualSalary;
    }

    /**
     * @return - the Worker object in JSON format
     */
    public String toJSON(){
        String workerSub = super.toJSON().substring(1, super.toJSON().length()-1);
        String Q = "\"";
        String QCM = "\", ";
        String QC = "\": \"";
        return "{" + workerSub + ", " + Q + "annualSalary" + "\": " + annualSalary + "}";
    }

    /**
     * @return - the Worker object in XML format
     */
    public String toXML(){
        String workerSub = super.toXML().substring(8, super.toXML().length()-9);
        return "<SalaryWorker>" + workerSub + "<annualSalary>" + annualSalary + "</annualSalary></SalaryWorker>";
    }

    @Override
    public String toString() {
        return "SalaryWorker{" + super.toString() +
                "annualSalary=" + annualSalary +
                '}';
    }

}
