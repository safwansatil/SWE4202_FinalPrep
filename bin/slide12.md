# GUI
Swing is a GUI (Graphical User Interface) widget toolkit for Java that provides a rich set of components for building desktop applications. It's part of Java Foundation Classes (JFC) and is built on top of the older AWT (Abstract Window Toolkit). <br>
Swing is built on top of AWT (Abstract window toolkit), written in java, and follows mvc and so on
In MVC terminology, 
- the model corresponds to the state information associated with the Component.
- The view determines how the component is displayed on the screen, including any aspects of the view that are affected by the current state of the model.
- The controller determines how the component reacts to the user.

### Important components in Swing
- **JOptionPane** : pop up dialog box to show message, take input, show confirmation dialog etc.
- **JFrame** : A top-level window with a title and a border that can hold other components.
- **JPanel** : A generic lightweight container.
- **JButton** : A button that can be clicked to perform an action.
- **JLabel** : A display area for a short text string or an image, or
an image and a text string.
- **JTextField** : A component that allows the editing of a single line of text
- **JTextArea** : A component that allows the editing of multiple lines of text.
- **JCheckBox** : A component that can be selected or deselected, typically used
to represent a binary choice.
- **JRadioButton** : A component that can be selected or deselected, typically used
to represent a choice among a set of mutually exclusive options.
- **ImageIcon** : An implementation of the Icon interface that paints Icons from Images. It can be used to display images in components like JLabel, JButton, etc.


### Event Handling in Swing
An event is a change in the state of an object triggered by some action like mouse click, keyboard press, etc.
The code that performs a task based on an event is called an event handler, and the overall process of responding to events is called event handling.

- #### How event handling works in Swing?
Using the event delegation model (An event's processing is delegated to an object (the eventListener) in the application), which involves three main components:
1. **Event Source**: The object that generates the event (e.g., a button).
2. **Event Listener**: An interface that defines methods to handle specific types of events (e.g., ActionListener for button clicks).
3. **Event Object**: An object that encapsulates information about the event (e.g., ActionEvent).

Layout Managers
Layout managers control how components are arranged in containers:

FlowLayout: Arranges components in a row, wrapping to next row if needed

BorderLayout: Divides container into five regions (NORTH, SOUTH, EAST, WEST, CENTER)

GridLayout: Arranges components in a grid of rows and columns

GridBagLayout: Most flexible, allows precise component positioning

BoxLayout: Arranges components in a single row or column



### Event Handling Approaches 
- **Using an Anonymous Inner Class**: This is a common and concise approach where you define the listener right where you add it to a component. It's best for simple, component-specific actions because the handling code is kept close to the source.
- **Implementing a Listener in the Main Class**: The main GUI class itself can implement a listener interface (like `ActionListener`). This is useful when multiple components trigger the same logic or when the event handling logic is complex and needs access to many parts of the main class.

