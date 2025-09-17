import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SimpleSwingApp {

    public static void main(String[] args) {
        // Create the frame (main window)
        JFrame frame = new JFrame("Simple Swing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new java.awt.FlowLayout());
        frame.setBounds(550, 250, 300, 300);

        // Create a button and a label
        JButton button = new JButton("Click Me!");
        JLabel label = new JLabel("Button not clicked");

        // Add an action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Button clicked!");
            }
        });

        // Add components to the frame
        frame.add(button);
        frame.add(label);

        // Make the frame visible
        frame.setVisible(true);
    }
}