## Enums
Short for 'enumerations' meaning 'specifically listed'.
An enum is a special class that represents a group of constants (unchanging variables, like final variables).

Every enum constant is implicitly public, static, and final. Since it is final, we cant create enum child classes.

### Enums vs Switch case
- Switch has no type safety, like what if u passed 999 or a string with limited options case
- Meaningless values, enums provide meaningful names for sets of values, increasing code readability and maintainability.
- Enums can have fields, methods, and constructors, allowing for more complex behavior and data association with each constant.
- Dangerous refactoring, like what if u change the order of the cases, it will change the logic of the switch case. Enums are safer in this regard since they are referenced by name.
- Compiler benefits, like what if u misspell a case, the compiler won't catch it. Enums provide compile-time checking, reducing runtime errors.


### Loop through enums :
```java
for (Day day : Day.values()) {
    System.out.println(day.name() + " has ordinal value: " + day.ordinal());
}
```

### Enum and Methods
```java
public enum Operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE;
    
    // Concrete method
    public double apply(double x, double y) {
        switch (this) {
            case ADD: return x + y;
            case SUBTRACT: return x - y;
            case MULTIPLY: return x * y;
            case DIVIDE: return x / y;
            default: throw new AssertionError("Unknown operation: " + this);
        }
    }
}
```
Abstract methods in enums
```java
public enum Operation {
    ADD {
        public double apply(double x, double y) { return x + y; }
    },
    SUBTRACT {
        public double apply(double x, double y) { return x - y; }
    },
    MULTIPLY {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE {
        public double apply(double x, double y) { return x / y; }
    };
    
    // Each enum constant must implement this abstract method
    public abstract double apply(double x, double y);
}
```
