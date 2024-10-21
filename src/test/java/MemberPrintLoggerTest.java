import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class MemberPrintLoggerTest {

    @Test
    void getUserInput() {
        InstreamReader in = new InstreamReader();
        in.readFileToMap("\\livingtestinput.txt");
        String outputFile = "\\testoutput.txt";
        String current = "Isak Folke";
        String current2 = "0101091234";
        String former = "Jocke Wiltman";
        String notAMember = "Jul Tomten";

        MemberPrintLogger p = new MemberPrintLogger();
        System.setIn(new ByteArrayInputStream(current.getBytes()));
        assertEquals("Isak Folke 0101091234" + MemberType.CURRENT, p.getUserInput(in.getMembersMap(), outputFile));
        System.setIn(new ByteArrayInputStream(current2.getBytes()));
        assertEquals("Isak Folke 0101091234" + MemberType.CURRENT, p.getUserInput(in.getMembersMap(), outputFile));
        System.setIn(new ByteArrayInputStream(former.getBytes()));
        assertEquals("Jocke Wiltman 9012241234" + MemberType.FORMER, p.getUserInput(in.getMembersMap(), outputFile));
        System.setIn(new ByteArrayInputStream(notAMember.getBytes()));
        assertEquals("Jul Tomten" + MemberType.NOTAMEMBER, p.getUserInput(in.getMembersMap(), outputFile));
    }
    @Test
    void createLogMessage() {
        MemberPrintLogger mpl = new MemberPrintLogger();
        Person p1 = new Person("0101091234", "Isak Folke", LocalDate.now());
        assertEquals(p1.getFullName()
                + " " + p1.getPersonNummer()
                + " " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + "\n",
                mpl.createLogMessage(p1));
    }

    @Test
    void parseName() {
        MemberPrintLogger p = new MemberPrintLogger();
        String p1 = "isak folke";
        String p2 = "0101091234";
        String p3 = "ISAK FOLKE";
        String p4 = "isak Folke";
        String p5 = "Isak folke";
        String expected = "Isak Folke";
        assertEquals(expected, p.parseName(p1));
        assertEquals(p2, p.parseName(p2));
        assertEquals(expected, p.parseName(p3));
        assertEquals(expected, p.parseName(p4));
        assertEquals(expected, p.parseName(p5));
    }

}