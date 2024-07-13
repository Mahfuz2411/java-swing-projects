import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Tik_Tak_Toe_hard_version extends JFrame implements ActionListener{
  JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
  JButton [] btn;
  int game_over_value = 0;
  int moves_count = 0;
  int arr[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
  

  int winner=0;
  Random random = new Random();

  Tik_Tak_Toe_hard_version(){
      setTitle("Tik Tak Toe");
      setSize(500, 530);
      setLocationRelativeTo(null);
      setLayout(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      createBtn();

      setVisible(true);
  }

  void createBtn(){
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
      if(moves_count==1) {
          first_move(index);
      }else if(moves_count==2) {
          second_move(index);
      }else{
          rest_move(index);
      }
  }

  private void rest_move(int index) {
      btn[index].setBackground(Color.GREEN);
      arr[index] = 1;
      if(moves_count!=5) {
          boolean temp_checker = false;
          temp_checker = cross_check_no_one(2);
          if(temp_checker==false) temp_checker = cross_check_no_one(1);
          if(temp_checker==false) {
              ArrayList <Integer> f = new ArrayList<>();
              for(int i=1; i<10; i++) {
                  if(arr[i]==0) f.add(i);
              }
              int a = random.nextInt(f.size());
              arr[f.get(a)] = 2;
              btn[f.get(a)].setBackground(Color.RED);
          }
      }
      win_lose_logic();
  }

  void first_move(int index) {
      int f[] = {1, 3, 7, 9};
      btn[index].setBackground(Color.GREEN);
      arr[index] = 1;
      if(arr[5]==0) {
          arr[5]=2;
          btn[5].setBackground(Color.RED);
      }
      else {
          int a = random.nextInt(4);
          arr[f[a]]=2;
          btn[f[a]].setBackground(Color.RED);
      }
  }

  void second_move(int index) {
      btn[index].setBackground(Color.GREEN);
      arr[index] = 1;
      
      boolean temp_checker = false;
      temp_checker=cross_check_no_one(1);
      if(temp_checker==false) {
          temp_checker = cross_check_no_two();
      }
      if(temp_checker==false) {
          temp_checker = cross_check_no_three();
      }
      if(temp_checker==false) {
          int f[] = {2, 4, 6, 8};
          
          int a = random.nextInt(4);
          while(arr[f[a]]!=0) {
              a=random.nextInt(4);
          }
          arr[f[a]]=2;
          btn[f[a]].setBackground(Color.RED);
      }
      
  }
  boolean cross_check_no_three() {
      int f[] = {1, 3, 7, 9};
      
      boolean isOrNot = false;
      if(arr[1]==1 && arr[5]==1) {
          isOrNot = true;
      }else if(arr[3]==1 && arr[5]==1){
          isOrNot = true;
      }else if(arr[7]==1 && arr[5]==1){
          isOrNot = true;
      }else if(arr[9]==1 && arr[5]==1){
          isOrNot = true;
      }
      if(isOrNot) {
          int a = random.nextInt(4);
          while(arr[f[a]]!=0) {
              a=random.nextInt(4);
          }
          arr[f[a]]=2;
          btn[f[a]].setBackground(Color.RED);
          return true;
      }
      return false;
  }

  boolean cross_check_no_two() {
      if(arr[4]==arr[2] && arr[4]==1) {
          arr[1]=2;
          btn[1].setBackground(Color.RED);
          return true;
      } else if(arr[4]==arr[8] && arr[4]==1) {
          arr[7]=2;
          btn[7].setBackground(Color.RED);
          return true;
      } else if(arr[8]==arr[6] && arr[6]==1) {
          arr[9]=2;
          btn[9].setBackground(Color.RED);
          return true;
      }else if(arr[2]==arr[6] && arr[6]==1) {
          arr[3]=2;
          btn[3].setBackground(Color.RED);
          return true;
      }
      return false;
  }

  boolean cross_check_no_one(int n) {
      Color color = Color.RED;
      int carry=2;
      ArrayList <Integer> f = new ArrayList<Integer>();

      //****************************************** Row wise
      if(((arr[1]==arr[2]) && arr[1]==n && arr[3]==0) || ((arr[2]==arr[3]) && arr[2]==n && arr[1]==0) || ((arr[1]==arr[3]) && arr[1]==n && arr[2]==0)) {
          f.add(1);f.add(2);f.add(3);
      }
      else if(((arr[4]==arr[5]) && arr[4]==n && arr[6]==0) || ((arr[5]==arr[6]) && arr[5]==n && arr[4]==0) || ((arr[4]==arr[6]) && arr[4]==n && arr[5]==0)) {
          f.add(4);f.add(5);f.add(6);
      }
      else if(((arr[7]==arr[8]) && arr[7]==n && arr[9]==0) || ((arr[8]==arr[9]) && arr[8]==n && arr[7]==0) || ((arr[7]==arr[9]) && arr[7]==n && arr[8]==0)) {
          f.add(7);f.add(8);f.add(9);
      }

      //****************************************** Column wise
      else if(((arr[1]==arr[4]) && arr[1]==n && arr[7]==0) || ((arr[4]==arr[7]) && arr[4]==n && arr[1]==0) || ((arr[1]==arr[7]) && arr[1]==n && arr[4]==0)) {
          f.add(1);f.add(4);f.add(7);
      }
      else if(((arr[2]==arr[5]) && arr[2]==n && arr[8]==0) || ((arr[5]==arr[8]) && arr[5]==n && arr[2]==0) || ((arr[2]==arr[8]) && arr[2]==n && arr[5]==0)) {
          f.add(2);f.add(5);f.add(8);
      }
      else if(((arr[3]==arr[6]) && arr[3]==n && arr[9]==0) || ((arr[6]==arr[9]) && arr[6]==n && arr[3]==0) || ((arr[3]==arr[9]) && arr[3]==n && arr[6]==0)) {
          f.add(3);f.add(6);f.add(9);
      }

      //****************************************** Diagona==nise
      else if(((arr[1]==arr[5]) && arr[1]==n && arr[9]==0) || ((arr[1]==arr[9]) && arr[1]==n && arr[5]==0) || ((arr[5]==arr[9]) && arr[5]==n && arr[1]==0)) {
          f.add(1);f.add(5);f.add(9);
      }
      else if(((arr[3]==arr[5]) && arr[3]==n && arr[7]==0) || ((arr[5]==arr[7]) && arr[5]==n && arr[3]==0) || ((arr[3]==arr[7]) && arr[3]==n && arr[5]==0)) {
          f.add(3);f.add(5);f.add(7);
      }else{
          f.add(0);f.add(0);f.add(0);
      }
      
      if(f.get(0)!=0 && f.get(1)!=0 && f.get(2)!=0) {
          if((arr[f.get(0)]==arr[f.get(1)]) && arr[f.get(2)]==0) {
              arr[f.get(2)] = carry;
              btn[f.get(2)].setBackground(color);
              return true;
          } else if((arr[f.get(0)]==arr[f.get(2)]) && arr[f.get(1)]==0) {
              arr[f.get(1)] = carry;
              btn[f.get(1)].setBackground(color);
              return true;
          } else if((arr[f.get(1)]==arr[f.get(2)]) && arr[f.get(0)]==0) {
              arr[f.get(0)] = carry;
              btn[f.get(0)].setBackground(color);
              return true;
          }
      }
      
      return false;
  }

  void win_lose_logic() {
      //****************************************** Row wise
      if(arr[1]==arr[2] && arr[2]==arr[3] && arr[1]!=0) {
          winner = arr[1];
      }
      if(arr[4]==arr[5] && arr[5]==arr[6] && arr[4]!=0) {
          winner = arr[4];
      }
      if(arr[7]==arr[8] && arr[8]==arr[9] && arr[7]!=0) {
          winner = arr[7];
      }

      //****************************************** Column wise
      if(arr[1]==arr[4] && arr[4]==arr[7] && arr[1]!=0) {
          winner = arr[1];
      }
      if(arr[2]==arr[5] && arr[5]==arr[8] && arr[2]!=0) {
          winner = arr[2];
      }
      if(arr[3]==arr[6] && arr[6]==arr[9] && arr[3]!=0) {
          winner = arr[3];
      }

      //****************************************** Diagonal wise
      if(arr[1]==arr[5] && arr[5]==arr[9] && arr[1]!=0) {
          winner = arr[1];
      }
      if(arr[3]==arr[5] && arr[5]==arr[7] && arr[3]!=0) {
          winner = arr[3];
      }

      if(winner!=0 || moves_count==5){
          game_over();
      }
  }

  @SuppressWarnings("unused")
void game_over() {
      game_over_value = 1;
      if(winner==2) JOptionPane.showMessageDialog(null, "You Lose", "Result", 1);
      else if(winner==1) JOptionPane.showMessageDialog(null, "You Won", "Result", 1);
      else JOptionPane.showMessageDialog(null, "Game Draw", "Result", 1);

      dispose();
      for (int i : arr) i = 0;
      Tik_Tak_Toe_hard_version ob = new Tik_Tak_Toe_hard_version();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
      
      String actionCommand = e.getActionCommand(); // Get the action command (index)
      int index = Integer.parseInt(actionCommand);
      if(arr[index]==0) game_start(index);
  }
}
