import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordCounter extends JFrame {
    private JLabel titleLabel;
    private JLabel resultLabel;
    private JTextArea inputTextArea;
    private JButton countButton;

    public WordCounter() {
        setTitle("Word Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Enter your paragraph:");
        resultLabel = new JLabel("Number of words: 0");
        inputTextArea = new JTextArea();
        countButton = new JButton("Count Words");

        countButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String paragraph = inputTextArea.getText();
                int wordCount = countWords(paragraph);
                resultLabel.setText("Number of words: " + wordCount);
            }
        });

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(titleLabel, BorderLayout.NORTH);
        inputPanel.add(new JScrollPane(inputTextArea), BorderLayout.CENTER);
        inputPanel.add(countButton, BorderLayout.SOUTH);

        add(inputPanel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private int countWords(String paragraph) {
        if (paragraph == null || paragraph.isEmpty()) {
            return 0;
        }

        String[] words = paragraph.split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WordCounter();
            }
        });
    }
}


