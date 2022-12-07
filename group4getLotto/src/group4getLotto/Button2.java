package group4getLotto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame {
	
	public MainFrame() {
		
		JButton btn = new JButton("확인");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Button2();
			}
		});
		add(btn);
		
		
		setSize(1500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}

class Button2 extends JOptionPane {
	public Button2() {
		JOptionPane.showMessageDialog(null, "ㅎㅇ");
	}
}