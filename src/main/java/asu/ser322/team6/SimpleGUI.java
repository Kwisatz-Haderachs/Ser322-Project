package asu.ser322.team6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI extends JFrame {
    private JTextField inputField;
    private JComboBox<String> dropDown;
    private JTextArea displayArea;

    public SimpleGUI() {
        // Set up the JFrame
        setTitle("Simple GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the components
        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(200, 25));

        dropDown = new JComboBox<>(new String[]{"Option 1", "Option 2", "Option 3"});
        displayArea = new JTextArea();

        // Set up the layout
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(new JLabel("Input: "));
        topPanel.add(inputField);
        topPanel.add(new JLabel("Dropdown: "));
        topPanel.add(dropDown);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Set up the button action listener
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                String selectedOption = (String) dropDown.getSelectedItem();

                displayArea.append("Input: " + inputText + "\n");
                displayArea.append("Selected Option: " + selectedOption + "\n");
                displayArea.append("----------------------\n");

                inputField.setText("");  // Clear the input field
            }
        });

        add(submitButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleGUI().setVisible(true);
            }
        });
    }
}