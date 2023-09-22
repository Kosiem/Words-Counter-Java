import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame{
    private JPanel panel1;
    private JButton button1;
    private JLabel label1;
    private JTextArea textArea1;


    public Window() {
        setContentPane(panel1);
        setTitle("Words Counter");
        setSize(800, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String count =  textArea1.getText();
                String words[] = count.trim().split("[\\pP\\s&&[^’]]+");
                int numberOfWords = 0;
                for (String word : words) {
                    System.out.println(word);
                    if (!word.isEmpty()) {
                        numberOfWords++;
                    }
                }
                label1.setText("Number of words: " + numberOfWords);
                panel1.revalidate();
                panel1.repaint();

            }
        });
    }
        public static void main (String[] args){

        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch ( Exception e) {
                System.out.print("Error");
            }

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Window();
                }
            });

    }
}
