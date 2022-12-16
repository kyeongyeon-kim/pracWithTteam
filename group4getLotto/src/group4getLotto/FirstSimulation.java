import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

class FirstSimulationData {
	private int bonusNumber; // 보너스 당첨 번호
	private int[] intList; // 당첨 번호
	private int[] number = new int[5];
	private int numberFirst; // 1등 반복 회차
	private int numberSecond; // 2등 반복 회차
	private int numberThird; // 3등 반복 회차
	private int numberFourth; // 4등 반복 회차
	private int numberFifth; // 5등 반복 회차
	
	
	public FirstSimulationData(int[][] firstList) {
		numberFirst = 0;
		numberSecond = 0;
		numberThird = 0;
		numberFourth = 0;
		numberFifth = 0;
		
		int count = 0; // 1등 여부
		boolean sw = false;
		for (int i = 0; i < 5; i++) {
			if (firstList[i][0] != 0) {
				sw = true;
			}
		}
		long money = 0;
		while (count != 6 && sw) {
			LottoNumber();
			numberFirst++;
			for (int i = 0; i < 5; i++) {
				count = 0;
				for (int j = 0; j < 6; j++) {
					for (int g = 0; g < 6; g++) {
						if (firstList[i][j] == intList[g]){
							count++;
						}
					}
				}
				if (firstList[i][0] != 0) {
					money += 1000;
				}
				switch (count) {
				case 3:
					numberFifth++;
					break;
				case 4:
					numberFourth++;
					break;
				case 5:
					for (int p = 0; p < 6; p++) {
						if (firstList[i][p] == bonusNumber) {
							numberSecond++;
						} else {
							numberThird++;
						}
					}
					break;
				default:
					break;
				}
				if (count == 6) {
					Arrays.sort(intList);
					number[0] = numberFirst;
					number[1] = numberSecond;
					number[2] = numberThird;
					number[3] = numberFourth;
					number[4] = numberFifth;
					new FirstSimulation(number, intList, bonusNumber, money);
					break;
				}
			}
		}
	}
	
	public void LottoNumber() {
		Random random = new Random();
		int num;
		intList = new int[6];
		
		for (int j = 0; j < 6; j++) {
			num = random.nextInt(45) + 1;
			boolean sw = true;
			for (int i = 0; i < 6; i++) {
				if (intList[i] == num) {
					sw = false;
				}
			}
			if (sw) {
				intList[j] = num;
			} else {
				j--;
			}
		}
		
		bonusNumber = 0;
		while (true) {
			num = random.nextInt(45) + 1;
			
			boolean sw = true;
			for (int i = 0; i < 6; i++) {
				if (intList[i] == num) {
					sw = false;
				}
			}
			if (sw) {
				bonusNumber = num;
			}
			if (bonusNumber > 0) {
				break;
			}
			
		}
	}
	
}

public class FirstSimulation extends JDialog {
	public FirstSimulation(int[] number, int[] intList, int bonusNumber, long money) {
		setModal(true);
		setLayout(null);
		
		JButton btn = new JButton("확인");
		btn.setBounds(160, 340, 70, 30);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(btn);
		
		JLabel lblEnd = new JLabel("당첨 번호                     Bonus");
		lblEnd.setBounds(130, 10, 200, 30);
		add(lblEnd);
		
		
		
		DecimalFormat df = new DecimalFormat("###,###");
		String str_;
		
		JLabel[] lblList = new JLabel[7];
		for (int i = 0; i < 7; i++) {
			if (i < 6) {
				str_ = df.format(intList[i]);
				lblList[i] = new JLabel(str_);
				lblList[i].setBounds(i * 25 + 90, 40, 30, 30);
			} else if (i == 6) {
				str_ = df.format(bonusNumber);
				lblList[i] = new JLabel(str_);
				lblList[i].setBounds(i * 25 + 110, 40, 30, 30);
			}
			add(lblList[i]);
		}
		
		JLabel[] lblNumber = new JLabel[5];
		str_ = df.format(number[0]);
		lblNumber[0] = new JLabel("1등 당첨이 된 회차: " + str_);
		lblNumber[0].setBounds(100, 80, 190, 30);
		add(lblNumber[0]);
		
		str_ = df.format(money);
		JLabel lblMoney = new JLabel("사용 비용: " + str_);
		lblMoney.setBounds(20, 110, 200, 30);
		add(lblMoney);
		
		long money_ = 1600000000 + ((long) 66000000 * number[1])
				+ ((long) 1500000 * number[2])
				+ ((long) 50000 * number[3])
				+ ((long) 5000 * number[4])
				;
		
		str_ = df.format(money_);
		JLabel lblMoney_ = new JLabel("당첨금: " + str_);
		lblMoney_.setBounds(200, 110, 200, 30);
		add(lblMoney_);
		
		str_ = df.format(money_ - money);
		JLabel lblMoney__ = new JLabel("손익: " + str_);
		lblMoney__.setBounds(130, 130, 200, 30);
		add(lblMoney__);
		
		for (int i = 1; i < 5; i++) {
			str_ = df.format(number[i]);
			lblNumber[i] = new JLabel((i + 1) +"등 당첨이 된 횟수: " + str_);
			lblNumber[i].setBounds(110, i * 30 + 160, 200, 30);
			add(lblNumber[i]);
			
		}
		
		JPanel pnl = new JPanel();
		JLabel lblPnl = new JLabel();
		pnl.add(lblPnl);
		lblPnl.setIcon(new ImageIcon(FirstSimulation.class.getResource("firstBackGround.png")));
		pnl.setBounds(0, 0, 400, 440);
		add(pnl);
		
		setLocationRelativeTo(null);
		setSize(400, 440);
		setVisible(true);
	}
	
}
