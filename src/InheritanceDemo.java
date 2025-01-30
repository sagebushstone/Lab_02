import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String args[]) {
        Worker johnW = new Worker("000001", "John", "Johnson", "Mr.", 2000, 35.40);
        Worker jackW = new Worker("000002", "Jack", "Jackson", "Mr.", 1997, 38.75);
        Worker jillW = new Worker("000003", "Jill", "Jameson", "Mr.", 1995, 40.5);
        SalaryWorker jonahSW = new SalaryWorker("000001", "Jonah", "Greene", "Mr.", 1995, 0, 80000);
        SalaryWorker vincentSW = new SalaryWorker("000002", "Vincent", "Kaplan", "Mr.", 2000, 0, 70000);
        SalaryWorker julianaSW = new SalaryWorker("000003", "Juliana", "Cho", "Mrs.", 2001, 0, 73000);

        ArrayList<Worker> workers= new ArrayList<>();
        workers.add(johnW);
        workers.add(jackW);
        workers.add(jillW);
        workers.add(jonahSW);
        workers.add(vincentSW);
        workers.add(julianaSW);


        System.out.printf("%15s%15s%15s%15s", "Name", "Week 1 Pay", "Week 2 Pay", "Week 3 Pay");
        System.out.println();
        for(Worker worker : workers){
            System.out.printf("%15s%15.2f%15.2f%15.2f", worker.getFullName(), worker.calculateWeeklyPay(40),
                    worker.calculateWeeklyPay(50), worker.calculateWeeklyPay(40));
            System.out.println();
        }
    }
}