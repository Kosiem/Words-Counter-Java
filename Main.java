import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.*;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame(); // create window
        window.setSize(800,600); // set it size

        JPanel panel = new JPanel(); // create a panel box layout (I want to things appear one under another)
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        window.add(panel); // add panel to window

        panel.add(Box.createHorizontalGlue()); // centering the box

        JTextField newText = new JTextField(); // create a textfield to insert text

        newText.setCaretPosition(0);

        panel.add(newText);

        JButton button = new JButton();
        button.setText("Count how many words");

        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String count =  newText.getText();
               String words[] = count.split(" ");
               int numberOfWords = words.length;

               JTextArea result = new JTextArea();
               result.setText("Number of words: " + numberOfWords);

               panel.add(result,BorderLayout.EAST);
               panel.revalidate();
               panel.repaint(); // this two functions are neccesarry to refresh panel and textArea with result

            }
        });

        window.setVisible(true);

    }
}