import java.io.*;
import java.util.HashMap;

public class InstreamReader {

    private HashMap<Long, Person> membersMap;
    private String filePath;

    public InstreamReader() {
        this.membersMap = new HashMap<>(40);
    }

    public void readFileToMap(String fileName) {
        this.filePath = new DirectoryFinder().getInputDirectory() + fileName;
        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
            InputParser parser = new InputParser();
            while (br.ready()) {
                String line = br.readLine();
                long id = parser.getLongID(line);

                String dateLine = br.readLine();
                Person person = parser.createPersonObject(line + " " + dateLine);
                membersMap.put(id, person);
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Kontrollera formatet på personnumret. Exempel \"9911221234, Namn Namnson\".", e);
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
        Person p = getPersonByNameOrID(nameOrID);

        return p != null ? p.getMembership() : MemberType.NOTAMEMBER;
    }

    public Person getPersonByID(long id) {
        return membersMap.getOrDefault(id, null);
    }

    public Person getPersonByID(String psn) {
        return getPersonByID(new InputParser().getLongID(psn));
    }

    public Person getPersonByName(String name) {

        for (Person person : membersMap.values()) {
            if (person.getFullName().equals(name)) {
                return person;
            }
        }

        return null;
    }

    public Person getPersonByNameOrID(String nameOrID) {
        try {
            return getPersonByID(new InputParser().getLongID(nameOrID));
        } catch (NumberFormatException e) {
            return getPersonByName(nameOrID);
        }
    }

    public HashMap<Long, Person> getMembersMap() {
        return membersMap;
    }

    public void setMembersMap(HashMap<Long, Person> membersMap) {
        this.membersMap = membersMap;
    }
}
