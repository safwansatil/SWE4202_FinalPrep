# UML
UML or Unified Modeling Language.
UML Class diagram is a graphical notation used to contruct and visualize object-oriented systems.
It is a type of static structure diagram that describes the structure of a system by showing the system's classes, their attributes, operations (or methods), and the relationships among objects.

### UML Class Notations
- Class Name is the only mandatory part.
- In first partition, class name is written in PascalCase.
- In second partition, attributes (or properties) of the class are listed. Type of attributes are written after a colon. (fields)
- In third partition, methods (or operations) of the class are listed.
 // A class represents a concept which encapsulates state(attributes) and behaviors(methods/operations).
- return types of methods are termed as signatures.
- Visibility of attributes and methods are represented by symbols:
    - `+` Public
    - `-` Private
    - `#` Protected
    - `~` Package (default)
- Static attributes and methods are underlined.
- Abstract classes and methods are in italics.
- Parameter directionality:
    - `in` : input parameter, meaning the parameter can not be modified.
     In Code: The function uses the value you provide but cannot modify the original variable you passed in. This is the default and most common type of parameter.
    - `out` : output parameter, meaning the parameter is intended to be modified.
     In Code: The function ignores any initial value of the parameter. Its sole job is to assign a new value to it, which is then passed back to the caller.
    - `inout` : both input and output parameter, meaning the parameter can be modified and the modified value is returned. 
    In Code: The function can both read the original value and modify the original variable. It's a combination of in and out.
- Constructors are represented by the class name itself. with `<<create>>` stereotype.
- Interfaces are represented by the `<<interface>>` stereotype. Methods in interfaces are implicitly abstract and public


### Relationships between classes
- **Generalization** (Inheritance) : It is a relationship between a more general class (superclass) and a more specific class (subclass). It is represented by a solid line with a hollow arrowhead pointing from the subclass to the superclass. Each instance of the specific class is also an instance of the general class.
    - represents a *"is-a"* relationship.
- **Association** : It represnts a relationship between two classes where one class uses or interacts with another class. It is represented by a solid line connecting the two classes. The line may have multiplicity indicators at each end to show how many instances of one class can be associated with instances of the other class.
    - *Directional association* is where the association has a direction, indicating one class is associated with another class in a specific way.
    - *Unidirectional association* is where one class knows about the other, but not vice versa. Represented by an arrowhead on one end of the line.
    - *Bidirectional association* is where both classes know about each other. Represented by a simple line without arrowheads.
    - ##### Cardinality/Multiplicity
        - Slight fdifference between cardinality and multiplicity : 
            - Cardinality is the actual, specific number of things;
            - Multiplicity is the range of possible numbers of things
            - Multiplicity is type level while cardinality is instance level.
            - Cardinality is the count of instances in a particular relationship;
            - In UML we use, multiplicity to express cardinality.
            
            - UML :     [Owner] "1" ————— "1..*" [Car] , Meaning : An owner can have one to infinite cars, but a car can have one  owner only. (one-to many relationship) 
        - Specifies how many instances of one class can be associated with instances of another class.
        - expresseed in terms of : one to one, one to many, many to many.
        - Common multiplicity indicators:
            - `1` : Exactly one instance
            - `0..1` : Zero or one instance (optional)
            - `*` or `0..*` : Zero or more instances (many)
            - `1..*` : One or more instances
- **Aggregation** : A special type of association.
    - indicates a *"part-of"* relationship
    - aggregation is a specialized form of association that represents a "has-a" relationship between two classes. One class, known as the "whole" or container, contains an instance of another class, the "part," as an instance variable. The key characteristic of aggregation is that the part and the whole can exist *independently* of each other. 
- **Composition** : A stronger form of aggregation.
    - indicates a *"part-of"* relationship
    - In composition, the part cannot exist independently of the whole. If the whole is destroyed, the part is also destroyed. Composition is represented by a solid line with a filled diamond at the end connected to the whole class.
    - Example: A `House` class may have a composition relationship with a `Room` class. If the house is demolished, the rooms cease to exist as well.
