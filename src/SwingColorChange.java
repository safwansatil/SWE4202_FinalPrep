import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SwingColorChange {

    public static void main(String[] args) {
        // Create and show the GUI directly
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        // 1. Create the main window (JFrame)
        JFrame frame = new JFrame("Simple Swing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));

        // 2. Create a label with initial text
        JLabel label = new JLabel("Click the button!");
        label.setOpaque(true); // This is needed for the background color to be visible

        // 3. Create a button
        JButton button = new JButton("Click Me");

        // 4. Add an ActionListener to the button
        button.addActionListener(new ActionListener() {
            private boolean clicked = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Change the label's text when the button is clicked
                if (!clicked) {
                    label.setText("Button has been clicked!");
                    label.setBackground(Color.GRAY);
                    clicked = true;
                } else {
                    label.setText("You clicked it again!");
                    label.setBackground(Color.CYAN);
                }
            }
        });

        // 5. Add components to the frame
        frame.add(label);
        frame.add(button);

        // 6. Center the frame on the screen and make it visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

