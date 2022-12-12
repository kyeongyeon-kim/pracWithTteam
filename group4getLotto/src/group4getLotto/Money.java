package group4getLotto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class Money extends JFrame {
   JScrollPane scrollPane;
   ImageIcon icon;

   public Money() {
      icon = new ImageIcon("money.png");
      
      
      List<Integer> list1 = new ArrayList<>();
      List<Integer> list2 = new ArrayList<>();
      List<Integer> list3 = new ArrayList<>();
      List<Integer> list4 = new ArrayList<>();
      List<Integer> list5 = new ArrayList<>();
      list1.add(1);list1.add(5); list1.add(11); list1.add(12); list1.add(30); list1.add(37);
//      list2.add(4);list2.add(12); list2.add(16); list2.add(17); list2.add(39); list2.add(41);
      list3.add(5);list3.add(11); list3.add(15); list3.add(20); list3.add(32); list3.add(35);
      list4.add(7);list4.add(13); list4.add(17); list4.add(19); list4.add(40); list4.add(44);
//      list5.add(9);list5.add(18); list5.add(30); list5.add(39); list5.add(43); list5.add(45);
      list2.add(0);list2.add(0); list2.add(0); list2.add(0); list2.add(0); list2.add(0);
      list5.add(0);list5.add(0); list5.add(0); list5.add(0); list5.add(0); list5.add(0);
      List[] list_ = {list1, list2, list3, list4, list5}; // 임시 배열. 입력 받아야 됨
      Rank ran = new Rank(list_);
      
      for (int i = 0; i < 5; i++) {
    	  System.out.print(ran.getRank()[i] + "  ");
    	  System.out.print(ran.getCountMain()[i] + "  ");
    	  System.out.println(ran.getCountBonus()[i]);
      }
      for (int i = 0; i < 6; i++) {
    	  System.out.println(ran.getLottoMain()[i]);
      }
      
	  System.out.println(ran.getLottoBonus());
      
      
      
      JPanel backgroud2 = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(icon.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };

      backgroud2.setLayout(null);
      scrollPane = new JScrollPane(backgroud2);
      setContentPane(scrollPane);

      // 당첨번호 라벨
      JLabel lucklbl = new JLabel("당첨번호(맞겠냐?)");
      backgroud2.add(lucklbl);
      lucklbl.setFont(new Font("맑은 고딕", Font.BOLD, 28));
      lucklbl.setBounds(190, 50, 400, 40);

      // 당첨금 라벨
      JLabel crtlbl = new JLabel("당첨금 :");
      backgroud2.add(crtlbl);
      crtlbl.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      crtlbl.setBounds(110, 185, 120, 40);

      // 당첨금 입력 라벨
      JLabel crtlb2 = new JLabel(String.valueOf(ran.getMoney()));
      backgroud2.add(crtlb2);
      crtlb2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      crtlb2.setBounds(190, 184, 500, 40);

//      // 몇개 맞춤
//      JLabel countbtn = new JLabel("몇개");
//      backgroud2.add(countbtn);
//      countbtn.setFont(new Font("굴림", Font.PLAIN, 15));
//      countbtn.setBounds(670, 260, 120, 40);

      // 몇등
      JLabel rankbtn = new JLabel("몇등");
      backgroud2.add(rankbtn);
      rankbtn.setFont(new Font("굴림", Font.PLAIN, 15));
      rankbtn.setBounds(113, 280, 120, 40);

      // 당첨번호 배열(랜덤)
      JLabel randomA[][] = new JLabel[7][1];
      JLabel random[][] = new JLabel[7][1];
      for (int i = 0; i < random.length; i++) {
         for (int j = 0; j < random[i].length; j++) {
        	 if (i < 6) {
        		 randomA[i][j] = new JLabel(String.valueOf(ran.getLottoMain()[i]));
        	 } else {
        		 randomA[i][j] = new JLabel(String.valueOf(ran.getLottoBonus()));
        	 }
        	 randomA[i][j].setFont(new Font("맑은 고딕", Font.BOLD, 28));
        	 randomA[i][j].setForeground(Color.WHITE);
        	if (i < 6) {
        		random[i][j] = new JLabel(String.valueOf(ran.getLottoMain()[i]));
        		if (i < 2) {
        			random[i][j].setIcon(new ImageIcon(Money.class.getResource("/group4getLotto/inputColor/b.png")));
        		} else {
        			random[i][j].setIcon(new ImageIcon(Money.class.getResource("/group4getLotto/inputColor/r.png")));
        		}
        	} else{
        		random[i][j] = new JLabel(String.valueOf(ran.getLottoBonus()));
        		random[i][j].setIcon(new ImageIcon(Money.class.getResource("/group4getLotto/inputColor/y.png")));
        	}
            backgroud2.add(randomA[i][j]);
            backgroud2.add(random[i][j]);
         }
      }
      JLabel plus = new JLabel("+");
      plus.setFont(new Font("맑은 고딕", Font.BOLD, 38));
//      plus.setForeground(Color.WHITE);
      backgroud2.add(plus);
      plus.setBounds(420, 111, 45, 45);
      
      int z = 0;
      for (int i = 0; i < random.length; i++) {
         for (int j = 0; j < random[i].length; j++) {
            z = i * 55 + 80;
            if (i < 6 && ran.getLottoMain()[i] < 10) {
            	randomA[i][j].setBounds(z + 14, 114, 45, 45);
            } else if (i == 6 && ran.getLottoBonus() < 10) {
            	randomA[i][j].setBounds(z + 74, 114, 45, 45);
            } else if (i == 6 && ran.getLottoBonus() >= 10) {
            	randomA[i][j].setBounds(z + 66, 114, 45, 45);
            } else {
            	randomA[i][j].setBounds(z + 6, 114, 45, 45);
            }
            if (i < 6) { 
            	random[i][j].setBounds(z, 115, 45, 45);
            } else {
            	random[i][j].setBounds(z + 60, 115, 45, 45);
            }
            ;
         }
      }
      
//      // 맞춘개수라벨 배열
//      JLabel countlbl[][] = new JLabel[1][5];
//      for (int i = 0; i < countlbl.length; i++) {
//         for (int j = 0; j < countlbl[i].length; j++) {
//        	if (j < ran.getCountMain().length) {
//        		if (ran.getCountMain()[j] == 5 && ran.getCountBonus()[j] == 1) {
//        			countlbl[i][j] = new JLabel(String.valueOf(ran.getCountMain()[j]) + "(+" + ran.getCountBonus()[j] + ")");
//        		} else {
//        			countlbl[i][j] = new JLabel(String.valueOf(ran.getCountMain()[j]));
//        		}
//        	} else {
//        		countlbl[i][j] = new JLabel("x");
//        	}
//            backgroud2.add(countlbl[i][j]);
//         }
//      }
//      int q = 0;
//      int w = 0;
//      for (int i = 0; i < countlbl.length; i++) {
//         for (int j = 0; j < countlbl[i].length; j++) {
//        	if (ran.getCountMain()[j] == 5 && ran.getCountBonus()[j] == 1) {
//        		q = i * 30 + 670;
//     		} else {
//     			q = i * 30 + 680;
//     		}
//            w = j * 25 + 290;
//            countlbl[i][j].setBounds(q, w, 40, 40);
//            ;
//         }
//      }

      // 등수라벨 배열
      JLabel ranklbl[][] = new JLabel[1][5];
      for (int i = 0; i < ranklbl.length; i++) {
         for (int j = 0; j < ranklbl[i].length; j++) {
        	 
        	 for (int g = 0; g < 5; g++) {
        		 if ((int) list_[i].get(j) == 0) {
        			 
        		 }
        	 }
        	 
        	 if (j < ran.getRank().length) {
        		 ranklbl[i][j] = new JLabel(ran.getRank()[j]);
        		 ranklbl[i][j].setFont(new Font("맑은 고딕", Font.BOLD, 28));
//        	     ranklbl[i][j].setForeground(Color.WHITE);
        	 } else {
        		 ranklbl[i][j] = new JLabel("x");
        	 }
            backgroud2.add(ranklbl[i][j]);
         }
      }
      int r = 0;
      for (int i = 0; i < ranklbl.length; i++) {
         for (int j = 0; j < ranklbl[i].length; j++) {
            r = j * 80 + 335;
            ranklbl[i][j].setBounds(113, r, 60, 40);
            ;
         }
      }

      // 확인 라벨
      JLabel okNumberlbl[][] = new JLabel[5][6];
      for (int i = 0; i < okNumberlbl.length; i++) {
          for (int j = 0; j < okNumberlbl[i].length; j++) {
        	  boolean sw = true;
        	  for (int g = 0; g < 6; g++) {
        		  if ((int) list_[i].get(j) == 0) {
        			  sw = false;
        		  }
        	  }
        	  if (sw) {
        		  okNumberlbl[i][j] = new JLabel(String.valueOf(list_[i].get(j)));
        		  okNumberlbl[i][j].setFont(new Font("맑은 고딕", Font.BOLD, 28));
        		  okNumberlbl[i][j].setForeground(Color.WHITE);
        		  backgroud2.add(okNumberlbl[i][j]);
        	  } else {
        		  okNumberlbl[i][j] = new JLabel();
        		  backgroud2.add(okNumberlbl[i][j]);
        	  }
          }
      }
      
      
      
      JLabel oklbl[][] = new JLabel[5][6];
      for (int i = 0; i < oklbl.length; i++) {
    	 int colorSwNumber = 0;
         for (int j = 0; j < oklbl[i].length; j++) {
           //// 이미지 추가 String Images = (i + 1) + ".png";
        	 oklbl[i][j] = new JLabel();
        	 boolean sw = true;
        	 for (int g = 0; g < 6; g++) {
        		 if(0 == (int) list_[i].get(i)) {
        			 sw = false;
        		 }
        	 }
        	 
        	 if (sw) {
//        	   oklbl[i][j] = new JLabel(String.valueOf(list_[i][j]));
        	   oklbl[i][j].setIcon(new ImageIcon(Money.class.getResource("/group4getLotto/inputColor/g.png")));
        	   for (int g = 0; g < 6; g++) {
        		   if (ran.getLottoMain()[g] == (int) list_[i].get(j)) {
        			   colorSwNumber++;
        			   if (colorSwNumber < 3) {
        				   oklbl[i][j].setIcon(new ImageIcon(Money.class.getResource("/group4getLotto/inputColor/b.png")));
        			   } else {
        				   oklbl[i][j].setIcon(new ImageIcon(Money.class.getResource("/group4getLotto/inputColor/r.png")));
        			   }
        		   } else if (ran.getLottoBonus() == (int) list_[i].get(j)) {
        			   oklbl[i][j].setIcon(new ImageIcon(Money.class.getResource("/group4getLotto/inputColor/y.png")));
        		   }
        	   }
	       	} else {
        		oklbl[i][j].setIcon(new ImageIcon(Money.class.getResource("/group4getLotto/inputColor/g.png")));
	       	}
            
            backgroud2.add(oklbl[i][j]);
         }
      }
      int x = 0;
      int y = 0;
      for (int i = 0; i < oklbl.length; i++) {
         for (int j = 0; j < oklbl[i].length; j++) {

        	x = j * 55 + 200;
        	y = i * 80 + 330;
        	
        	if ((int) list_[i].get(j) < 10) {
        		okNumberlbl[i][j].setBounds(x + 14, y + 2, 38, 38);
        	} else {
        		okNumberlbl[i][j].setBounds(x + 6, y + 2, 38, 38);
        	}
            oklbl[i][j].setBounds(x, y, 45, 45);
            
         }
      }

      // 확인버튼
      JButton okbtn = new JButton("확인");
      okbtn.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (okbtn == e.getSource()) {
				dispose();
			}
		}
	}); 
	
      
      
      JPanel baseColor1 = new JPanel();
      baseColor1.setBackground(SystemColor.inactiveCaptionBorder);
      backgroud2.add(baseColor1);
      baseColor1.setBounds(40, 20, 500, 160);
      
      JPanel baseColor2 = new JPanel();
      baseColor2.setBackground(SystemColor.inactiveCaptionBorder);
      backgroud2.add(baseColor2);
      baseColor2.setBounds(100, 183, 380, 50);
      
      JLabel baseLabel = new JLabel();
      baseLabel.setIcon(new ImageIcon(Money.class.getResource("/group4getLotto/Label.png")));
      baseLabel.setBounds(18, 283, 545, 430);
      backgroud2.add(baseLabel);
      
      JPanel baseColor = new JPanel();
      baseColor.setBackground(Color.white);
      backgroud2.add(baseColor);
      
      
      backgroud2.add(okbtn);
      okbtn.setFont(new Font("굴림", Font.BOLD, 13));
      okbtn.setBounds(260, 760, 70, 40);
   }

   public static void main(String[] args) {

      Money frame = new Money();

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(600, 880);
      frame.setVisible(true);

      // 마지막 고정작업

   }
}