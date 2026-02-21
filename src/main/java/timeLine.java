import java.util.ArrayList;

public class timeLine {

    public void display(patient p, ArrayList<EligibilityResult> results) {
        System.out.println("Immunization Timeline for " + p.getName());

        for (EligibilityResult r : results) {

            String status = r.getStatus();

            String last;
            if (r.getLastDose() == null) {
                last = "NONE";
            } else {
                last = r.getLastDose().toString();
            }
            String due;
            if (r.getDueDate() == null) {
                due = "N/A";
            } else {
                due = r.getDueDate().toString();
            }

            System.out.println("- " + r.getVaccine().getName()
                    + " | Status: " + status
                    + " | Last: " + last
                    + " | Due: " + due);
        }
    }
}