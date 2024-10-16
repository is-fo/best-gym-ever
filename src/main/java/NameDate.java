import java.time.LocalDate;

public class NameDate {

    private String fullName;
    private LocalDate membershipDate;

    public NameDate(String fullName, LocalDate membershipDate) {
        this.fullName = fullName;
        this.membershipDate = membershipDate;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    @Override
    public String toString() {
        return fullName + " " + membershipDate.toString();
    }
}
