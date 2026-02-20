import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class vaccineEligibility {
    public boolean isAtLeastAge(patient p, int minAge) {
        LocalDate dob = p.getDOB();// must be LocalDate
        int age = Period.between(dob, LocalDate.now()).getYears();
        return age >= minAge;
    }

    // Example: check if patient is within age range
    public boolean isAgeBetween(patient p,vaccine vaccines) {
        int age = Period.between(p.getDOB(), LocalDate.now()).getYears();
        int min=vaccines.getMinAge();
        int max= vaccines.getMaxAge();
        return age >= min && age <= max;
    }

    public boolean riskFactors(patient p){
        if(p.isPregnant()||p.isIMC()){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean checkVaccineHistory(patient p,vaccine v){
        for (String s:p.getVaccineHistory()){
            if(s.equalsIgnoreCase(v.getName())){
                return false;
            }
        }
        return true;
    }

    public boolean checkDiseaseHistory(patient p, vaccine v){
        for(String s:p.getDiseases()){
            for(String s1:v.getVaccineDiseases()){
                if(s.equalsIgnoreCase(s1)){
                    return false;
                }
            }
        }
        return true;
    }
}
