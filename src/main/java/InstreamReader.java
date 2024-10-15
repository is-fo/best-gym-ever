import java.io.*;
import java.util.HashMap;

public class InstreamReader {

    private HashMap<Long, Person> membersMap;
    private String filePath;

    public InstreamReader(String fileName) {
        this.membersMap = new HashMap<>();
        this.filePath = new DirectoryFinder().getInputDirectory() + fileName;
    }

    public HashMap<Long, Person> readFileToMap() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
            while (br.ready()) {
                String line = br.readLine();
                String dateLine = br.readLine();
                InstreamParser parser = new InstreamParser();
                long id = parser.getLongID(line);
                Person person = parser.createPersonObject(line + " " + dateLine);
                membersMap.put(id, person);
                System.out.println(membersMap.get(id));
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

        return membersMap;
    }

    public Person getPersonByID(long id, HashMap<Long, Person> membersMap) {
        return membersMap.getOrDefault(id, null);
    }
}
