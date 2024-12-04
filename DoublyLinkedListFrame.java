package com.kodnest.ds.project;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

class DoublyLinkedListFrame extends JFrame {
	private DoublyNode head;
    private DoublyNode tail;

    public DoublyLinkedListFrame() {
        setTitle("Doubly Linked-List Operations");
        setSize(500, 600);  // Increased frame size for more space
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));  // Use BoxLayout for vertical arrangement

        // Heading
        JLabel heading = new JLabel("Doubly Linked-List", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(heading);

        // Insert Rear components
        JPanel insertRearPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel insertRearLabel = new JLabel("Elem:");
        JTextField insertRearField = new JTextField(10);
        JButton insertRearButton = new JButton("Insert Rear");
        insertRearPanel.add(insertRearLabel);
        insertRearPanel.add(insertRearField);
        insertRearPanel.add(insertRearButton);
        insertRearPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(insertRearPanel);

        // Insert Front components
        JPanel insertFrontPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel insertFrontLabel = new JLabel("Elem:");
        JTextField insertFrontField = new JTextField(10);
        JButton insertFrontButton = new JButton("Insert Front");
        insertFrontPanel.add(insertFrontLabel);
        insertFrontPanel.add(insertFrontField);
        insertFrontPanel.add(insertFrontButton);
        insertFrontPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(insertFrontPanel);

        // Insert at Position components
        JPanel insertPosPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel insertPosLabel = new JLabel("Elem:");
        JTextField insertPosField = new JTextField(10);
        JLabel posLabel = new JLabel("Pos:");
        JTextField posField = new JTextField(3);
        JButton insertPosButton = new JButton("Insert at Position");
        insertPosPanel.add(insertPosLabel);
        insertPosPanel.add(insertPosField);
        insertPosPanel.add(posLabel);
        insertPosPanel.add(posField);
        insertPosPanel.add(insertPosButton);
        insertPosPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(insertPosPanel);

        // Delete First and Delete Last components
        JPanel deletePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton deleteFirstButton = new JButton("Delete First");
        JButton deleteLastButton = new JButton("Delete Last");
        deletePanel.add(deleteFirstButton);
        deletePanel.add(deleteLastButton);
        deletePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(deletePanel);

        // Delete at Index components
        JPanel deleteIndexPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel deleteIndexLabel = new JLabel("Pos:");
        JTextField deleteIndexField = new JTextField(3);
        JButton deleteIndexButton = new JButton("Delete at Index");
        deleteIndexPanel.add(deleteIndexLabel);
        deleteIndexPanel.add(deleteIndexField);
        deleteIndexPanel.add(deleteIndexButton);
        deleteIndexPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(deleteIndexPanel);

        // Display components
        JPanel displayPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel displayLabel = new JLabel("Display:");
        JTextField displayField = new JTextField(15);
        JButton displayButton = new JButton("Display Forward");
        JButton displayReverseButton = new JButton("Display Reverse");
        displayPanel.add(displayLabel);
        displayPanel.add(displayField);
        displayPanel.add(displayButton);
        displayPanel.add(displayReverseButton);
        displayPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(displayPanel);

        // Back Button (on a new row)
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton backButton = new JButton("Back");
        backButtonPanel.add(backButton);
        backButtonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(backButtonPanel);

        // Initialize Doubly Linked List
        head = null;
        tail = null;

        // Action Listeners
        insertRearButton.addActionListener(e -> {
            try {
                int elem = Integer.parseInt(insertRearField.getText());
                insertAtRear(elem);
                JOptionPane.showMessageDialog(this, "Element inserted at rear!");
                insertRearField.setText(""); // Clear the input field
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid element.");
            }
        });

        insertFrontButton.addActionListener(e -> {
            try {
                int elem = Integer.parseInt(insertFrontField.getText());
                insertAtFront(elem);
                JOptionPane.showMessageDialog(this, "Element inserted at front!");
                insertFrontField.setText(""); // Clear the input field
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid element.");
            }
        });

        insertPosButton.addActionListener(e -> {
            try {
                int elem = Integer.parseInt(insertPosField.getText());
                int position = Integer.parseInt(posField.getText());
                insertAtPosition(elem, position);
                JOptionPane.showMessageDialog(this, "Element inserted at position " + position + "!");
                insertPosField.setText("");
                posField.setText(""); // Clear the input fields
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid element and position.");
            }
        });

        deleteFirstButton.addActionListener(e -> {
            deleteFirst();
            JOptionPane.showMessageDialog(this, "First element deleted!");
        });

        deleteLastButton.addActionListener(e -> {
            deleteLast();
            JOptionPane.showMessageDialog(this, "Last element deleted!");
        });

        deleteIndexButton.addActionListener(e -> {
            try {
                int index = Integer.parseInt(deleteIndexField.getText());
                deleteAtIndex(index);
                JOptionPane.showMessageDialog(this, "Element at index " + index + " deleted!");
                deleteIndexField.setText(""); // Clear the input field
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid index.");
            }
        });

        displayButton.addActionListener(e -> {
            displayField.setText(displayForward());
        });

        displayReverseButton.addActionListener(e -> {
            displayField.setText(displayReverse());
        });

        backButton.addActionListener(e -> {
            dispose(); // Close the current DoublyLinkedList frame
            SwingUtilities.invokeLater(() -> new Home().setVisible(true)); // Reopen the Home Page
        });

        setVisible(true);
    }

    // Doubly Linked List Operations

    private void insertAtRear(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    private void insertAtFront(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    private void insertAtPosition(int data, int position) {
        if (position < 1) {
            JOptionPane.showMessageDialog(this, "Invalid position");
            return;
        }

        if (position == 1) {
            insertAtFront(data);
            return;
        }

        DoublyNode newNode = new DoublyNode(data);
        DoublyNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            JOptionPane.showMessageDialog(this, "Position out of range");
            return;
        }

        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    private void deleteFirst() {
        if (head != null) {
            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        }
    }

    private void deleteLast() {
        if (tail != null) {
            if (tail.prev == null) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }
    }

    private void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }

        DoublyNode temp = head;
        for (int i = 1; i < index && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            JOptionPane.showMessageDialog(this, "Index out of range");
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp == head) {
            head = temp.next;
        }
        if (temp == tail) {
            tail = temp.prev;
        }
    }

    private String displayForward() {
        StringBuilder sb = new StringBuilder();
        DoublyNode temp = head;
        while (temp != null) {
            sb.append(temp.data).append(" ");
            temp = temp.next;
        }
        return sb.toString();
    }

    private String displayReverse() {
        StringBuilder sb = new StringBuilder();
        DoublyNode temp = tail;
        while (temp != null) {
            sb.append(temp.data).append(" ");
            temp = temp.prev;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new DoublyLinkedListFrame();
    }
}

class DoublyNode {
    int data;
    DoublyNode next, prev;

    public DoublyNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}