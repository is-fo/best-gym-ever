import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstreamReaderTest {

    InstreamReader instreamReader = new InstreamReader();
    String fileName = "\\testInput.txt";


    @Test
    void readFileToMap() {
        //TODO: fixa ett test som fungerar
        instreamReader.readFileToMap(fileName);
        /*
        {Long@2110} 101091234 -> {Person@2104} "0101091234 Isak Folke 2024-10-15"
        {Long@2138} 101091235 -> {Person@2131} "0101091235 Isak Ingemund 2024-08-03"
        {Long@2139} 9012241234 -> {Person@2119} "9012241234 Jocke Wiltman 2023-10-14"
        {Long@2140} 9702251234 -> {Person@2125} "9702251234 Jesper Ekstedt 2023-10-15"
         */
    }
    @Test
    void determineMembership() {
        String livingTestFileName = "\\livingtestinput.txt";
        writeLivingTestInput(livingTestFileName); //skriver en egen testfil med uppdaterade medlemsdatum
        InstreamReader i = new InstreamReader();
        i.readFileToMap(livingTestFileName);

        assertEquals(MemberType.CURRENT, i.determineMembership("Isak Folke"));
        assertEquals(MemberType.CURRENT, i.determineMembership("0101091234"));
        assertEquals(MemberType.FORMER, i.determineMembership("Jocke Wiltman"));
        assertEquals(MemberType.FORMER, i.determineMembership("9012241234"));
        assertEquals(MemberType.FORMER, i.determineMembership("Jesper Ekstedt"));
        assertEquals(MemberType.FORMER, i.determineMembership("9702251234"));
        assertEquals(MemberType.NOTAMEMBER, i.determineMembership("Ogiltig Medlem"));
        assertEquals(MemberType.NOTAMEMBER, i.determineMembership("7112311234"));
    }



    @Test
    void getPersonByID() {
        instreamReader.readFileToMap(fileName);

        assertEquals(instreamReader.getMembersMap().get(101090058L), instreamReader.getMembersMap().get(instreamReader.getPersonByID("0101090058")));
        assertEquals(instreamReader.getMembersMap().get(101090058L), instreamReader.getMembersMap().get(instreamReader.getPersonByID(101090058L)));
        assertNull(instreamReader.getMembersMap().getOrDefault(instreamReader.getPersonByID("9901080058"), null));
        assertNull(instreamReader.getMembersMap().getOrDefault(instreamReader.getPersonByID(1312131213L), null));
    }

    @Test
    void getPersonByName() {
        instreamReader.readFileToMap(fileName);
        assertEquals(new Person("0101091234", "Isak Folke", LocalDate.parse("2024-10-15")), instreamReader.getPersonByName("Isak Folke"));
    }

    @Test
    void getMembersMap() {
        instreamReader.readFileToMap(fileName);
        assertEquals(4, instreamReader.getMembersMap().size());
    }

    private static void writeLivingTestInput(String testFile) {
        List<String> data = new ArrayList<>();
        data.add("0101091234, Isak Folke");
        data.add("9012241234, Jocke Wiltman");
        data.add("9702251234, Jesper Ekstedt");

        try (FileWriter writer = new FileWriter(new DirectoryFinder().getInputDirectory() + testFile)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate today = LocalDate.now();
            LocalDate oneYearAgo = today.minusYears(1).minusDays(1);
            LocalDate exactlyOneYearAgo = today.minusYears(1);

            String[] firstPerson = data.get(0).split(",");
            writer.write(firstPerson[0] + "," + firstPerson[1] + "\n" + today.format(formatter) + "\n");

            String[] secondPerson = data.get(1).split(",");
            writer.write(secondPerson[0] + "," + secondPerson[1] + "\n" + oneYearAgo.format(formatter) + "\n");

            String[] thirdPerson = data.get(2).split(",");
            writer.write(thirdPerson[0] + "," + thirdPerson[1] + "\n" + exactlyOneYearAgo.format(formatter) + "\n");

        } catch (IOException e) {
            System.err.println("Error writing to " + testFile + e.getMessage());
        }
    }

}