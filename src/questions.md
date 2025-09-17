Why can't enum have public constructors?
- because you cant make instances from outside, (using new) and go outside of the fixed set of constants.
Enum can be declared inside or outside a class, but not inside a method.
What is an anonymous inner class?
- a local inner class that is declared and instantiated in a single step, without a name.

# Commonly Overlooked Questions

### Enums
1.  Can an enum have a constructor? If so, what is its access modifier?
2.  Why is it generally a bad idea to rely on an enum's `ordinal()` value in your application logic?
3.  Can you use `extends` with an enum? Why or why not?

### Exceptions
4.  Under what circumstances will a `finally` block *not* be executed?
5.  What happens if you catch a superclass exception (e.g., `Exception`) before a subclass exception (e.g., `IOException`) in your `catch` blocks?
- wont compile, java doesntr allow
6.  What is the difference between `NoClassDefFoundError` and `ClassNotFoundException`?
- ans: 
    - `ClassNotFoundException` is a checked exception that occurs when an application tries to load a class at runtime using methods like `Class.forName()` or `ClassLoader.loadClass()`, and the class cannot be found in the classpath. It indicates that the class definition is missing or not accessible.
    - `NoClassDefFoundError` is an unchecked error that occurs when the Java Virtual Machine (JVM) or a class loader tries to load a class, but the class definition is not found at runtime. This can happen if the class was present during compilation but is missing at runtime, often due to issues like missing JAR files or incorrect classpaths. It indicates a serious problem that prevents the application from running correctly.

### UML
7.  What is the key difference in object lifecycle between Aggregation and Composition? How is this shown visually?
8.  Can a class have both an association and a dependency with another class? Give an example.
9.  In the ECB pattern, which component should contain the business rules, and which should be responsible for displaying data to the user?

### GUI (Swing)

10. What is the difference between `JFrame`, `JPanel`, and `JDialog`? When would you use each?
- ans: 
    - `JFrame`: A top-level window with a title and a border that can hold other components. It is used for the main application window.
    - `JPanel`: A generic lightweight container that can hold a group of components. It is used for organizing components within a window.
    - `JDialog`: A top-level window used for taking input or displaying messages. It is typically modal, meaning it blocks input to other windows until closed.