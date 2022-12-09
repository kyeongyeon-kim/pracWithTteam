package group4getLotto;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class DialogPrac extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogPrac frame = new DialogPrac();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DialogPrac() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel resultLabel = new JLabel("당첨 결과 창");
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultLabel.setBounds(165, 10, 111, 38);
		contentPane.add(resultLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(23, 106, 386, 52);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 7, 0, 0));
		
		JLabel showResult = new JLabel("결과");
		showResult.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(showResult);
		
		JLabel num1 = new JLabel("num1");
		num1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(num1);
		
		JLabel num2 = new JLabel("num2");
		num2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(num2);
		
		JLabel num3 = new JLabel("num3");
		num3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(num3);
		
		JLabel num4 = new JLabel("num4");
		num4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(num4);
		
		JLabel num5 = new JLabel("num5");
		num5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(num5);
		
		JLabel num6 = new JLabel("num6");
		num6.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(num6);
		
		JButton close = new JButton("닫기");
		close.setBounds(165, 428, 97, 23);
		contentPane.add(close);
		
		JLabel lblNewLabel = new JLabel("당첨 번호 보여주기");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(69, 58, 291, 38);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(23, 161, 386, 52);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 7, 0, 0));
		
		JLabel showResult_1 = new JLabel("결과");
		showResult_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(showResult_1);
		
		JLabel num1_1 = new JLabel("num1");
		num1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(num1_1);
		
		JLabel num2_1 = new JLabel("num2");
		num2_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(num2_1);
		
		JLabel num3_1 = new JLabel("num3");
		num3_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(num3_1);
		
		JLabel num4_1 = new JLabel("num4");
		num4_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(num4_1);
		
		JLabel num5_1 = new JLabel("num5");
		num5_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(num5_1);
		
		JLabel num6_1 = new JLabel("num6");
		num6_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(num6_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(23, 216, 386, 52);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 7, 0, 0));
		
		JLabel showResult_2 = new JLabel("결과");
		showResult_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(showResult_2);
		
		JLabel num1_2 = new JLabel("num1");
		num1_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(num1_2);
		
		JLabel num2_2 = new JLabel("num2");
		num2_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(num2_2);
		
		JLabel num3_2 = new JLabel("num3");
		num3_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(num3_2);
		
		JLabel num4_2 = new JLabel("num4");
		num4_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(num4_2);
		
		JLabel num5_2 = new JLabel("num5");
		num5_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(num5_2);
		
		JLabel num6_2 = new JLabel("num6");
		num6_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(num6_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(23, 273, 386, 52);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 7, 0, 0));
		
		JLabel showResult_3 = new JLabel("결과");
		showResult_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(showResult_3);
		
		JLabel num1_3 = new JLabel("num1");
		num1_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(num1_3);
		
		JLabel num2_3 = new JLabel("num2");
		num2_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(num2_3);
		
		JLabel num3_3 = new JLabel("num3");
		num3_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(num3_3);
		
		JLabel num4_3 = new JLabel("num4");
		num4_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(num4_3);
		
		JLabel num5_3 = new JLabel("num5");
		num5_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(num5_3);
		
		JLabel num6_3 = new JLabel("num6");
		num6_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(num6_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(23, 330, 386, 52);
		contentPane.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 7, 0, 0));
		
		JLabel showResult_4 = new JLabel("결과");
		showResult_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(showResult_4);
		
		JLabel num1_4 = new JLabel("num1");
		num1_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(num1_4);
		
		JLabel num2_4 = new JLabel("num2");
		num2_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(num2_4);
		
		JLabel num3_4 = new JLabel("num3");
		num3_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(num3_4);
		
		JLabel num4_4 = new JLabel("num4");
		num4_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(num4_4);
		
		JLabel num5_4 = new JLabel("num5");
		num5_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(num5_4);
		
		JLabel num6_4 = new JLabel("num6");
		num6_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(num6_4);
	}
}
