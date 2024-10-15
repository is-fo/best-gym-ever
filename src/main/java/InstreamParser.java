import java.time.LocalDate;
import java.util.Scanner;

public class InstreamParser {

    public Person createPersonObject(String input) {
        Scanner scanner = new Scanner(input);
        String personNummer = scanner.next();
        String fullName = scanner.next() + " " + scanner.next();
        LocalDate membershipDate = LocalDate.parse(scanner.next());

        return new Person(personNummer, new NameDate(fullName, membershipDate));
    }

    public long getLongID(String input) throws NumberFormatException {
        return Long.parseLong(input.substring(input.indexOf(',') + 1));
    }
}
