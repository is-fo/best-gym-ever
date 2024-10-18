public class Main {
    public static void main(String[] args) {
        InstreamReader instreamReader = new InstreamReader();
        instreamReader.readFileToMap("\\data.txt");

        MemberPrintLogger memberPrintLogger = new MemberPrintLogger();
        System.out.println("Skriv ett namn eller personnummer");
        while (true) {
            String nameOrID = memberPrintLogger.getUserInput(instreamReader.getMembersMap(), "\\workoutlogs");
            System.out.println(nameOrID);
        }
    }
}
