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

class QueueFrame extends JFrame {
	private int[] queue;        // Array to simulate the queue
    private int front;          // Front pointer
    private int rear;           // Rear pointer
    private int size;           // Maximum size of the queue
    private int count;          // Current number of elements in the queue

    public QueueFrame() {
        setTitle("Queue Operations");
        setSize(400, 300); // Set the window size
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 1, 5, 5)); // Layout with 7 rows

        // Heading
        JLabel heading = new JLabel("Queue", SwingConstants.CENTER);
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

        // Element and Insert components
        JPanel insertPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JLabel elemLabel = new JLabel("Elem:");
        JTextField elemField = new JTextField(10);
        JButton insertButton = new JButton("Insert");
        insertPanel.add(elemLabel);
        insertPanel.add(elemField);
        insertPanel.add(insertButton);
        add(insertPanel);

        // Delete button
        JPanel deletePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton deleteButton = new JButton("Delete");
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

        // Initialize queue variables
        queue = null; // No queue initially
        front = 0;    // Initialize front pointer
        rear = -1;    // Initialize rear pointer
        count = 0;    // Initialize element count

        // Action Listeners
        createButton.addActionListener(e -> {
            try {
                size = Integer.parseInt(sizeField.getText());
                queue = new int[size]; // Create the queue array
                front = 0;
                rear = -1;
                count = 0;
                JOptionPane.showMessageDialog(this, "Queue of size " + size + " got created!");
                sizeField.setText(""); // Clear the size input field
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid size.");
            }
        });

        insertButton.addActionListener(e -> {
            try {
                if (queue == null) {
                    JOptionPane.showMessageDialog(this, "Create a queue first.");
                    return;
                }
                if (count == size) {
                    JOptionPane.showMessageDialog(this, "Queue Overflow! Cannot insert more elements.");
                    return;
                }
                int elem = Integer.parseInt(elemField.getText());
                rear = (rear + 1) % size; // Circular increment
                queue[rear] = elem;
                count++;
                JOptionPane.showMessageDialog(this, "Element inserted!");
                elemField.setText(""); // Clear the Elem input field
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid element.");
            }
        });

        deleteButton.addActionListener(e -> {
            if (queue == null) {
                JOptionPane.showMessageDialog(this, "Create a queue first.");
            } else if (count == 0) {
                JOptionPane.showMessageDialog(this, "Queue Underflow! Cannot delete from an empty queue.");
            } else {
                int deletedElement = queue[front];
                front = (front + 1) % size; // Circular increment
                count--;
                JOptionPane.showMessageDialog(this, "Deleted element: " + deletedElement);
            }
        });

        displayButton.addActionListener(e -> {
            if (queue == null) {
                JOptionPane.showMessageDialog(this, "Create a queue first.");
            } else if (count == 0) {
                displayField.setText("Queue is empty.");
            } else {
                StringBuilder output = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    output.append(queue[(front + i) % size]).append(" ");
                }
                displayField.setText(output.toString().trim());
            }
        });

        backButton.addActionListener(e -> {
            dispose(); // Close the current Queue frame
            SwingUtilities.invokeLater(() -> new Home().setVisible(true)); // Reopen the Home Page
        });

        setVisible(true);
    }
}
