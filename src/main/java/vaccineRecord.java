import java.time.LocalDate;

public class vaccineRecord {
    private int vaccineId;
    private LocalDate dateReceived;

    public vaccineRecord(int vaccineId, LocalDate dateReceived) {
        this.vaccineId = vaccineId;
        this.dateReceived = dateReceived;
    }

    public int getVaccineId() { return vaccineId; }
    public LocalDate getDateReceived() { return dateReceived; }
}