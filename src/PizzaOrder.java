/*
 * ENUM code example
 */

enum PizzaSize {

    // Notice the syntax! This calls a constructor.
    SMALL(10, 8.99),    // Creates a PizzaSize instance with diameter=10, basePrice=8.99
    MEDIUM(12, 10.99),
    LARGE(14, 12.99),
    EXTRA_LARGE(18, 16.99);

    // 1. Fields (State)
    private final int diameterInInches; // 'final' is common, as enum values are constants
    private final double basePrice;

    // 2. Constructor (MUST be private)
    // You can't make new PizzaSize instances from outside; the only ones are SMALL, MEDIUM, etc.
    private PizzaSize(int diameter, double price) {
        this.diameterInInches = diameter;
        this.basePrice = price;
    }

    // 3. Methods (Behavior)
    public double getBasePrice() {
        return basePrice;
    }

    public int getDiameter() {
        return diameterInInches;
    }

    // You can define your own methods
    public void printDescription() {
        System.out.println("Size: " + this.name() + // Built-in method to get "SMALL", etc.
                          ", Diameter: " + diameterInInches +
                          "\", Price: $" + basePrice);
    }
}

// Using the powerful enum
public class PizzaOrder {
    public static void main(String[] args) {
        PizzaSize mySize = PizzaSize.MEDIUM;

        System.out.println("Price: " + mySize.getBasePrice()); // Output: Price: 10.99
        System.out.println("Diameter: " + mySize.getDiameter()); // Output: Diameter: 12

        mySize.printDescription();
        // Output: Size: MEDIUM, Diameter: 12", Price: $10.99
    }
}