import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class InstreamReaderTest {

    InstreamReader instreamReader = new InstreamReader("\\testInput.txt");
    Person isak = new Person("0101090058", new NameDate("Isak Folke", LocalDate.now()));

    @Test
    void readFileToMap() {
        //TODO: fixa ett test som fungerar
        instreamReader.readFileToMap();
        /*
        {Long@2110} 101091234 -> {Person@2104} "0101091234 Isak Folke 2024-10-15"
        {Long@2138} 101091235 -> {Person@2131} "0101091235 Isak Ingemund 2024-08-03"
        {Long@2139} 9012241234 -> {Person@2119} "9012241234 Jocke Wiltman 2023-10-14"
        {Long@2140} 9702251234 -> {Person@2125} "9702251234 Jesper Ekstedt 2023-10-15"
         */
    }

    @Test
    void getPersonByID() {
        HashMap<Long, Person> personMap = new HashMap<>();
        personMap.put(Long.parseLong(isak.getPersonNummer()), isak);

        assertEquals(isak, instreamReader.getPersonByID(
                Long.parseLong(isak.getPersonNummer()),
                personMap));
    }

}