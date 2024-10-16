public class Person {

    private String personNummer;
    private NameDate nameDate;

    public Person(String personNummer, NameDate nameDate) {
        this.personNummer = personNummer;
        this.nameDate = nameDate;
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
        return personNummer.equals(((Person) o).personNummer);
    }

    @Override
    public int hashCode() {
        return personNummer.hashCode();
    }
}
