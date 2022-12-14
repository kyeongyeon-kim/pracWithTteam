import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class Money extends JDialog {
   JScrollPane scrollPane;
   ImageIcon icon;

   public Money(List[] list) {
     setModal(true);
      icon = new ImageIcon("money.png");
      
      List[] list_ = list;
      Rank ran = new Rank(list_);
      
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
      JLabel lucklbl = new JLabel("당첨번호");
      backgroud2.add(lucklbl);
      lucklbl.setFont(new Font("HY견고딕", Font.PLAIN, 17));
      lucklbl.setBounds(165, 160, 400, 40);

      // 당첨금 라벨
      JLabel crtlbl = new JLabel("당첨금 :");
      backgroud2.add(crtlbl);
      crtlbl.setFont(new Font("맑은 고딕", Font.BOLD, 13));
      crtlbl.setBounds(225, 430, 120, 40);

      // 당첨금 입력 라벨
      JLabel crtlb2 = new JLabel(String.valueOf(ran.getMoney()));
      backgroud2.add(crtlb2);
      crtlb2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
      crtlb2.setBounds(280, 430, 500, 40);

      // 몇등
      JLabel rankbtn = new JLabel("열        등수                     선택번호");
      backgroud2.add(rankbtn);
      rankbtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
      rankbtn.setBounds(33, 255, 300, 40);

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
            randomA[i][j].setFont(new Font("맑은 고딕", Font.BOLD, 17));
            randomA[i][j].setForeground(Color.WHITE);
            
           if (i < 6) {
              ImageIcon aImg = new ImageIcon();
              if (ran.getLottoMain()[i] > 0) {
                 if ((int) ran.getLottoMain()[i] <= 10) {
                    aImg = new ImageIcon(Money.class.getResource("/inputColor/y.png"));
                 } else if ((int) ran.getLottoMain()[i] <= 20 ) {
                    aImg = new ImageIcon(Money.class.getResource("/inputColor/b.png"));
                 } else if ((int) ran.getLottoMain()[i] <= 30 ) {
                    aImg = new ImageIcon(Money.class.getResource("/inputColor/r.png"));
                 } else if ((int) ran.getLottoMain()[i] <= 40 ) {
                    aImg = new ImageIcon(Money.class.getResource("/inputColor/g.png"));
                 } else if ((int) ran.getLottoMain()[i] <= 45 )  {
                    aImg = new ImageIcon(Money.class.getResource("/inputColor/gr.png"));
                 }
              }
              random[i][j] = new JLabel(String.valueOf(ran.getLottoMain()[i]));
                Image bImg = aImg.getImage(); 
                Image cImg = bImg.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
                ImageIcon dImg = new ImageIcon(cImg); 
             random[i][j].setIcon(dImg);
           } else {
              ImageIcon aImg = new ImageIcon();
              if (ran.getLottoBonus() > 0) {
                 if ((int) ran.getLottoBonus() <= 10) {
                    aImg = new ImageIcon(Money.class.getResource("/inputColor/y.png"));
                 } else if ((int) ran.getLottoBonus() <= 20 ) {
                    aImg = new ImageIcon(Money.class.getResource("/inputColor/b.png"));
                 } else if ((int) ran.getLottoBonus() <= 30 ) {
                    aImg = new ImageIcon(Money.class.getResource("/inputColor/r.png"));
                 } else if ((int) ran.getLottoBonus() <= 40 ) {
                    aImg = new ImageIcon(Money.class.getResource("/inputColor/g.png"));
                 } else if ((int) ran.getLottoBonus() <= 45 )  {
                    aImg = new ImageIcon(Money.class.getResource("/inputColor/gr.png"));
                 }
              }
                Image bImg = aImg.getImage();  
                Image cImg = bImg.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
                ImageIcon dImg = new ImageIcon(cImg); 
              random[i][j] = new JLabel(String.valueOf(ran.getLottoBonus()));
              random[i][j].setIcon(dImg);
           }
            backgroud2.add(randomA[i][j]);
            backgroud2.add(random[i][j]);
         }
      }
      int z = 0;
      for (int i = 0; i < random.length; i++) {
         for (int j = 0; j < random[i].length; j++) {
            z = i * 35 + 70;
            if (i < 6 && ran.getLottoMain()[i] < 10) {
               randomA[i][j].setBounds(z + 10, 200, 30, 30);
            } else if (i == 6 && ran.getLottoBonus() < 10) {
               randomA[i][j].setBounds(z + 35, 200, 30, 30);
            } else if (i == 6 && ran.getLottoBonus() >= 10) {
               randomA[i][j].setBounds(z + 30, 200, 30, 30);
            } else {
               randomA[i][j].setBounds(z + 5, 200, 30, 30);
            }
            if (i < 6) { 
               random[i][j].setBounds(z, 201, 30, 30);
            } else {
               random[i][j].setBounds(z + 25, 201, 30, 30);
            }
         }
      }
      
      
      // 등수라벨 배열
      JLabel ranklbl[][] = new JLabel[1][5];
      for (int i = 0; i < ranklbl.length; i++) {
         for (int j = 0; j < ranklbl[i].length; j++) {
            
            if (j < ran.getRank().length) {
               ranklbl[i][j] = new JLabel(ran.getRank()[j]);
               ranklbl[i][j].setFont(new Font("맑은 고딕", Font.BOLD, 13));
//                ranklbl[i][j].setForeground(Color.WHITE);
            } else {
               ranklbl[i][j] = new JLabel("x");
            }
            backgroud2.add(ranklbl[i][j]);
         }
      }
      int r = 0;
      for (int i = 0; i < ranklbl.length; i++) {
         for (int j = 0; j < ranklbl[i].length; j++) {
            r = j * 25 + 289;
            
            boolean sw = true;
            for (int g = 0; g < 6; g++) {
               if(0 == (int) list_[j].get(g)) {
                  sw = false;
               }
            }
            
            if (sw) {
               if (ran.getRank()[j].equals("꽝")) {
                  ranklbl[i][j].setBounds(83, r, 60, 40);
               } else {
                  ranklbl[i][j].setBounds(80, r, 60, 40);
               }
            }
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
            oklbl[i][j] = new JLabel();
            boolean sw = true;
            for (int g = 0; g < 6; g++) {
               if(0 == (int) list_[i].get(i)) {
                  sw = false;
               }
            }
            if (sw) {
               for (int g = 0; g < 6; g++) {
                  ImageIcon aImg = new ImageIcon();
                  if (ran.getLottoMain()[g] == (int) list_[i].get(j) || ran.getLottoBonus() == (int) list_[i].get(j)) {
                    if ((int) list_[i].get(j) <= 10) {
                       aImg = new ImageIcon(Money.class.getResource("/inputColor/y.png"));
                       okNumberlbl[i][j].setForeground(Color.WHITE);
                    } else if ((int) list_[i].get(j) <= 20 ) {
                       aImg = new ImageIcon(Money.class.getResource("/inputColor/b.png"));
                       okNumberlbl[i][j].setForeground(Color.WHITE);
                    } else if ((int) list_[i].get(j) <= 30 ) {
                       aImg = new ImageIcon(Money.class.getResource("/inputColor/r.png"));
                       okNumberlbl[i][j].setForeground(Color.WHITE);
                    } else if ((int) list_[i].get(j) <= 40 ) {
                       aImg = new ImageIcon(Money.class.getResource("/inputColor/g.png"));
                       okNumberlbl[i][j].setForeground(Color.WHITE);
                    } else {
                       aImg = new ImageIcon(Money.class.getResource("/inputColor/gr.png"));
                       okNumberlbl[i][j].setForeground(Color.WHITE);
                    }
                    Image bImg = aImg.getImage();
                    Image cImg = bImg.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon dImg = new ImageIcon(cImg); 
                   oklbl[i][j].setIcon(dImg);
                 }
               }
            }
            backgroud2.add(oklbl[i][j]);
         }
      }
      
      
      int x = 0;
      int y = 0;
      for (int i = 0; i < 5; i++) {
         for (int j = 0; j < 6; j++) {

           x = j * 30 + 120;
           y = i * 25 + 293;
           
           if ((int) list_[i].get(j) < 10) {
              okNumberlbl[i][j].setBounds(x + 8, y + 2, 30, 30);
              oklbl[i][j].setBounds(x, y + 3, 30, 30);
           } else {
              okNumberlbl[i][j].setBounds(x + 5, y + 2, 30, 30);
              oklbl[i][j].setBounds(x, y + 3, 30, 30);
           }
            
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
   
      
      
      JLabel baseLabel = new JLabel();
      baseLabel.setIcon(new ImageIcon(Money.class.getResource("/background2.png")));
      baseLabel.setBounds(0, 0, 400, 565);
      backgroud2.add(baseLabel);
      
      
      backgroud2.add(okbtn);
      okbtn.setFont(new Font("굴림", Font.BOLD, 13));
      okbtn.setBounds(174, 490, 70, 40);
      
      
//      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(418, 600);
      setLocationRelativeTo(null);
      setVisible(true);
      
   }

}