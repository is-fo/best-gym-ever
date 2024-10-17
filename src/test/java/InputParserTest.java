import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    InputParser inputParser = new InputParser();

    @Test
    void createPersonObject() {
        Person expected = new Person("0101091234", "Isak Folke", LocalDate.now());

        Person actual = inputParser.createPersonObject(expected.toString());

        assertEquals(expected.getPersonNummer(), actual.getPersonNummer());
        assertEquals(expected.getFullName(), actual.getFullName());
        assertEquals(expected.getMembershipDate(), actual.getMembershipDate());
    }

    @Test
    void getLongID() {
        assertEquals(101091234L, inputParser.getLongID("0101091234"));
        assertEquals(9911309999L, inputParser.getLongID("9911309999"));
        assertEquals(1019999L, inputParser.getLongID("0001019999,"));
        assertEquals(9912319999L, inputParser.getLongID("9912319999,"));
    }
}