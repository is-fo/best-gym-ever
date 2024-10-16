import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class InstreamParserTest {

    InstreamParser instreamParser = new InstreamParser();

    @Test
    void createPersonObject() {
        Person expected = new Person("0101091234", new NameDate("Isak Folke", LocalDate.now()));

        Person actual = instreamParser.createPersonObject(expected.toString());

        assertEquals(expected.getPersonNummer(), actual.getPersonNummer());
        assertEquals(expected.getNameDate().toString(), actual.getNameDate().toString());
    }

    @Test
    void getLongID() {
        assertEquals(101091234L, instreamParser.getLongID("0101091234"));
        assertEquals(9911309999L, instreamParser.getLongID("9911309999"));
        assertEquals(1019999L, instreamParser.getLongID("0001019999,"));
        assertEquals(9912319999L, instreamParser.getLongID("9912319999,"));
    }
}