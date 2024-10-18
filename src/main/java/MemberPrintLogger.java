import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

public class MemberPrintLogger {

    public String getUserInput(HashMap<Long, Person> membersMap, String outputFile) {
        InstreamReader in = new InstreamReader();
        in.setMembersMap(membersMap);
        String nameOrID;
        Person person;

        try {
            Scanner scanner = new Scanner(System.in);
            nameOrID = scanner.nextLine();
            nameOrID = parseName(nameOrID);
            person = in.getPersonByNameOrID(nameOrID);
            if (person != null && person.getMembership() == MemberType.CURRENT) {
                logWorkOut(person, outputFile);
            }
        } catch (Exception e) {
            System.out.println("Skriv ett namn eller personnummer med formatet \"namn efternamn\" eller \"yymmddxxxx\"");
            return "";
        }

        return person != null ? person.printDetails() : nameOrID + MemberType.NOTAMEMBER;
    }

    public void logWorkOut(Person person, String outputFile) {
        try (FileWriter writer = new FileWriter(new DirectoryFinder().getOutputDirectory() + outputFile, true)) {
            writer.append(person.getFullName())
                    .append(" ")
                    .append(person.getPersonNummer())
                    .append(" ")
                    .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                    .append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String parseName(String name) {
        if (Character.isDigit(name.charAt(0))) {
            return name;
        }
        String[] split = name.split(" ");

        String firstName = split[0].substring(0, 1).toUpperCase() + split[0].substring(1).toLowerCase();
        String lastName = split[1].substring(0, 1).toUpperCase() + split[1].substring(1).toLowerCase();

        return firstName + " " + lastName;
    }

}
