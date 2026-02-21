import java.time.LocalDate;
import java.util.ArrayList;

public class patient {
    private String name;
    private LocalDate DOB;
    private int patientId;
    private String demographic;
    private ArrayList<vaccineRecord> VaccineHistory;
    private ArrayList<String> diseases;
    private boolean pregnant;
    private boolean IMC;
    public patient(int patientId,String name,LocalDate DOB,String demographic,boolean pregnant,boolean IMC){
        if (check(name)) this.name=name;
        if (DOB!=null){
            this.DOB=DOB;
        }
        if (check(demographic)){
            this.demographic=demographic;
        }
        this.patientId=patientId;
        this.pregnant=pregnant;
        this.IMC=IMC;
        VaccineHistory = new ArrayList<>();
        diseases=new ArrayList<>();
    }


    public void addRecord(int vaccineId, LocalDate dateReceived){

        VaccineHistory.add(new vaccineRecord(vaccineId,dateReceived));
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

    public ArrayList<vaccineRecord> getVaccineHistory() {
        return VaccineHistory;
    }

    public void addDisease(String s){
        diseases.add(s);
    }


    public ArrayList<String> getDiseases() {
        return diseases;
    }

}