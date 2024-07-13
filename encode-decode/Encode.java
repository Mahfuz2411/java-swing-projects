import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Encode extends JFrame {
    private JLabel headerLabel;
    private JTextArea textArea;
    private JTextField textField;
    private JButton encodeButton;
    private JLabel textAreaLabel;
    private JLabel textFieldLabel;
    private JButton goBack;

    Encode() {
        setTitle("Encode");
        setSize(500, 500);
        setLocationRelativeTo(null);
        
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.gray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        headerLabel = new JLabel("Encode", JLabel.CENTER);
        headerLabel.setSize(500, 30);
        headerLabel.setLocation(0, 0);
        headerLabel.setOpaque(true);
        headerLabel.setBackground(Color.DARK_GRAY);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Courier New", Font.BOLD, 25));
        add(headerLabel);

        textAreaLabel = new JLabel("Input Text: ");
        textAreaLabel.setBounds(50, 50, 400, 20);
        add(textAreaLabel);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50, 70, 400, 200);
        add(scrollPane);



        textFieldLabel = new JLabel("Input Key: ");
        textFieldLabel.setBounds(50, 290, 400, 20);
        add(textFieldLabel);

        textField = new JTextField();
        textField.setBounds(50, 310, 400, 30);
        add(textField);

        goBack = new JButton("Go back");
        goBack.setBounds(50, 360, 190, 30);
        goBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        goBack.setFocusable(false);
        add(goBack);

        encodeButton = new JButton("Encode");
        encodeButton.setBounds(260, 360, 190, 30);
        encodeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        encodeButton.setFocusable(false);
        add(encodeButton);


        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Home();
            }
        });

        encodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                String keyText = textField.getText();
                int key;
                try {
                    key = Integer.parseInt(keyText);
                    String encodedText = encodeText(text, key);
                    JOptionPane.showMessageDialog(null, "Encoded Text: \n" + encodedText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer for the key.");
                }
            }
        });

        setVisible(true);
    }

    private String encodeText(String text, int key) {
        StringBuilder encoded = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + key) % 26 + base);
            }
            encoded.append(c);
        }
        return encoded.toString();
    }

    public static void main(String[] args) {
        new Encode();
    }
}
