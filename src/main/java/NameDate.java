import java.time.LocalDate;

public class NameDate {

    private String fullName;
    private LocalDate todaysDate;

    public NameDate(String fullName, LocalDate todaysDate) {
        this.fullName = fullName;
        this.todaysDate = todaysDate;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getTodaysDate() {
        return todaysDate;
    }

    @Override
    public String toString() {
        return fullName + " " + todaysDate.toString();
    }
}
