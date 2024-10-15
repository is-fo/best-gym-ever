import java.util.Objects;

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
        return personNummer + " " + nameDate.toString();
    }
}
