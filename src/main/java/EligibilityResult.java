import java.time.LocalDate;

public class EligibilityResult {
    private vaccine vaccine;
    private String status;
    private LocalDate lastDose;
    private LocalDate dueDate;

    public EligibilityResult(vaccine vaccine, String status, LocalDate lastDose, LocalDate dueDate) {
        this.vaccine= vaccine;
        this.status = status;
        this.lastDose = lastDose;
        this.dueDate = dueDate;
    }

    public vaccine getVaccine() { return vaccine; }
    public String getStatus() { return status; }
    public LocalDate getLastDose() { return lastDose; }
    public LocalDate getDueDate() { return dueDate; }
}