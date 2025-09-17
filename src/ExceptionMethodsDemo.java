public class ExceptionMethodsDemo {
    
    public static void main(String[] args) {
        try {
            // Call a method that might cause an exception
            processNumber("not-a-number");
        } catch (NumberFormatException e) {
            System.out.println("=== Demonstrating Exception Methods ===\n");
            
            // 1. getMessage() - Provides information about the exception
            System.out.println("1. getMessage(): " + e.getMessage());
            System.out.println();
            
            // 2. getCause() - Provides the root cause of the exception
            System.out.println("2. getCause(): " + e.getCause());
            System.out.println("   (This is null because this exception wasn't caused by another exception)");
            System.out.println();
            
            // 3. printStackTrace() - Prints the exception with stack trace to System.err
            System.out.println("3. printStackTrace():");
            e.printStackTrace();
            System.out.println();
            
            // 4. getStackTrace() - Returns an array of stack trace elements
            System.out.println("4. getStackTrace():");
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (int i = 0; i < stackTrace.length; i++) {
                System.out.println("   [" + i + "] " + stackTrace[i]);
            }
            System.out.println();
            
            // Demonstrating an exception with a cause
            System.out.println("=== Demonstrating Exception with Cause ===");
            try {
                throwWithCause();
            } catch (RuntimeException ex) {
                System.out.println("Exception message: " + ex.getMessage());
                System.out.println("Exception cause: " + ex.getCause());
                System.out.println("Cause message: " + ex.getCause().getMessage());
            }
        }
    }
    
    // Method that processes a number string and might throw an exception
    public static void processNumber(String numberStr) {
        // This will throw NumberFormatException if the string is not a valid number
        int number = Integer.parseInt(numberStr);
        System.out.println("Processed number: " + number);
    }
    
    // Method that demonstrates an exception with a cause
    public static void throwWithCause() {
        try {
            // This will cause an ArithmeticException: division by zero
            int result = 10 / 0;
        } catch (ArithmeticException ae) {
            // Create a new exception with the ArithmeticException as the cause
            RuntimeException re = new RuntimeException("Calculation failed", ae);
            throw re;
        }
    }
}