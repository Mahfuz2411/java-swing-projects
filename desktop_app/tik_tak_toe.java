// import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// import java.util.*;

public class tik_tak_toe extends JFrame implements ActionListener {
  JButton tik_tak_toe_hard_button;
  JButton tik_tak_toe_easy_button;

  tik_tak_toe() {
    setTitle("Tik Tak Toe");
    setSize(500, 530);
    setLocationRelativeTo(null);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    tik_tak_toe_hard_button = new JButton("<html>Easy<html>");
    tik_tak_toe_hard_button.setBounds(50, 80, 95, 95);
    tik_tak_toe_hard_button.setActionCommand("TikTakToeEasy");
    tik_tak_toe_hard_button.addActionListener(this);
    add(tik_tak_toe_hard_button);

    tik_tak_toe_easy_button = new JButton("<html>Hard<html>");
    tik_tak_toe_easy_button.setBounds(150, 80, 95, 95);
    tik_tak_toe_easy_button.setActionCommand("TikTakToeHard");
    tik_tak_toe_easy_button.addActionListener(this);
    add(tik_tak_toe_easy_button);

    setVisible(true);
  }

  @SuppressWarnings("unused")
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == "TikTakToeHard") {
      dispose();
      Tik_Tak_Toe_hard_version ob = new Tik_Tak_Toe_hard_version();
    } else if(e.getActionCommand() == "TikTakToeEasy"){
      dispose();
      Tik_Tak_Toe_easy_version ob = new Tik_Tak_Toe_easy_version();
    } else {
      JOptionPane.showMessageDialog(null, "I am trying my best");
    }
  }

  @SuppressWarnings("unused")
  public static void main(String[] args) {
    tik_tak_toe ob = new tik_tak_toe();
  }
}
