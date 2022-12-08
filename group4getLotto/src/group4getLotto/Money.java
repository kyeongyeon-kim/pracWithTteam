package group4getLotto;

import java.awt.Font;
import java.awt.Graphics;

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

	      JPanel background = new JPanel() {
	         public void paintComponent(Graphics g) {
	            g.drawImage(icon.getImage(), 0, 0, null);
	            setOpaque(false);
	            super.paintComponent(g);
	         }
	      };

	      background.setLayout(null);
	      
	      
	      //당첨번호 라벨
	      JLabel lucklbl = new JLabel("당첨번호(맞겠냐?)");
	      background.add(lucklbl);
	      scrollPane = new JScrollPane(background);
	      lucklbl.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      lucklbl.setBounds(40, 140, 120, 40);
	      
	      //당첨금 라벨
	      JLabel crtlbl = new JLabel("당첨금 :");
	      background.add(crtlbl);
	      scrollPane = new JScrollPane(background);
	      crtlbl.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      crtlbl.setBounds(40, 260, 120, 40);
	      
	      //당첨금 입력 라벨
	      JLabel crtlb2 = new JLabel("123456789101111");
	      background.add(crtlb2);
	      scrollPane = new JScrollPane(background);
	      crtlb2.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      crtlb2.setBounds(100, 260, 120, 40);
	      
	      
	      
	      
	      //첫번째줄
	      JLabel conf = new JLabel("45");
	      background.add(conf);
	      scrollPane = new JScrollPane(background);
	      conf.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf.setBounds(80, 293, 40, 40);
	      
	      JLabel conf2 = new JLabel("45");
	      background.add(conf2);
	      scrollPane = new JScrollPane(background);
	      conf2.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf2.setBounds(120, 293, 40, 40);
	      
	      JLabel conf3 = new JLabel("45");
	      background.add(conf3);
	      scrollPane = new JScrollPane(background);
	      conf3.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf3.setBounds(160, 293, 40, 40);
	      
	      JLabel conf4 = new JLabel("45");
	      background.add(conf4);
	      scrollPane = new JScrollPane(background);
	      conf4.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf4.setBounds(200, 293, 40, 40);
	      
	      JLabel conf5 = new JLabel("45");
	      background.add(conf5);
	      scrollPane = new JScrollPane(background);
	      conf5.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf5.setBounds(240, 293, 40, 40);
	      
	      JLabel conf6 = new JLabel("45");
	      background.add(conf6);
	      scrollPane = new JScrollPane(background);
	      conf6.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf6.setBounds(280, 293, 40, 40);
	      
	      //2번쨰줄
	      JLabel conf7 = new JLabel("25");
	      background.add(conf7);
	      scrollPane = new JScrollPane(background);
	      conf7.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf7.setBounds(80, 317, 40, 40);
	      
	      JLabel conf8 = new JLabel("25");
	      background.add(conf8);
	      scrollPane = new JScrollPane(background);
	      conf8.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf8.setBounds(120, 317, 40, 40);
	      
	      JLabel conf9 = new JLabel("25");
	      background.add(conf9);
	      scrollPane = new JScrollPane(background);
	      conf9.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf9.setBounds(160, 317, 40, 40);
	      
	      JLabel conf10 = new JLabel("25");
	      background.add(conf10);
	      scrollPane = new JScrollPane(background);
	      conf10.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf10.setBounds(200, 317, 40, 40);
	      
	      JLabel conf11 = new JLabel("25");
	      background.add(conf11);
	      scrollPane = new JScrollPane(background);
	      conf11.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf11.setBounds(240, 317, 40, 40);
	      
	      JLabel conf12 = new JLabel("25");
	      background.add(conf12);
	      scrollPane = new JScrollPane(background);
	      conf12.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf12.setBounds(280, 317, 40, 40);
	      
	      //3번쨰줄
	      JLabel conf13 = new JLabel("33");
	      background.add(conf13);
	      scrollPane = new JScrollPane(background);
	      conf13.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf13.setBounds(80, 341, 40, 40);
	      
	      JLabel conf14 = new JLabel("33");
	      background.add(conf14);
	      scrollPane = new JScrollPane(background);
	      conf14.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf14.setBounds(120, 341, 40, 40);
	      
	      JLabel conf15 = new JLabel("33");
	      background.add(conf15);
	      scrollPane = new JScrollPane(background);
	      conf15.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf15.setBounds(160, 341, 40, 40);
	      
	      JLabel conf16 = new JLabel("33");
	      background.add(conf16);
	      scrollPane = new JScrollPane(background);
	      conf16.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf16.setBounds(200, 341, 40, 40);
	      
	      JLabel conf17 = new JLabel("33");
	      background.add(conf17);
	      scrollPane = new JScrollPane(background);
	      conf17.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf17.setBounds(240, 341, 40, 40);
	      
	      JLabel conf18 = new JLabel("33");
	      background.add(conf18);
	      scrollPane = new JScrollPane(background);
	      conf18.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf18.setBounds(280, 341, 40, 40);
	      
	      //4번쨰줄
	      JLabel conf19 = new JLabel("44");
	      background.add(conf19);
	      scrollPane = new JScrollPane(background);
	      conf19.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf19.setBounds(80, 367, 40, 40);
	      
	      JLabel conf20 = new JLabel("44");
	      background.add(conf20);
	      scrollPane = new JScrollPane(background);
	      conf20.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf20.setBounds(120, 367, 40, 40);
	      
	      JLabel conf21 = new JLabel("44");
	      background.add(conf21);
	      scrollPane = new JScrollPane(background);
	      conf21.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf21.setBounds(160, 367, 40, 40);
	      
	      JLabel conf22 = new JLabel("44");
	      background.add(conf22);
	      scrollPane = new JScrollPane(background);
	      conf22.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf22.setBounds(200, 367, 40, 40);
	      
	      JLabel conf23 = new JLabel("44");
	      background.add(conf23);
	      scrollPane = new JScrollPane(background);
	      conf23.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf23.setBounds(240, 367, 40, 40);
	      
	      JLabel conf24 = new JLabel("44");
	      background.add(conf24);
	      scrollPane = new JScrollPane(background);
	      conf24.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf24.setBounds(280, 367, 40, 40);
	      
	      //5번째줄
	      JLabel conf25 = new JLabel("55");
	      background.add(conf25);
	      scrollPane = new JScrollPane(background);
	      conf25.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf25.setBounds(80, 392, 40, 40);
	      
	      JLabel conf26 = new JLabel("55");
	      background.add(conf26);
	      scrollPane = new JScrollPane(background);
	      conf26.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf26.setBounds(120, 392, 40, 40);
	      
	      JLabel conf27 = new JLabel("55");
	      background.add(conf27);
	      scrollPane = new JScrollPane(background);
	      conf27.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf27.setBounds(160, 392, 40, 40);
	      
	      JLabel conf28 = new JLabel("55");
	      background.add(conf28);
	      scrollPane = new JScrollPane(background);
	      conf28.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf28.setBounds(200, 392, 40, 40);
	      
	      JLabel conf29 = new JLabel("55");
	      background.add(conf29);
	      scrollPane = new JScrollPane(background);
	      conf29.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf29.setBounds(240, 392, 40, 40);
	      
	      JLabel conf30 = new JLabel("55");
	      background.add(conf30);
	      scrollPane = new JScrollPane(background);
	      conf30.setFont(new Font("굴림", Font.PLAIN, 15));
	      setContentPane(scrollPane);
	      conf30.setBounds(280, 392, 40, 40);
	      
	      
	      // 확인버튼
	      JButton okbtn = new JButton("확인");
	      background.add(okbtn);
	      scrollPane = new JScrollPane(background);
	      okbtn.setFont(new Font("굴림", Font.BOLD, 13));
	      setContentPane(scrollPane);
	      okbtn.setBounds(155, 450, 70, 40);
	      
	      
	      //당첨번호(랜덤)
	     
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	     
	 }
	 
	   
	 public static void main(String[] args) {  
	 
	 Money frame = new Money();
	 
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(400, 565);
     frame.setVisible(true);

     //마지막 고정작업
     
	 
	 
	 
	 }
}
