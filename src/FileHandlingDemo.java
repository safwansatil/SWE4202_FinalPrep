import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandlingDemo {

    public static void main(String[] args) {
        // 1. Creating a File object
        System.out.println("=== 1. Creating File Objects ===");
        File file = new File("example.txt");
        System.out.println("File object created for: " + file.getAbsolutePath());
        System.out.println("File exists: " + file.exists());
        System.out.println();

        // 2. Creating a new file
        System.out.println("=== 2. Creating a New File ===");
        try {
            boolean isCreated = file.createNewFile();
            if (isCreated) {
                System.out.println("File created successfully: " + file.getName());
            } else {
                System.out.println("File already exists: " + file.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
        System.out.println();

        // 3. Writing to a file
        System.out.println("=== 3. Writing to a File ===");
        try (FileWriter writer = new FileWriter(file)) {
            String content = "Hello, this is a sample text.\nJava File Handling is important!\n";
            writer.write(content);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
        System.out.println();

        // 4. Reading from a file using FileReader
        System.out.println("=== 4. Reading from a File (FileReader) ===");
        try (FileReader reader = new FileReader(file)) {
            int character;
            System.out.print("File content: ");
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        System.out.println();

        // 5. Reading from a file using Scanner (another approach)
        System.out.println("=== 5. Reading from a File (Scanner) ===");
        try (Scanner scanner = new Scanner(file)) {
            System.out.println("File content (line by line):");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        System.out.println();

        // 6. Getting file information
        System.out.println("=== 6. File Information ===");
        System.out.println("File name: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Writable: " + file.canWrite());
        System.out.println("Readable: " + file.canRead());
        System.out.println("File size in bytes: " + file.length());
        System.out.println();

        // 7. Appending to a file
        System.out.println("=== 7. Appending to a File ===");
        try (FileWriter writer = new FileWriter(file, true)) { // true enables append mode
            String appendContent = "\nThis text was appended to the file!";
            writer.write(appendContent);
            System.out.println("Successfully appended to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while appending to the file.");
            e.printStackTrace();
        }
        System.out.println();

        // 8. Display the updated content
        System.out.println("=== 8. Updated File Content ===");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        System.out.println();

        // 9. Deleting a file
        System.out.println("=== 9. Deleting a File ===");
        boolean isDeleted = file.delete();
        if (isDeleted) {
            System.out.println("File deleted successfully: " + file.getName());
        } else {
            System.out.println("Failed to delete the file: " + file.getName());
        }
        System.out.println();

        // 10. Working with directories
        System.out.println("=== 10. Working with Directories ===");
        File directory = new File("myFolder");
        boolean dirCreated = directory.mkdir(); // Create a directory
        if (dirCreated) {
            System.out.println("Directory created: " + directory.getName());
            
            // Create a file inside the directory
            File fileInDir = new File(directory, "fileInFolder.txt");
            try {
                fileInDir.createNewFile();
                System.out.println("File created inside directory: " + fileInDir.getName());
                
                // List files in the directory
                System.out.println("Files in " + directory.getName() + ":");
                String[] files = directory.list();
                if (files != null) {
                    for (String f : files) {
                        System.out.println(" - " + f);
                    }
                }
                
                // Clean up
                fileInDir.delete();
                directory.delete();
                System.out.println("Temporary directory and file deleted.");
            } catch (IOException e) {
                System.out.println("Error creating file in directory.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Directory already exists or couldn't be created.");
        }
    }
}