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

public class StackFrame extends JFrame {
	private int[] stack;       // Array to simulate the stack
    private int top;           // Top pointer for the stack
    private int size;          // Maximum size of the stack

    public StackFrame() {
        setTitle("Stack Operations");
        setSize(400, 300); // Set the window size
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 1, 5, 5)); // Layout with 7 rows

        // Heading
        JLabel heading = new JLabel("Stack", SwingConstants.CENTER);
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

        // Element and Push components
        JPanel pushPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JLabel elemLabel = new JLabel("Elem:");
        JTextField elemField = new JTextField(10);
        JButton pushButton = new JButton("Push");
        pushPanel.add(elemLabel);
        pushPanel.add(elemField);
        pushPanel.add(pushButton);
        add(pushPanel);

        // Pop button
        JPanel popPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton popButton = new JButton("Pop");
        popPanel.add(popButton);
        add(popPanel);

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

        // Initialize stack variables
        stack = null; // No stack initially
        top = -1;     // Empty stack

        // Action Listeners
        createButton.addActionListener(e -> {
            try {
                size = Integer.parseInt(sizeField.getText());
                stack = new int[size]; // Create the stack array
                top = -1;              // Initialize top pointer
                JOptionPane.showMessageDialog(this, "Stack of size " + size + " got created!");
                sizeField.setText(""); // Clear the size input field
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid size.");
            }
        });

        pushButton.addActionListener(e -> {
            try {
                if (stack == null) {
                    JOptionPane.showMessageDialog(this, "Create a stack first.");
                    return;
                }
                if (top == size - 1) {
                    JOptionPane.showMessageDialog(this, "Stack Overflow! Cannot push more elements.");
                    return;
                }
                int elem = Integer.parseInt(elemField.getText());
                stack[++top] = elem; // Push element onto the stack
                JOptionPane.showMessageDialog(this, "Element pushed!");
                elemField.setText(""); // Clear the Elem input field
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid element.");
            }
        });

        popButton.addActionListener(e -> {
            if (stack == null) {
                JOptionPane.showMessageDialog(this, "Create a stack first.");
            } else if (top == -1) {
                JOptionPane.showMessageDialog(this, "Stack Underflow! Cannot pop from an empty stack.");
            } else {
                int poppedElement = stack[top--]; // Pop element from the stack
                JOptionPane.showMessageDialog(this, "Popped element: " + poppedElement);
            }
        });

        displayButton.addActionListener(e -> {
            if (stack == null) {
                JOptionPane.showMessageDialog(this, "Create a stack first.");
            } else if (top == -1) {
                displayField.setText("Stack is empty.");
            } else {
                StringBuilder output = new StringBuilder();
                for (int i = 0; i <= top; i++) {
                    output.append(stack[i]).append(" ");
                }
                displayField.setText(output.toString().trim());
            }
        });

        backButton.addActionListener(e -> {
            dispose(); // Close the current Stack frame
            SwingUtilities.invokeLater(() -> new Home().setVisible(true)); // Reopen the Home Page
        });

        setVisible(true);
    }
}
