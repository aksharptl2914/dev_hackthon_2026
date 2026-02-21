import java.util.ArrayList;

public class clinic {
    ArrayList<patient> patients;
    ArrayList<vaccine> vaccines;
    public clinic(){
        patients =new ArrayList<>();
        vaccines=new ArrayList<>();
    }
    public boolean addPatient(patient patient){
        for (patient p : patients) {
            if (p.getPatientId()==(patient.getPatientId())) {
                System.out.println("Patient already exists");
                return false;
            }
        }
        patients.add(patient);
        return true;
    }
    public void addVaccine(vaccine v) {
        vaccines.add(v);
    }

    public ArrayList<vaccine> getVaccines() {
        return vaccines;
    }
}
