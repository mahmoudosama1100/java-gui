import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListVisualizer extends JFrame {
    private Node head;

    private JButton addButton;
    private JButton removeButton;
    private JTextField elementTextField;
    private JTextArea displayArea;
    private JScrollPane scrollPane;

    public LinkedListVisualizer() {
        initComponents();
        head = null; // Initialize the linked list
    }

    private void initComponents() {
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        elementTextField = new JTextField();
        displayArea = new JTextArea();
        scrollPane = new JScrollPane(displayArea);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        elementTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                elementTextFieldActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(addButton)
                            .addGap(75, 75, 75)
                            .addComponent(elementTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                        .addComponent(removeButton))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addButton)
                        .addComponent(elementTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(removeButton)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );

        pack();
    }

    private void removeButtonActionPerformed(ActionEvent evt) {
        removeElement();
        displayLinkedList();
    }

    private void addButtonActionPerformed(ActionEvent evt) {
        addElement();
        displayLinkedList();
    }

    private void elementTextFieldActionPerformed(ActionEvent evt) {
        // Handle the event if needed
    }

    private void addElement() {
        try {
            int element = Integer.parseInt(elementTextField.getText());
            Node newNode = new Node(element);

            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }

            elementTextField.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter a valid number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            elementTextField.setText("");
        }
    }

    private void removeElement() {
        if (head == null) {
            return; // The list is empty, nothing to remove
        }

        head = head.next; // Move the head to the next node, effectively removing the first node
    }

    private void displayLinkedList() {
        displayArea.setText(""); // Clear the existing text

        Node current = head;
        while (current != null) {
            displayArea.append(current.data + "\n");
            current = current.next;
        }
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LinkedListVisualizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LinkedListVisualizer().setVisible(true);
            }
        });
    }
}
