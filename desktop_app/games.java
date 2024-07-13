// import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// import java.util.*;

public class games extends JFrame implements ActionListener {
    JButton tik_tak_toe_button;
    JButton coming_soon;
    games() {
        setTitle("Tik Tak Toe");
        setSize(500, 530);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tik_tak_toe_button = new JButton("<html>Tik Tak<br>Toe<html>");
        tik_tak_toe_button.setBounds(50, 80, 95, 95);
        tik_tak_toe_button.setActionCommand("TikTakToeButton");
        tik_tak_toe_button.addActionListener(this);
        add(tik_tak_toe_button);

        coming_soon = new JButton("<html>Comming<br>   Soon<html>");
        coming_soon.setBounds(150, 80, 95, 95);
        coming_soon.setActionCommand("CommingSoon");
        coming_soon.addActionListener(this);
        add(coming_soon);

        setVisible(true);
    }
    
    @SuppressWarnings("unused")
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="TikTakToeButton") {
            dispose();
            tik_tak_toe ob = new tik_tak_toe();
        }else {
            JOptionPane.showMessageDialog(null,"I am trying my best");
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        games ob = new games();
    }
}