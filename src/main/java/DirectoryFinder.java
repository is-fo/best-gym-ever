public class DirectoryFinder {

    private String rootDirectory = System.getProperty("user.dir");


    public String getRootDirectory() {
        return rootDirectory;
    }

    public String getMainDirectory() {
        return this.rootDirectory + "\\src\\main\\java";
    }

    public String getOutputDirectory() {
        return this.rootDirectory + "\\output";
    }

    public String getInputDirectory() {
        return this.rootDirectory + "\\input";
    }
}
