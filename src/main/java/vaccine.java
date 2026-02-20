import java.util.ArrayList;

public class vaccine {
    private int vaccineId;
    private String vaccineName;
    private int minAge;
    private int maxAge;
    private ArrayList<String> VaccineDiseases;

    public vaccine(int vaccineId, String vaccineName, int minAge, int maxAge) {
        this.vaccineId = vaccineId;
        this.vaccineName = vaccineName;
        this.minAge = minAge;
        this.maxAge = maxAge;
        VaccineDiseases=new ArrayList<>();
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public String getName() {
        return vaccineName;
    }

    public int getMinAge(){
        return minAge;
    }

    public int getMaxAge(){
        return maxAge;
    }

    public ArrayList<String> getVaccineDiseases(){
        return VaccineDiseases;
    }
}
