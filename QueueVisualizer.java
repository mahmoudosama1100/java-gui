import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class QueueVisualizer extends JFrame {
    private LinkedList<Integer> queue;

    private JButton enqueueButton;
    private JButton dequeueButton;
    private JTextField elementTextField;
    private JTextArea displayArea;
    private JScrollPane scrollPane;

    public QueueVisualizer() {
        initComponents();
        queue = new LinkedList<>(); // Initialize the queue
    }

    private void initComponents() {
        enqueueButton = new JButton("Enqueue");
        dequeueButton = new JButton("Dequeue");
        elementTextField = new JTextField();
        displayArea = new JTextArea();
        scrollPane = new JScrollPane(displayArea);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        enqueueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                enqueueButtonActionPerformed(evt);
            }
        });

        dequeueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dequeueButtonActionPerformed(evt);
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
                            .addComponent(enqueueButton)
                            .addGap(75, 75, 75)
                            .addComponent(elementTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                        .addComponent(dequeueButton))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(enqueueButton)
                        .addComponent(elementTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(dequeueButton)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );

        pack();
    }

    private void dequeueButtonActionPerformed(ActionEvent evt) {
        dequeueElement();
        displayQueue();
    }

    private void enqueueButtonActionPerformed(ActionEvent evt) {
        enqueueElement();
        displayQueue();
    }

    private void elementTextFieldActionPerformed(ActionEvent evt) {
     
    }

    private void enqueueElement() {
        try {
            int element = Integer.parseInt(elementTextField.getText());
            queue.addLast(element);
            elementTextField.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter a valid number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            elementTextField.setText("");
        }
    }

    private void dequeueElement() {
        if (!queue.isEmpty()) {
            queue.removeFirst();
        }
    }

    private void displayQueue() {
        displayArea.setText(""); // Clear the existing text

        for (Integer element : queue) {
            displayArea.append(element + "\n");
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
            java.util.logging.Logger.getLogger(QueueVisualizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QueueVisualizer().setVisible(true);
            }
        });
    }
}
