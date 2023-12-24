import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainVisualizer extends JFrame {
    public MainVisualizer() {
        initComponents();
    }

    private void initComponents() {
        JButton queueButton = new JButton("Queue Visualizer");
        JButton linkedListButton = new JButton("Linked List Visualizer");
        JButton stackButton = new JButton("Stack Visualizer");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        queueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openQueueVisualizer();
            }
        });

        linkedListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openLinkedListVisualizer();
            }
        });

        stackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openStackVisualizer();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(queueButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(linkedListButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(stackButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(queueButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addComponent(linkedListButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addComponent(stackButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }

    private void openQueueVisualizer() {
        QueueVisualizer queueVisualizer = new QueueVisualizer();
        queueVisualizer.setVisible(true);
    }

    private void openLinkedListVisualizer() {
        LinkedListVisualizer linkedListVisualizer = new LinkedListVisualizer();
        linkedListVisualizer.setVisible(true);
    }

    private void openStackVisualizer() {
        StackVisualizer stackVisualizer = new StackVisualizer();
        stackVisualizer.setVisible(true);
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
            java.util.logging.Logger.getLogger(MainVisualizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainVisualizer().setVisible(true);
            }
        });
    }
}
