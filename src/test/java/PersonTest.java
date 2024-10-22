import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {


    @Test
    void calculateMembership() {
        Person person = new Person("0101091234", "Isak Folke", LocalDate. now());

        assertEquals(MemberType.CURRENT, person.calculateMembership());
        assertEquals(MemberType.FORMER, new Person("0101091234", "Isak Folke", LocalDate. now().minusYears(1)).calculateMembership());
        assertEquals(MemberType.FORMER, new Person("0101091234",
                "Isak Folke", LocalDate. now().minusYears(1).minusDays(1)).calculateMembership());
    }

    @Test
    void toStringTest() {
        Person person = new Person("0101091234", "Isak Folke", LocalDate.parse("2024-10-15"));
        assertEquals("0101091234 Isak Folke 2024-10-15", person.toString());
    }

    @Test
    void getPersonNummer() {
        Person person = new Person("0101091234", "Isak Folke", LocalDate. now());

        assertEquals("0101091234", person.getPersonNummer());
    }
    @Test
    void getName() {
        Person person = new Person("0101091234", "Isak Folke", LocalDate. now());

        assertEquals("Isak Folke", person.getFullName());
    }

    @Test
    void getDate() {
        Person person = new Person("0101091234", "Isak Folke", LocalDate.parse("2024-10-15"));

        assertEquals(LocalDate.parse("2024-10-15"), person.getMembershipDate());
        assertEquals(LocalDate.parse("2024-08-15"),  new Person("0101091234", "Isak Folke", LocalDate.parse("2024-08-15")).getMembershipDate());
    }
}