- **Dependency** : A weaker relationship.
    - indicates that one class depends on another class for some functionality.
    - It is represented by a dashed line with an open arrowhead pointing from the dependent class to the class it depends on.
    - Example: A `Car` class may depend on an `Engine` class to function properly. If the `Engine` class changes, the `Car` class may need to be updated accordingly.
    - A dependency occurs when a class:
        1. Has a parameter of another class in one of its methods.
        2. Uses another class locally inside a method.
        3. Receives an object from another method call and uses it.
        4. Calls a static method on another class.
    - Simple Analogy: A `Person` uses a `Pen` to write a letter. The `Person` doesn't own the `Pen` permanently; they just use it temporarily for a task and then put it down.
    - *An object of one class might use an object of another class in the code of a method. If the object is not stored in any field, then this is modeled as a dependency relationship.*
- **Realizaation** (Implementation/Interface) : relationship between interface and implementing class.
    - ```java
            // Java Code Example
        public interface Drawable {
            void draw();
            void resize(int percent);
        }
        public class Circle implements Drawable {
            private int radius;
            
            @Override
            public void draw() {
                System.out.println("Drawing circle");
            }
            
            @Override
            public void resize(int percent) {
                radius = radius * percent / 100;
            }
        }
    
<br>

- **Diagram** : 
    Association	——————	"Uses" / "Knows about"	Person -- Car
    Inheritance	——————▷	"Is-A" (Specialization)	Vehicle --▷ Car
    Aggregation	◇——————	"Has-A" (Weak ownership, parts can live alone)	Department ◇-- Professor
    Composition	◆——————	"Is-Composed-Of" (Strong ownership, parts die with whole)	House ◆-- Room
    Dependency	------>	"Depends on"	Engine ------> Car


### UML for GUI (ECB)
- **`<<Entity>>`**: Represents a business object (e.g., `User`, `Product`).
- **`<<Control>>`**: Manages the flow of the application (e.g., `UserController`, `OrderProcessor`).
- **`<<Boundary>>`**: Interfaces between the system and external actors (e.g., `UserInterface`).

#### Restaurant Analogy:
- **Actor**: The `Customer` who initiates the interaction.
- **Entities**: The `Menu`, `Order`, and `Food` (the core data).
- **Control**: The `Waiter` who orchestrates the process.
- **Boundary**: The `GUI` or physical counter where the customer interacts.

---

- **`<<Entity>>`**
  - **Purpose**: Represents long-lived, persistent information or a key concept (e.g., saved to a database).
  - **What it is**: The core "nouns" of your system like `User`, `Product`, `Order`. They are independent of the UI.

- **`<<Boundary>>`**
  - **Purpose**: The "edge" of your system that an actor interacts with.
  - **What it is**: GUI screens (`LoginWindow`), API endpoints (`/api/users`), or any interface communicating with the outside.

- **`<<Control>>`**
  - **Purpose**: Orchestrates the interaction between boundary and entity classes for a specific use case. It contains the business logic.
  - **What it is**: The "verbs" or managers like `LoginController` or `OrderManager`. It decouples entities from boundaries.

---

#### Example: Library System Login
1.  **Actor & Boundary**: A `Librarian` (Actor) interacts with the `LoginScreen` (`<<Boundary>>`), entering their credentials.
2.  **Boundary to Control**: The `LoginScreen` passes the username and password to a `LoginManager` (`<<Control>>`).
3.  **Control & Entity**: The `LoginManager` uses the `User` (`<<Entity>>`) to load data from the database and compares the stored password with the provided one.
4.  **Control to Boundary**: The `LoginManager` returns the result ("Success" or "Fail") back to the `LoginScreen`.
5.  **Boundary Updates**: The `LoginScreen` updates the GUI, showing either an error message or the main application window.

