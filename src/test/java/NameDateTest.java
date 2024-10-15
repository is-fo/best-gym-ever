import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class NameDateTest {

    NameDate nameDate = new NameDate("Isak Folke", LocalDate.now());

    @Test
    void toStringTest() {
        assertEquals("Isak Folke" + " " + LocalDate.now(), nameDate.toString());
    }

    @Test
    void getName() {
        assertEquals("Isak Folke", nameDate.getFullName());
    }

    @Test
    void getDate() {
        assertEquals(LocalDate.now(), nameDate.getTodaysDate());
    }

}