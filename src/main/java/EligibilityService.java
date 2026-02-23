import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class EligibilityService {

    public ArrayList<EligibilityResult> evaluate(patient p, ArrayList<vaccine> vaccines, int dueSoonDays) {
        ArrayList<EligibilityResult> out = new ArrayList<>();
        LocalDate today = LocalDate.now();
        int age = Period.between(p.getDOB(), today).getYears();

        for (vaccine v : vaccines) {

            boolean eligible = true;
            String reason = "OK";

            // 1) Age check
            if (age < v.getMinAge() || age > v.getMaxAge()) {
                eligible = false;
                reason = "Age not in range";
            }

            // 2) Pregnancy
            if (eligible) {
                if (p.isPregnant() && v.getBlockedWhenPregnant()) {
                    eligible = false;
                    reason = "Not allowed in pregnancy";
                }
            }
            // 3) Risk-based requirement rules (only if vaccine requires it)
            if (eligible) {
                if (v.getRequiresPregnant() && !p.isPregnant()) {
                    eligible = false;
                    reason = "Only recommended if pregnant";
                }
            }
            if (eligible) {
                if (v.getRequiresIMC() && !p.isIMC()) {
                    eligible = false;
                    reason = "Only recommended if immunocompromised";
                }
            }

            // 4) Disease requirement rule
            if (eligible) {
                if (v.getRequiredDiseases().size() > 0) {
                    boolean hasMatch = false;

                    for (String d : p.getDiseases()) {
                        for (String req : v.getRequiredDiseases()) {
                            if (d.equalsIgnoreCase(req)) {
                                hasMatch = true;
                            }
                        }
                    }

                    if (!hasMatch) {
                        eligible = false;
                        reason = "Missing required disease risk";
                    }
                }
            }

            // If not eligible, record and continue
            if  (!eligible) {
                out.add(new EligibilityResult(v, "NOT_ELIGIBLE", null, null));
                continue;
            }

            // 5) Booster schedule based on last dose
            LocalDate last = lastDose(p, v.getVaccineId());
            LocalDate due;

            if (last == null) {
                due = today;
            } else {
                due = last.plusDays(v.getBoosterDays());
            }

            String status;

            if (last == null) {
                status = "ELIGIBLE_NOW";
            } else if (today.isAfter(due)) {
                status = "OVERDUE";
            } else {
                LocalDate dueSoonCutoff = due.minusDays(dueSoonDays);
                if (today.isAfter(dueSoonCutoff) || today.isEqual(dueSoonCutoff)) {
                    status = "DUE_SOON";
                } else {
                    status = "UP_TO_DATE";
                }
            }

            out.add(new EligibilityResult(v, status, last, due));
        }

        return out;
    }

    private LocalDate lastDose(patient p, int vaccineId) {
        LocalDate last = null;

        for (vaccineRecord r : p.getVaccineHistory()) {
            if (r.getVaccineId() == vaccineId) {
                if (last == null) {
                    last = r.getDateReceived();
                } else {
                    if (r.getDateReceived().isAfter(last)) {
                        last = r.getDateReceived();
                    }
                }
            }
        }

        return last;
    }
}