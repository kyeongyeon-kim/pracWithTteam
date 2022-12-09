package group4getLotto;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Money extends JFrame {
   JScrollPane scrollPane;
   ImageIcon icon;

   public Money() {
      icon = new ImageIcon("money.png");
      
      
      int[] list1 = {1, 5, 11 ,12, 30, 37};
      int[] list2 = {4, 12, 16 ,17, 39, 41};
      int[] list3 = {5, 11, 15, 20, 32, 35};
      int[] list4 = {7, 13, 17 ,15, 40, 44};
      int[] list5 = {9, 18, 30 ,39, 43, 45};
      int[][] list_ = {list1, list2, list3, list4, list5}; // 임시 배열. 입력 받아야 됨
//      int[] list1 = {1, 5, 11 ,12, 30, 45}; //배열 수 다르게 해도 적용 o
//      int[] list2 = {4, 15, 10 ,17, 39, 41};
//      int[][] list_ = {list1, list2};
      Rank ran = new Rank(list_);
      
      new WhiteNumber();
      
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
      lucklbl.setFont(new Font("굴림", Font.PLAIN, 15));
      lucklbl.setBounds(40, 140, 120, 40);

      // 당첨금 라벨
      JLabel crtlbl = new JLabel("당첨금 :");
      backgroud2.add(crtlbl);
      crtlbl.setFont(new Font("굴림", Font.PLAIN, 15));
      crtlbl.setBounds(40, 260, 120, 40);

      // 당첨금 입력 라벨
      JLabel crtlb2 = new JLabel(String.valueOf(ran.getMoney()));
      backgroud2.add(crtlb2);
      crtlb2.setFont(new Font("굴림", Font.PLAIN, 15));
      crtlb2.setBounds(100, 260, 120, 40);

      // 몇개 맞춤
      JLabel countbtn = new JLabel("몇개");
      backgroud2.add(countbtn);
      countbtn.setFont(new Font("굴림", Font.PLAIN, 15));
      countbtn.setBounds(270, 260, 120, 40);

      // 몇등
      JLabel rankbtn = new JLabel("몇등");
      backgroud2.add(rankbtn);
      rankbtn.setFont(new Font("굴림", Font.PLAIN, 15));
      rankbtn.setBounds(330, 260, 120, 40);

      // 당첨번호 배열(랜덤)
      JLabel random[][] = new JLabel[7][1];
      for (int i = 0; i < random.length; i++) {
         for (int j = 0; j < random[i].length; j++) {
        	if (i < 6) {
        		random[i][j] = new JLabel(String.valueOf(ran.getLottoMain()[i]));
        	} else{
        		random[i][j] = new JLabel(String.valueOf(ran.getLottoBonus()));
        	}
            backgroud2.add(random[i][j]);
         }
      }
      int z = 0;
      for (int i = 0; i < random.length; i++) {
         for (int j = 0; j < random[i].length; j++) {
            z = i * 70 + 235;
            random[i][j].setBounds(z, 55, 45, 45);
            ;
         }
      }
      
      // 맞춘개수라벨 배열
      JLabel countlbl[][] = new JLabel[1][5];
      for (int i = 0; i < countlbl.length; i++) {
         for (int j = 0; j < countlbl[i].length; j++) {
        	if (j < ran.getCountMain().length) {
        		if (ran.getCountMain()[j] == 5 && ran.getCountBonus()[j] == 1) {
        			countlbl[i][j] = new JLabel(String.valueOf(ran.getCountMain()[j]) + "(+" + ran.getCountBonus()[j] + ")");
        		} else {
        			countlbl[i][j] = new JLabel(String.valueOf(ran.getCountMain()[j]));
        		}
        	} else {
        		countlbl[i][j] = new JLabel("x");
        	}
            backgroud2.add(countlbl[i][j]);
         }
      }
      int q = 0;
      int w = 0;
      for (int i = 0; i < countlbl.length; i++) {
         for (int j = 0; j < countlbl[i].length; j++) {
        	if (ran.getCountMain()[j] == 5 && ran.getCountBonus()[j] == 1) {
        		q = i * 30 + 270;
     		} else {
     			q = i * 30 + 280;
     		}
            w = j * 25 + 290;
            countlbl[i][j].setBounds(q, w, 40, 40);
            ;
         }
      }

      // 등수라벨 배열
      JLabel ranklbl[][] = new JLabel[1][5];
      for (int i = 0; i < ranklbl.length; i++) {
         for (int j = 0; j < ranklbl[i].length; j++) {
        	 if (j < ran.getRank().length) {
        		 ranklbl[i][j] = new JLabel(ran.getRank()[j]);
        	 } else {
        		 ranklbl[i][j] = new JLabel("x");
        	 }
            backgroud2.add(ranklbl[i][j]);
         }
      }
      int e = 0;
      int r = 0;
      for (int i = 0; i < ranklbl.length; i++) {
         for (int j = 0; j < ranklbl[i].length; j++) {
            e = i * 30 + 336;
            r = j * 25 + 290;
            ranklbl[i][j].setBounds(e, r, 40, 40);
            ;
         }
      }

      // 확인 라벨
      JLabel okNumberlbl[][] = new JLabel[5][6];
      for (int i = 0; i < okNumberlbl.length; i++) {
          for (int j = 0; j < okNumberlbl[i].length; j++) {
        	  okNumberlbl[i][j] = new JLabel();
        	  if (i < list_.length) {
        		  int im = list_[i][j];
        		  okNumberlbl[i][j].setIcon(WhiteNumber.image(im));
        	  }
        	  backgroud2.add(okNumberlbl[i][j]);
          }
      }
      
      
      
      JLabel oklbl[][] = new JLabel[5][6];
      for (int i = 0; i < oklbl.length; i++) {
         for (int j = 0; j < oklbl[i].length; j++) {
           //// 이미지 추가 String Images = (i + 1) + ".png";
           if (i < list_.length) {
        	   int colorSwNumber = 0;
//        	   oklbl[i][j] = new JLabel(String.valueOf(list_[i][j]));
        	   oklbl[i][j] = new JLabel();
        	   if (ran.getLottoMain()[j] == list_[i][j]) {
            		colorSwNumber++;
            		if (colorSwNumber < 4) {
            			oklbl[i][j].setIcon(new ImageIcon(Money.class.getResource("/group4getLotto/inputColor/b.png")));
            		} else {
            			oklbl[i][j].setIcon(new ImageIcon(Money.class.getResource("/group4getLotto/inputColor/r.png")));
            		}
            	} else if (ran.getLottoBonus() == list_[i][j]) {
            		oklbl[i][j].setIcon(new ImageIcon(Money.class.getResource("/group4getLotto/inputColor/y.png")));
            	} else {
            		oklbl[i][j].setIcon(new ImageIcon(Money.class.getResource("/group4getLotto/inputColor/g.png")));
            	}
	       	} else {
	       		oklbl[i][j] = new JLabel("x");
	       	}
            
            backgroud2.add(oklbl[i][j]);
         }
      }
      int x = 0;
      int y = 0;
      for (int i = 0; i < oklbl.length; i++) {
         for (int j = 0; j < oklbl[i].length; j++) {

        	x = j * 30 + 50;
            y = i * 25 + 290;
            oklbl[i][j].setBounds(x, y, 40, 40);
            
            x = j * 30 + 50;
            y = i * 25 + 290;
            okNumberlbl[i][j].setBounds(x, y, 40, 40);
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
	
	
      backgroud2.add(okbtn);
      okbtn.setFont(new Font("굴림", Font.BOLD, 13));
      okbtn.setBounds(340, 460, 70, 40);
   }

   public static void main(String[] args) {

      Money frame = new Money();

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(750, 580);
      frame.setVisible(true);

      // 마지막 고정작업

   }
}