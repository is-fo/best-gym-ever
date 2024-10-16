import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person person = new Person("0101091234", new NameDate("Isak Folke", LocalDate.parse("2024-10-15")));

    @Test
    void toStringTest() {
        assertEquals("0101091234 Isak Folke 2024-10-15", person.toString());
    }

    @Test
    void getPersonNummer() {
        assertEquals("0101091234", person.getPersonNummer());
    }
}