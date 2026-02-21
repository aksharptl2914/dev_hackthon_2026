import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        clinic c = new clinic();

        vaccine flu = new vaccine(1, "Flu Shot", 5, 120, 365);

        vaccine tetanus = new vaccine(2, "Tetanus", 10, 120, 3650);

        vaccine covid = new vaccine(3, "COVID Booster", 12, 120, 180);
        covid.setRequiresIMC(true);     // only recommended if immunocompromised

        c.addVaccine(flu);
        c.addVaccine(tetanus);
        c.addVaccine(covid);

        patient p1 = new patient(1001, "Akshar Patel", LocalDate.of(2002, 5, 10), "Winnipeg", false, false);
        p1.addDisease("asthma");

        patient p2 = new patient(1002, "Vrujal Patel", LocalDate.of(1995, 7, 20), "Winnipeg", true, false);

        patient p3 = new patient(1003, "John", LocalDate.of(1980, 3, 2), "Winnipeg", false, true);

        p1.addRecord(1, LocalDate.now().minusDays(400));   // Flu overdue
        p1.addRecord(3, LocalDate.now().minusDays(170));   // COVID due soon
        p2.addRecord(2, LocalDate.now().minusDays(2000));  // Tetanus up to date
        p3.addRecord(3, LocalDate.now().minusDays(300));   // COVID overdue

        c.addPatient(p1);
        c.addPatient(p2);
        c.addPatient(p3);

        EligibilityService es = new EligibilityService();
        timeLine tl = new timeLine();
        ReminderService rs = new ReminderService();

        System.out.println("==== Patient 1 ====");
        ArrayList<EligibilityResult> r1 = es.evaluate(p1, c.getVaccines(), 30);
        tl.display(p1, r1);
        printReminders(rs.buildReminders(p1, r1));

        System.out.println();
        System.out.println("==== Patient 2 ====");
        ArrayList<EligibilityResult> r2 = es.evaluate(p2, c.getVaccines(), 30);
        tl.display(p2, r2);
        printReminders(rs.buildReminders(p2, r2));

        System.out.println();
        System.out.println("==== Patient 3 ====");
        ArrayList<EligibilityResult> r3 = es.evaluate(p3, c.getVaccines(), 30);
        tl.display(p3, r3);
        printReminders(rs.buildReminders(p3, r3));
    }

    private static void printReminders(ArrayList<String> msgs) {
        if (msgs.size() == 0) {
            System.out.println("No reminders to send");
            return;
        }

        System.out.println("Reminders");
        for (String m : msgs) {
            System.out.println(m);
        }
    }
}