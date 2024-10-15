import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class InstreamReaderTest {

    InstreamReader instreamReader = new InstreamReader("\\testInput.txt");
    HashMap<Long, Person> personMap = new HashMap<>();
    Person isak = new Person("0101090058", new NameDate("Isak Folke", LocalDate.now()));

    @Test
    void readFileToMap() {

    }

    @Test
    void getPersonByID() {
        personMap.put(Long.parseLong(isak.getPersonNummer()), isak);

        assertEquals(isak, instreamReader.getPersonByID(
                Long.parseLong(isak.getPersonNummer()),
                personMap));
    }

}