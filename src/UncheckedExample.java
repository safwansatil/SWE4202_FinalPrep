public class UncheckedExample {
    public static void main(String[] args) {
        
        // 1. NullPointerException
        String text = null;
        // int length = text.length(); // Throws NullPointerException (unchecked)

        // 2. ArrayIndexOutOfBoundsException
        int[] numbers = {1, 2, 3};
        // int value = numbers[5]; // Throws ArrayIndexOutOfBoundsException (unchecked)

        // 3. ArithmeticException
        int result = 5 / 0; // Throws ArithmeticException (unchecked)

        // You can still catch them if you want, but the compiler won't force you.
        try {
            int badMath = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("You can't divide by zero!");
        }
    }
}