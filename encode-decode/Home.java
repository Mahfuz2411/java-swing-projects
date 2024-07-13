import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener {
    private JButton button1, button2;
    private JLabel demo;
    // private Cursor cursor;
    
    Home(){
        setTitle("Home");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.gray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

        demo = new JLabel("WELCOME", JLabel.CENTER);
        demo.setSize(500, 30);
        demo.setLocation(0, 0);
        demo.setOpaque(true);
        demo.setBackground(Color.DARK_GRAY);
        demo.setForeground(Color.WHITE);
        demo.setFont(new Font("Courier New", Font.BOLD, 25));
        add(demo);


        button1 = new JButton("Encode");
        button1.setOpaque(true);
        button1.setBackground(Color.DARK_GRAY);
        button1.setForeground(Color.WHITE);
        button1.setSize(300, 60);
        button1.setLocation(100, 100);
        button1.setFont(new Font("Poppins", Font.BOLD, 20));
        button1.setFocusable(false);
        button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(button1);

        button2 = new JButton("Decode");
        button2.setOpaque(true);
        button2.setBackground(Color.DARK_GRAY);
        button2.setForeground(Color.WHITE);
        button2.setSize(300, 60);
        button2.setLocation(100, 170);
        button2.setFont(new Font("Poppins", Font.BOLD, 20));
        button2.setFocusable(false);
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(button2);

        
        button1.addActionListener(this);  //Encode
        button2.addActionListener(this);  //Decode


        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        try {
            if(cmd.equals("Encode")){
                dispose();
                new Encode();
            } else if (cmd.equals("Decode")) {
                dispose();
                new Decode();
            } 
        } catch (Exception ext) {
            String errorMssg = ext.getMessage();
            JOptionPane.showMessageDialog(null, errorMssg, "Error", 2);
        }
    }

    public static void main(String [] argc) {
        SwingUtilities.invokeLater(() -> new Home());
    }
}