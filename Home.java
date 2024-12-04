package com.kodnest.ds.project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Home extends JFrame {
	public Home() {
		setTitle("Data Structures");
	    setSize(400, 400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new BorderLayout());
	    // Heading
	    JLabel heading = new JLabel("Data Structures", SwingConstants.CENTER);
	    heading.setFont(new Font("Arial", Font.BOLD, 24));
	    add(heading, BorderLayout.NORTH);
	    // Panel for Buttons with 3 rows and 2 columns
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.setLayout(new GridLayout(3, 2, 10, 10));
	    // Buttons for Data Structures
	    JButton arrayButton = new JButton("Array");
	    JButton stackButton = new JButton("Stack");
	    JButton queueButton = new JButton("Queue");
	    JButton circularQueueButton = new JButton("Circular Queue");
	    JButton linkedListButton = new JButton("Linked List");
	    JButton doublyLinkedListButton = new JButton("Doubly Linked List");

	    // Add buttons to the panel
	    buttonPanel.add(arrayButton);
	    buttonPanel.add(stackButton);
	    buttonPanel.add(queueButton);
	    buttonPanel.add(circularQueueButton);
	    buttonPanel.add(linkedListButton);
	    buttonPanel.add(doublyLinkedListButton);

	    add(buttonPanel, BorderLayout.CENTER);

	        // Action Listeners for Buttons
	    arrayButton.addActionListener(e -> new ArrayFrame());
	    stackButton.addActionListener(e -> new StackFrame());
	    queueButton.addActionListener(e -> new QueueFrame());
	    circularQueueButton.addActionListener(e -> new CircularQueueFrame());
	    linkedListButton.addActionListener(e -> new LinkedListFrame());
	    doublyLinkedListButton.addActionListener(e -> new DoublyLinkedListFrame());
	}
	// Main method to launch the application
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> {
	        Home app = new Home();
	        app.setVisible(true);
	    });
	}
}


// Linked List Frame

// Doubly Linked List Frame
