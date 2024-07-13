import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Tik_Tak_Toe_easy_version extends JFrame implements ActionListener{
  JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
  JButton[] btn;
  int game_over_value = 0;
  int moves_count = 0;
  int arr[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

  int winner = 0;
  Random random = new Random();

  Tik_Tak_Toe_easy_version(){
      setTitle("Tik Tak Toe");
      setSize(500, 530);
      setLocationRelativeTo(null);
      setLayout(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      createBtn();

      setVisible(true);
  }

  void createBtn() {
    btn0 = new JButton();
    btn1 = new JButton();
    btn2 = new JButton();
    btn3 = new JButton();
    btn4 = new JButton();
    btn5 = new JButton();
    btn6 = new JButton();
    btn7 = new JButton();
    btn8 = new JButton();
    btn9 = new JButton();

    btn1.setBounds(100, 80, 100, 100);
    btn2.setBounds(200, 80, 100, 100);
    btn3.setBounds(300, 80, 100, 100);
    btn4.setBounds(100, 180, 100, 100);
    btn5.setBounds(200, 180, 100, 100);
    btn6.setBounds(300, 180, 100, 100);
    btn7.setBounds(100, 280, 100, 100);
    btn8.setBounds(200, 280, 100, 100);
    btn9.setBounds(300, 280, 100, 100);

    btn1.setOpaque(true);
    btn2.setOpaque(true);
    btn3.setOpaque(true);
    btn4.setOpaque(true);
    btn5.setOpaque(true);
    btn6.setOpaque(true);
    btn7.setOpaque(true);
    btn8.setOpaque(true);
    btn9.setOpaque(true);

    btn = new JButton[10];
    btn[0] = btn0;
    btn[1] = btn1;
    btn[2] = btn2;
    btn[3] = btn3;
    btn[4] = btn4;
    btn[5] = btn5;
    btn[6] = btn6;
    btn[7] = btn7;
    btn[8] = btn8;
    btn[9] = btn9;

    add(btn[1]);
    add(btn[2]);
    add(btn[3]);
    add(btn[4]);
    add(btn[5]);
    add(btn[6]);
    add(btn[7]);
    add(btn[8]);
    add(btn[9]);

    btn1.setActionCommand(String.valueOf(1));
    btn2.setActionCommand(String.valueOf(2));
    btn3.setActionCommand(String.valueOf(3));
    btn4.setActionCommand(String.valueOf(4));
    btn5.setActionCommand(String.valueOf(5));
    btn6.setActionCommand(String.valueOf(6));
    btn7.setActionCommand(String.valueOf(7));
    btn8.setActionCommand(String.valueOf(8));
    btn9.setActionCommand(String.valueOf(9));

    btn[1].addActionListener(this);
    btn[2].addActionListener(this);
    btn[3].addActionListener(this);
    btn[4].addActionListener(this);
    btn[5].addActionListener(this);
    btn[6].addActionListener(this);
    btn[7].addActionListener(this);
    btn[8].addActionListener(this);
    btn[9].addActionListener(this);
  }

  void game_start(int index) {
    moves_count+=1;
    arr[index] = 1;
    btn[index].setBackground(Color.GREEN);
    int a = random.nextInt(10);
    while(moves_count<5 && arr[a]!=0 || a==0) a = random.nextInt(10);
    arr[a] = 2;
    btn[a].setBackground(Color.RED);

    System.out.println(index);
    System.out.println(a);

    win_lose_logic();
  }

  void win_lose_logic() {
    // ****************************************** Row wise
    if (arr[1] == arr[2] && arr[2] == arr[3] && arr[1] != 0) {
      winner = arr[1];
    }
    if (arr[4] == arr[5] && arr[5] == arr[6] && arr[4] != 0) {
      winner = arr[4];
    }
    if (arr[7] == arr[8] && arr[8] == arr[9] && arr[7] != 0) {
      winner = arr[7];
    }

    // ****************************************** Column wise
    if (arr[1] == arr[4] && arr[4] == arr[7] && arr[1] != 0) {
      winner = arr[1];
    }
    if (arr[2] == arr[5] && arr[5] == arr[8] && arr[2] != 0) {
      winner = arr[2];
    }
    if (arr[3] == arr[6] && arr[6] == arr[9] && arr[3] != 0) {
      winner = arr[3];
    }

    // ****************************************** Diagonal wise
    if (arr[1] == arr[5] && arr[5] == arr[9] && arr[1] != 0) {
      winner = arr[1];
    }
    if (arr[3] == arr[5] && arr[5] == arr[7] && arr[3] != 0) {
      winner = arr[3];
    }

    if (winner != 0 || moves_count == 5) {
      game_over();
    }
  }

  @SuppressWarnings("unused")
  void game_over() {
    game_over_value = 1;
    if (winner == 2)
      JOptionPane.showMessageDialog(null, "You Lose", "Result", 1);
    else if (winner == 1)
      JOptionPane.showMessageDialog(null, "You Won", "Result", 1);
    else
      JOptionPane.showMessageDialog(null, "Game Draw", "Result", 1);

    dispose();
    for (int i : arr)
      i = 0;
      Tik_Tak_Toe_easy_version ob = new Tik_Tak_Toe_easy_version();
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    String actionCommand = e.getActionCommand(); // Get the action command (index)
    int index = Integer.parseInt(actionCommand);
    if (arr[index] == 0) game_start(index);
  }
}
