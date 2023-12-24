import javax.swing.*;
import java.util.Stack;

public class StackVisualizer extends javax.swing.JFrame {
    private Stack<Integer> stack;

    private javax.swing.JButton pushButton;
    private javax.swing.JButton popButton;
    private javax.swing.JButton displayButton;
    private javax.swing.JTextField elementTextField;
    private javax.swing.JScrollPane scrollPane;

    public StackVisualizer() {
        initComponents();
        stack = new Stack<>(); 
    }

    private void initComponents() {
        pushButton = new javax.swing.JButton();
        popButton = new javax.swing.JButton();
        displayButton = new javax.swing.JButton();
        elementTextField = new javax.swing.JTextField();
        scrollPane = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pushButton.setText("push");
        pushButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pushButtonActionPerformed(evt);
            }
        });

        popButton.setText("pop");
        popButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popButtonActionPerformed(evt);
            }
        });

        displayButton.setText("display");
        displayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayButtonActionPerformed(evt);
            }
        });

        elementTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elementTextFieldActionPerformed(evt);
            }
        });

      
        elementTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                elementTextFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(popButton)
                                                        .addComponent(displayButton))
                                                .addGap(158, 158, 158))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(pushButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(elementTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(38, 38, 38)))
                                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(pushButton)
                                                        .addComponent(elementTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(popButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(displayButton))
                                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }

    private void displayButtonActionPerformed(java.awt.event.ActionEvent evt) {
        updateStackList(true);
    }

    private void elementTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
      
    }

    private void pushButtonActionPerformed(java.awt.event.ActionEvent evt) {
        pushElement();
    }

    private void pushElement() {
        String input = elementTextField.getText();
        if (isValidNumber(input)) {
            int element = Integer.parseInt(input);
            stack.push(element);
            elementTextField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Enter a valid number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            elementTextField.setText(""); // Clear the text field
        }
    }

    private void popButtonActionPerformed(java.awt.event.ActionEvent evt) {
        popElement();
        updateStackList(false); // prevent updating the display
    }

    private void popElement() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    private void updateStackList(boolean updateDisplay) {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        for (int i = stack.size() - 1; i >= 0; i--) {
            textArea.append(stack.get(i).toString() + "\n");
        }

        if (updateDisplay) {
            scrollPane.setViewportView(textArea);
        }
    }

    private void elementTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        // Check if the pressed key is Enter (enter used to push)
        if (evt.getKeyCode() == 10) {
            pushButton.doClick();
        }
    }

    private boolean isValidNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StackVisualizer().setVisible(true);
            }
        });
    }
}
