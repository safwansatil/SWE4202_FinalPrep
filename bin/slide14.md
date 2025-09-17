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
    - `in` : input parameter, meaning the parameter can not be modified. In Code: The function uses the value you provide but cannot modify the original variable you passed in. This is the default and most common type of parameter.
    - `out` : output parameter, meaning the parameter is intended to be modified. In Code: The function ignores any initial value of the parameter. Its sole job is to assign a new value to it, which is then passed back to the caller.
    - `inout` : both input and output parameter, meaning the parameter can be modified and the modified value is returned. In Code: The function can both read the original value and modify the original variable. It's a combination of in and out.
- Constructors are represented by the class name itself. with <<create>> stereotype.
- Interfaces are represented by the <<interface>> stereotype. Methods in interfaces are implicitly abstract and public


### Relationships between classes
- **Generalization** (Inheritance) : It is a relationship between a more general class (superclass) and a more specific class (subclass). It is represented by a solid line with a hollow arrowhead pointing from the subclass to the superclass. Each instance of the specific class is also an instance of the general class.
    - represents a *"is-a"* relationship.
- **Association** : It represnts a relationship between two classes where one class uses or interacts with another class. It is represented by a solid line connecting the two classes. The line may have multiplicity indicators at each end to show how many instances of one class can be associated with instances of the other class.
    - Directional association is where the association has a direction, indicating one class is associated with another class in a specific way.
    - Unidirectional association: One class knows about the other, but not vice versa. Represented by an arrowhead on one end of the line.
    - Bidirectional association: Both classes know about each other. Represented by a simple line without arrowheads.
    - ##### Cardinality/Multiplicity
        - Slight fdifference between cardinality and multiplicity : 
            - Cardinality is the actual, specific number of things; Multiplicity is type level while cardinality is instance level.
            - Cardinality is the count of instances in a particular relationship;
            - In UML we use, multiplicity to express cardinality.
            - Multiplicity is the range of possible numbers of things
            - UML :     [Owner] "1" ————— "1..*" [Car] , Meaning : An owner must have exactly one car, but a car can have one or more owners. (one-to many relationship)
        - Specifies how many instances of one class can be associated with instances of another class.
        - expresseed in terms of : one to one, one to many, many to many.
        - Common multiplicity indicators:
            - `1` : Exactly one instance
            - `0..1` : Zero or one instance (optional)
            - `*` or `0..*` : Zero or more instances (many)
            - `1..*` : One or more instances
- **Aggregation** : A special type of association.
    - indicates a *"part-of"* relationship