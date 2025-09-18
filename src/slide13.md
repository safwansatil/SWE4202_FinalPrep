# File in Java

### Pre: Streams
- A stream is a sequence of data that can be read from or written to.

Streams can be:
-    **Byte-Based Streams** (Raw Binary Data) : <br> It works with bytes. For reading/writing Binary Data. Like images, audio or files. 
    Example *FileInputStream*, *FileOutputStream* 
- **Character-Based Streams** (Text Data) : <br> Works with characters. (16 bit unicode). For reading/writing text files. 
    Example *FileReader*, *FileWriter*


The three standard streams in Java are:

- System.in - The standard input stream used for reading data (typically from the keyboard)

- System.out - The standard output stream used for writing normal data (typically to the console)

- System.err - The standard error stream used for writing error messages (typically to the console)


## Back to files
A file is a named location that can be used to store related information.
A directory is a collection of files and subdirectories.
<br>
- java.io package contains all the classes required for input and output operations, which is used here

### Creating a File
```java
// creates an object of File using the path 
File file = new File(String pathName);
```

- note : it does not create a physical file, just an object representing the file path. to create file we have to use createNewFile() method

- Operations : read(), delete(), write(), append(), etc

##### createNewFile() method
creates a new file, returns a true or false
```java
// importing the File class
import java.io.File;

class Main {
  public static void main(String[] args) {

    // create a file object for the current location
    File file = new File("newFile.txt");

    try {

      // trying to create a file based on the object
      boolean value = file.createNewFile();
      if (value) {
        System.out.println("The new file is created.");
      }
      else {
        System.out.println("The file already exists.");
      }
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  
```

- createNewFile() throws IOException, so we have to handle it using try-catch or throws keyword
- createNewFile() returns true if file is created, false if file already exists


### Reading a File
read() method returns an int value, which is the ASCII value of the character read. It returns -1 when end of file is reached.
When a character is successfully read, the method returns its char value cast to an int. This int will be in the range of 0 to 65535, corresponding to the Unicode value of the character.
```java
// importing the FileReader class
import java.io.FileReader;

class Main {
  public static void main(String[] args) {

    char[] array = new char[100];
    try {
      // Creates a reader using the FileReader
      FileReader input = new FileReader("input.txt");

      // Reads characters
      input.read(array);
      System.out.println("Data in the file:");
      System.out.println(array);

      // Closes the reader
      input.close();
    }
    catch(Exception e) {
      e.getStackTrace();
    }
  }
}
```


### Writing to a File
writer() of FileWriter is a method with void return type, meaning they complete their operation without explicitly returning a value. If an error occurs during the write operation, these methods will throw an IOException.
```java
// importing the FileWriter class
import java.io.FileWriter;

 class Main {
   public static void main(String args[]) {

     String data = "This is the data in the output file";
     try {
       // Creates a Writer using FileWriter
       FileWriter output = new FileWriter("output.txt"); // setting the second argument to true will append the data to the file instead of overwriting it

       // Writes string to the file
       output.write(data);
       System.out.println("Data is written to the file.");

       // Closes the writer
       output.close();
     }
     catch (Exception e) {
       e.getStackTrace();
     }
  }
}
```


### deleting file
delete() method of File class returns true if file is deleted, and false if file doesnt exist.
```java
import java.io.File;

class Main {
  public static void main(String[] args) {

    // creates a file object
    File file = new File("file.txt");

    // deletes the file
    boolean value = file.delete();
    if(value) {
      System.out.println("The File is deleted.");
    }
    else {
      System.out.println("The File does not exist.");
    }
  }
}
```

#### Some other useful methods of File class
- canRead() : tests whether the application can read the file, return type : boolean
- canWrite() : tests whether the application can modify the file, return type : boolean
- exists() : tests whether the file or directory exists, return type : boolean
- getName() : returns the name of the file or directory, return type : String
- getAbsolutePath() : returns the absolute pathname of the file or directory, return type : String
- length() : returns the length of the file in bytes, return type : long
- list() : returns an array of strings naming the files and directories in the directory represented by the File object, return type : String[]
- mkdir() : creates the directory named by the pathname, return type : boolean

