### Exceptions
Exceptions are **unwanted bugs or events** that occur during the execution of a program. They can be caused by various factors, such as invalid input, resource unavailability, or logical errors in the code.
    For example, IOException, ArithmeticException, NullPointerException, ClassNotFoundException, etc.

NullPointerException occurs when a program **attempts to use an object reference that has not been initialized** (i.e., it points to null). In Java, NullPointerException is a common runtime exception that indicates this specific error.


- In Java, when an exception is thrown, it propagates up the call stack until it is caught by a catch block.
If it is not caught by any catch block, it will be handled by the default uncaught exception handler of the thread, which typically prints the stack trace and terminates the thread.

- For the main thread, if an uncaught exception occurs and is not handled, the program (JVM) will terminate.

- However, if the exception is caught and handled, the program can continue running.

### Errors
Error can be defined as an **abnormal condition that indicates something has gone wrong during the execution of the program.** These are not handled by java programs and are typically caused by external factors such as hardware failures, memory issues, or system crashes.
    For example, *OutOfMemoryError, StackOverflowError, VirtualMachineError, NoClassDefFoundError, etc.*
Errors are impossible to recover from, and they usually indicate a serious problem that requires immediate attention.


### Stack Trace
A Stack Trace provides the names of classes and methods that were called in the program at the point where an exception occurred.
 It is a valuable tool for debugging and understanding the flow of execution leading up to the exception. It enables us to determine where the exception was thrown in the application and the original cause that led to it.


### Exception Types
There are mainly 2 types of exceptions : Checked and Unchecked

**Checked** or Compile time exceptions: These exceptions are checked by the compiler during compilation to confirm whether the exception is handled by the program or not. If not handled, the compiler throws a compilation error.
    For example, IOException, SQLException, ClassNotFoundException, etc.
Compiler Enforcement: The compiler will force you to handle them. You have two options:
<ol>
    <li>Catch the exception using a try-catch block.</li>
    <li>Declare that your method might throw it using the throws clause in the method signature. This passes the responsibility to the caller of your method.</li>
</ol>

*They are subclass of **Exception class** except RuntimeException class.*

**Unchecked** or Runtime exceptions : Exceptions that occur during the execution of the program, where the compiler does not validate at the time of compilation. They typically result from logical error or bug in code.
    For example, NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException, IllegalAgumentException, NumberFormatException,etc.

*They are either subclass of **RuntimeException class** or **Error class**.*


### try-catch-finally
The try-catch-finally block is used to handle exceptions in Java. The code that might throw an exception is placed inside the try block. If an exception occurs, it is caught by the catch block, where you can handle it appropriately. The finally block is optional and contains code that will always execute, regardless of whether an exception occurred or not. It is typically used for cleanup operations, such as closing resources like files or database connections.
catch block can be used after a try block only. Multiple catch blocks can be used with a singly try
Catch blocks are written generally from most specific to most general exception type.
there can be try-finally block without catch block but not vice-versa.


### throw vs throws
- **throw** is used to explicitly throw an exception from a method or a block of code. It is followed by an instance of the exception class. It is used within the method body.
- **throws** is used in the method signature to declare that a method might throw one or more exceptions. It is followed by a list of exception classes. It is used to inform the caller of the method about the potential exceptions that may be thrown. thropws provide a runtime error.


### Advantage of Exception Handling
<ol>
    <li>Maintains Normal Flow of Application</li>
    <li>Seperation of error-handling code from regular code : "what we want to do" vs "what we need to do when things go wrong"</li>
    <li>Grouping and differentiating error types: different exceptions can be handled differently</li>
    <li>Propagation of Errors</li>
</ol>

<br>

#### Exception Methods
- getMessage(): Returns a detailed message about the exception that can be useful for debugging.
- getCause(): provides the root cause of the exception, if available.
- printStackTrace(): prints the stack trace of the exception to the standard error stream, which helps in identifying where the exception occurred in the code.
- getStackTrace(): returns an array of StackTraceElement objects representing the stack trace of the exception, which can be programmatically analyzed.