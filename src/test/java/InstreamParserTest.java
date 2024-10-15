import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class InstreamParserTest {

    InstreamParser instreamParser = new InstreamParser();

    @Test
    void createPersonObject() {
        Person expected = new Person("0101090058", new NameDate("Isak Folke", LocalDate.now()));

        Person actual = instreamParser.createPersonObject(expected.toString());

        assertEquals(expected.getPersonNummer(), actual.getPersonNummer());
        assertEquals(expected.getNameDate().toString(), actual.getNameDate().toString());
    }
}