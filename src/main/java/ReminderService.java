import java.util.ArrayList;

public class ReminderService {

    public ArrayList<String> buildReminders(patient p, ArrayList<EligibilityResult> results) {
        ArrayList<String> msgs = new ArrayList<>();

        for (EligibilityResult r : results) {
            String s = r.getStatus();
            if (s.equals("OVERDUE") || s.equals("DUE_SOON")) {
                msgs.add("[EMAIL] " + p.getName() + ": " + r.getVaccine()+ " is " + s + " (Due: " + r.getDueDate() + ")");
                msgs.add("[SMS] " + r.getVaccine().getName() + " " + s + " due " + r.getDueDate());
                msgs.add("[IN-APP] Reminder: " + r.getVaccine().getName() + " " + s);
            }
        }
        return msgs;
    }
}