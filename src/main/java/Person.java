public class Person {

    private final String personNummer;
    private final NameDate nameDate;
    private final Long pID;

    public Person(String personNummer, NameDate nameDate) {
        this.personNummer = personNummer;
        this.nameDate = nameDate;
        this.pID = new InstreamParser().getLongID(personNummer);
    }

    public String getPersonNummer() {
        return personNummer;
    }

    public NameDate getNameDate() {
        return nameDate;
    }

    @Override
    public String toString() {
        return personNummer + " " + nameDate;
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
