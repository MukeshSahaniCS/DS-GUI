package com.kodnest.ds.project;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class ArrayFrame extends JFrame {
	private int[] array;       // Array to store elements
    private int size;          // Size of the array

    public ArrayFrame() {
        setTitle("Array Operations");
        setSize(400, 300); // Set the updated size
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 1, 5, 5)); // Layout for additional Back button row

        // Heading
        JLabel heading = new JLabel("Array-DS", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        add(heading);

        // Size and Create components
        JPanel sizePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JLabel sizeLabel = new JLabel("Size:");
        JTextField sizeField = new JTextField(4);
        JButton createButton = new JButton("Create");
        sizePanel.add(sizeLabel);
        sizePanel.add(sizeField);
        sizePanel.add(createButton);
        add(sizePanel);

        // Elem, Pos, and Insert components
        JPanel insertPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JLabel elemLabel = new JLabel("Elem:");
        JTextField elemField = new JTextField(4);
        JLabel posLabel = new JLabel("Pos:");
        JTextField posField = new JTextField(4);
        JButton insertButton = new JButton("Insert");
        insertPanel.add(elemLabel);
        insertPanel.add(elemField);
        insertPanel.add(posLabel);
        insertPanel.add(posField);
        insertPanel.add(insertButton);
        add(insertPanel);

        // Pos and Delete components
        JPanel deletePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JLabel delPosLabel = new JLabel("Pos:");
        JTextField delPosField = new JTextField(4);
        JButton deleteButton = new JButton("Delete");
        deletePanel.add(delPosLabel);
        deletePanel.add(delPosField);
        deletePanel.add(deleteButton);
        add(deletePanel);

        // Display components
        JPanel displayPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JLabel displayLabel = new JLabel("Output:");
        JTextField displayField = new JTextField(15);
        JButton displayButton = new JButton("Display");
        displayPanel.add(displayLabel);
        displayPanel.add(displayField);
        displayPanel.add(displayButton);
        add(displayPanel);

        // Back Button (on a new row)
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        add(backButton);

        // Action Listeners
        createButton.addActionListener(e -> {
            try {
                size = Integer.parseInt(sizeField.getText());
                array = new int[size];
                JOptionPane.showMessageDialog(this, "Array got created!");
                sizeField.setText(""); // Clear the size input field
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid size.");
            }
        });

        insertButton.addActionListener(e -> {
            try {
                int elem = Integer.parseInt(elemField.getText());
                int pos = Integer.parseInt(posField.getText());
                if (pos >= 0 && pos < size) {
                    array[pos] = elem;
                    JOptionPane.showMessageDialog(this, "Element inserted!");
                    elemField.setText(""); // Clear the Elem input field
                    posField.setText("");  // Clear the Pos input field
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid position. Please try again.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid element and position.");
            }
        });

        deleteButton.addActionListener(e -> {
            try {
                int pos = Integer.parseInt(delPosField.getText());
                if (pos >= 0 && pos < size) {
                    array[pos] = 0; // Reset the element to 0
                    JOptionPane.showMessageDialog(this, "Element deleted!");
                    delPosField.setText(""); // Clear the Pos input field for deletion
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid position. Please try again.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid position.");
            }
        });

        displayButton.addActionListener(e -> {
            if (array == null) {
                JOptionPane.showMessageDialog(this, "Array is not created yet.");
            } else {
                StringBuilder output = new StringBuilder();
                for (int num : array) {
                    output.append(num).append(" ");
                }
                displayField.setText(output.toString().trim());
            }
        });

        backButton.addActionListener(e -> {
            dispose(); // Close the current Array frame
            SwingUtilities.invokeLater(() -> new Home().setVisible(true)); // Reopen the Home Page
        });

        setVisible(true);
    }
}
