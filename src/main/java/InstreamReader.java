import java.io.*;
import java.util.HashMap;

public class InstreamReader {

    private HashMap<Long, Person> membersMap;
    private String filePath;

    public InstreamReader(String fileName) {
        this.membersMap = new HashMap<>();
        this.filePath = new DirectoryFinder().getInputDirectory() + fileName;
    }

    public void readFileToMap() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
            InputParser parser = new InputParser();
            while (br.ready()) {
                String line = br.readLine();
                String dateLine = br.readLine();
                long id = parser.getLongID(line);

                Person person = parser.createPersonObject(line + " " + dateLine);
                membersMap.put(id, person);
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Kontrollera att formatet på personnumret. Exempel \"9911221234, Namn Namnson\".", e);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException("Kontrollera att filvägen och filnamnet överensstämmer med följande -> " + this.filePath, e);
        }
        catch (IOException e) {
            throw new RuntimeException("Något gick fel när filen skulle läsas.", e);
        }
        catch (Exception e) {
            throw new RuntimeException("Oväntat fel.", e);
        }

    }
    public MemberType determineMembership(String nameOrID) {
        Person p;
        try {
            long id = new InputParser().getLongID(nameOrID);
            p = getPersonByID(id);
        } catch (NumberFormatException e) {
            p = getPersonByName(nameOrID);
             if (p != null) {
                 return p.getMembership();
             }
        }

        return p != null ? p.getMembership() : MemberType.NOTAMEMBER;
    }

    public Person getPersonByID(long id) {
        return membersMap.getOrDefault(id, null);
    }

    public Person getPersonByID(String psn) {
        return membersMap.getOrDefault(new InputParser().getLongID(psn),null);
    }

    public Person getPersonByName(String name) {

        for (Person person : membersMap.values()) {
            if (person.getFullName().equals(name)) {
                return person;
            }
        }

        return null;
    }

    public HashMap<Long, Person> getMembersMap() {
        return membersMap;
    }
}
