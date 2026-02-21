import java.util.ArrayList;

public class vaccine {
    private int vaccineId;
    private String vaccineName;
    private int minAge;
    private int maxAge;
    private int boosterDays;

    // simple rule flags
    private boolean blockedWhenPregnant;
    private boolean requiresPregnant;
    private boolean requiresIMC;

    // disease-based eligibility (optional list)
    private ArrayList<String> requiredDiseases;

    public vaccine(int vaccineId, String vaccineName, int minAge, int maxAge, int boosterDays) {
        this.vaccineId = vaccineId;
        this.vaccineName = vaccineName;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.boosterDays = boosterDays;

        blockedWhenPregnant = false;
        requiresPregnant = false;
        requiresIMC = false;

        requiredDiseases = new ArrayList<>();
    }

    public int getVaccineId() { return vaccineId; }
    public String getName() { return vaccineName; }
    public int getMinAge() { return minAge; }
    public int getMaxAge() { return maxAge; }
    public int getBoosterDays() { return boosterDays; }

    // getters required by EligibilityService
    public boolean getBlockedWhenPregnant() { return blockedWhenPregnant; }
    public boolean getRequiresPregnant() { return requiresPregnant; }
    public boolean getRequiresIMC() { return requiresIMC; }
    public ArrayList<String> getRequiredDiseases() { return requiredDiseases; }

    // setters for Main demo setup
    public void setBlockedWhenPregnant(boolean val) { blockedWhenPregnant = val; }
    public void setRequiresPregnant(boolean val) { requiresPregnant = val; }
    public void setRequiresIMC(boolean val) { requiresIMC = val; }

    public void addRequiredDisease(String d) {
        if (d != null && !d.isEmpty()) requiredDiseases.add(d);
    }
}