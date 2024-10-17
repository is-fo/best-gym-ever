import java.time.LocalDate;

public class Person {

    private final String personNummer;
    private final Long pID;
    private final String fullName;
    private final LocalDate membershipDate;
    private MemberType membership;


    public Person(String personNummer, String fullName, LocalDate membershipDate) {
        this.personNummer = personNummer;
        this.fullName = fullName;
        this.membershipDate = membershipDate;
        this.pID = new InputParser().getLongID(personNummer);
        this.membership = calculateMembership();
    }

    public MemberType calculateMembership() {
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        if (membershipDate.isBefore(oneYearAgo)) {
            return MemberType.FORMER;
        } else if (membershipDate.isAfter(oneYearAgo)) {
            return MemberType.CURRENT;
        } else {
            return MemberType.NOTAMEMBER;
        }
    }

    public MemberType getMembership() {
        return membership;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    public String getPersonNummer() {
        return personNummer;
    }

    @Override
    public String toString() {
        return personNummer + " " + fullName + " " + membershipDate.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        return pID.equals(((Person) o).pID);
    }

    @Override
    public int hashCode() {
        return pID.hashCode();
    }
}
