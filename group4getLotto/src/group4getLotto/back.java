package group4getLotto;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;

public class back extends JFrame {
   JScrollPane scrollPane;
   ImageIcon icon;
   JButton btn[][] = new JButton[9][5];

   public back() {
      icon = new ImageIcon("pnl.png");

      JPanel background = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(icon.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };

      background.setLayout(null);
      
      
      
      //복권이름라벨
      JLabel lbl = new JLabel("oo복권");
      lbl.setBounds(50, 30, 200, 50);
      lbl.setForeground(Color.GREEN);
      lbl.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 40));
      background.add(lbl);
      
      //내 로또번호
      JLabel lblmy = new JLabel("내 로또번호");
      lblmy.setBounds(50, 120, 200, 100);
      lblmy.setFont(new Font("굴림", Font.BOLD, 30));
      background.add(lblmy);
      
      
      //1-45 버튼 만드는거
      JToggleButton btn[][] = new JToggleButton[9][5];
      for (int i = 0; i < btn.length; i++) {
    	  for (int j = 0; j < btn[i].length; j++) {
    		  String icon = (i + 1) + ".png";
    		  
    		  btn[i][j] = new JToggleButton("");
    		  background.add(btn[i][j]);
    	  }
	}
      //위치 잡는거
      int x = 0;
      int y = 0;
      for (int i = 0; i < btn.length; i++) {
    	  for(int j = 0; j < btn[i].length; j++) {
    		  
    		  x = i * 45 + 20;
    		  y = j * 45 + 200;
    		  btn[i][j].setBounds(x, y, 40, 40);;
    	  }
      }
      
      //작업
//      // 선택확인창
//      JLabel oklbl[][] = new JLabel[6][5];
//      for (int i = 0; i < oklbl.length; i++) {
//    	  for (int j = 0; j < oklbl[i].length; j++) {
////    		  String Images = (i + 1) + ".png";
//    		  oklbl[i][j] = new JLabel("");
//    		  background.add(oklbl[i][j]);
//    	  }
//	}
//      //선택확인창 위치 잡는거
//      int z = 0;
//      int s = 0;
//      for (int i = 0; i < oklbl.length; i++) {
//    	  for(int j = 0; j < oklbl[i].length; j++) {
//    		  
//    		  z = i * 45 + 20;
//    		  s = j * 45 + 510;
//    		  oklbl[i][j].setBounds(z, s, 40, 40);;
//    	  }
//      }
      
      
      

      
      //자동 버튼
      JButton autobtn = new JButton("자동");
      background.add(autobtn);
      scrollPane = new JScrollPane(background);
      autobtn.setFont(new Font("굴림", Font.PLAIN, 20));
      setContentPane(scrollPane);
      autobtn.setBounds(300, 480, 80, 50);
      
      
      //확인버튼
      
      JButton chkbtn = new JButton("확인");
      background.add(chkbtn);
      scrollPane = new JScrollPane(background);
      chkbtn.setFont(new Font("굴림", Font.PLAIN, 20));
      setContentPane(scrollPane);
      chkbtn.setBounds(500, 480, 80, 50);
      
      //선택번호 확인
      JLabel lblcheck = new JLabel("선택번호 확인창");
      lblcheck.setBounds(500, 120, 250, 100);
      lblcheck.setFont(new Font("굴림", Font.BOLD, 30));
      background.add(lblcheck);
      
      //선택번호 확인창 라벨
//      JLabel conf = new JLabel("44");
//      background.add(conf);
//      conf.setFont(new Font("굴림", Font.PLAIN, 20));
//      conf.setBounds(510, 200, 40, 40);
//      
//      
//      JLabel conf2 = new JLabel("44");
//      background.add(conf2);
//      conf2.setFont(new Font("굴림", Font.PLAIN, 20));
//      conf2.setBounds(560, 200, 40, 40);
//      
      
      //초기화 (resbtn)
//      JButton resbtn[][] = new JButton[9][5];
//      for (int i = 0; i < resbtn.length; i++) {
//    	  for (int j = 0; j < resbtn[i].length; j++) {
////    		  String img = (i + 1) + ".png";
//    		  
//    		  resbtn[i][j] = new JButton("");
//    		  background.add(resbtn[i][j]);
//    	  }
//	}
//      //위치 잡는거
//      int x = 0;
//      int y = 0;
//      for (int i = 0; i < resbtn.length; i++) {
//    	  for(int j = 0; j < resbtn[i].length; j++) {
//    		  
//    		  x = i * 45 + 20;
//    		  y = j * 45 + 200;
//    		  resbtn[i][j].setBounds(x, y, 40, 40);;
//    	  }
//      }
      
      
//      JButton resbtn1 = new JButton("");
//      background.add(resbtn1);
//      scrollPane = new JScrollPane(background);
//      resbtn1.setFont(new Font("굴림", Font.PLAIN, 10));
//      setContentPane(scrollPane);
//      resbtn1.setBounds(840, 200, 40, 40);
//      
//      JButton resbtn2 = new JButton("");
//      background.add(resbtn2);
//      scrollPane = new JScrollPane(background);
//      resbtn2.setFont(new Font("굴림", Font.PLAIN, 10));
//      setContentPane(scrollPane);
//      resbtn2.setBounds(840, 250, 40, 40);
//      
//      JButton resbtn3 = new JButton("");
//      background.add(resbtn3);
//      scrollPane = new JScrollPane(background);
//      resbtn3.setFont(new Font("굴림", Font.PLAIN, 10));
//      setContentPane(scrollPane);
//      resbtn3.setBounds(840, 300, 40, 40);
//      
//      JButton resbtn4 = new JButton("");
//      background.add(resbtn4);
//      scrollPane = new JScrollPane(background);
//      resbtn4.setFont(new Font("굴림", Font.PLAIN, 10));
//      setContentPane(scrollPane);
//      resbtn4.setBounds(840, 350, 40, 40);
//      
//      JButton resbtn5 = new JButton("");
//      background.add(resbtn5);
//      scrollPane = new JScrollPane(background);
//      resbtn5.setFont(new Font("굴림", Font.PLAIN, 10));
//      setContentPane(scrollPane);
//      resbtn5.setBounds(840, 400, 40, 40);
//      
      
      
      
   }

   public static void main(String[] args) {
      back frame = new back();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(950, 700);
      frame.setVisible(true);
      //마지막 고정작업
	     
   }
}