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

    public void identifyOverdue(){


    }

    public void sendReminders(){


    }

    public void displayTimeline(){

    }
}
