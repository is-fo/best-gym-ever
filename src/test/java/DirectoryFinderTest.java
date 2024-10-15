import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectoryFinderTest {

    DirectoryFinder rootFinder = new DirectoryFinder();

    @Test
    void getRootDirectory() {
        String root = System.getProperty("user.dir");
        assertEquals(root, rootFinder.getRootDirectory());
    }

    @Test
    void getMainDirectory() {
        String main = rootFinder.getRootDirectory() + "\\src\\main\\java";
        assertEquals(main, rootFinder.getMainDirectory());
    }

    @Test
    void getOutputDirectory() {
        String output = rootFinder.getRootDirectory() + "\\output";
        assertEquals(output, rootFinder.getOutputDirectory());
    }

    @Test
    void getInputDirectory() {
        String input = rootFinder.getRootDirectory() + "\\input";
        assertEquals(input, rootFinder.getInputDirectory);
    }

}