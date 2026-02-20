import java.time.LocalDate;
import java.util.ArrayList;

public class patient {
    private String name;
    private LocalDate DOB;
    private int patientId;
    private String demographic;
    private ArrayList<String> chronic;
    private ArrayList<String> VaccineHistory;
    private ArrayList<String> diseases;
    private boolean pregnant;
    private boolean IMC;
    public patient(String name,int age,LocalDate DOB,String demographic,boolean pregnant,boolean IMC){
        if (check(name)) this.name=name;
        if (DOB!=null){
            this.DOB=DOB;
        }
        if (check(demographic)){
            this.demographic=demographic;
        }
        this.pregnant=pregnant;
        this.IMC=IMC;
        chronic=new ArrayList<>();
        VaccineHistory=new ArrayList<>();
        diseases=new ArrayList<>();
    }
    public void addChronic(String condition){
        if (check(condition)){
            chronic.add(condition);
        }
    }
    public void addDisease(String disease) {
        if (check(disease)) diseases.add(disease);
    }

    public void addRecord(vaccine v){
        VaccineHistory.add(v.getName());
    }

    public boolean check(String s){
        return s!=null&&!s.isEmpty();
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public String getName() {
        return name;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getDemographic() {
        return demographic;
    }

    public boolean isIMC() {
        return IMC;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public ArrayList<String> getVaccineHistory() {
        return VaccineHistory;
    }


    public ArrayList<String> getDiseases() {
        return diseases;
    }

}