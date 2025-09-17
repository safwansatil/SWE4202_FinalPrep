import java.io.*;

public class CheckedExampleHandle {
    
    // Option 2: Declare it with 'throws'
    public void readFile() throws FileNotFoundException {
        File file = new File("nonexistent.txt");
        FileReader fr = new FileReader(file); // Compiler ERROR if not handled!
    }

    // Option 1: Catch it with 'try-catch'
    public void readFileSafely() {
        try {
            File file = new File("nonexistent.txt");
            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("Oops! Couldn't find the file: " + e.getMessage());
            // Perform recovery actions here
        }
        System.out.println("Program continues running...");
    }
}
