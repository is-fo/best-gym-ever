import java.time.LocalDate;
import java.util.Scanner;

public class InputParser {

    public Person createPersonObject(String input) {
        input = input.replace(',', ' ');
        Scanner scanner = new Scanner(input);
        String personNummer = scanner.next();
        String fullName = scanner.next() + " " + scanner.next();
        LocalDate membershipDate = LocalDate.parse(scanner.next());

        return new Person(personNummer, fullName, membershipDate);
    }

    public long getLongID(String input) throws NumberFormatException {
        int commaIndex = input.contains(",") ? input.indexOf(",") : input.length();
        return Long.parseLong(input.substring(0, commaIndex));
    }
}
