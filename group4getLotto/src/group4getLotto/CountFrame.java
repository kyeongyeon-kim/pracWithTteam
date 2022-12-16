import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

class SaveData {
	private int bonusNumber;
	private int[] mainNumber = new int[6];
	private int[][] inputNumber = new int[5][6];
	private int money;
	
	public int getBonusNumber() {
		return bonusNumber;
	}
	public void setBonusNumber(int bonusNumber) {
		this.bonusNumber = bonusNumber;
	}
	public int[] getMainNumber() {
		return mainNumber;
	}
	public void setMainNumber(int[] mainNumber) {
		this.mainNumber = mainNumber;
	}
	public int[][] getInputNumber() {
		return inputNumber;
	}
	public void setInputNumber(int[][] inputNumber) {
		this.inputNumber = inputNumber;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
}

public class CountFrame extends JDialog {
	private JLabel[] lbl;
	private JLabel[][] lbl_;
	private JLabel[] lbl__;

	public CountFrame(List<SaveData> saveDataList, int countMoney){
		setModal(true);
		setLayout(null);
		
		JLabel tfLbl = new JLabel("조회할 회차");
		JTextField tf = new JTextField(5);
		JButton btn = new JButton("조회");
		
		tfLbl.setBounds(30, 120, 150, 30);
		tf.setBounds(30, 155, 70, 30);
		btn.setBounds(100, 155, 70, 30);
		add(tfLbl);
		add(tf);
		add(btn);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int tfNum = 0;
				try {
					tfNum = Integer.valueOf(tf.getText());
				} catch (Exception arg0) {
				}
				if (tfNum > 0 && tfNum <= saveDataList.size()) {
					for (int i = 0; i < 7; i++) {
						if (i < 6) {
							lbl[i].setText(String.valueOf(saveDataList.get(tfNum - 1).getMainNumber()[i]));
						} else {
							lbl[6].setText(String.valueOf(saveDataList.get(tfNum - 1).getBonusNumber()));
						}
					}
					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 6; j++) {
//							if ((int) saveDataList.get(tfNum - 1).getInputNumber()[i][j] != 0) {
								lbl_[i][j].setText(String.valueOf(saveDataList.get(tfNum - 1).getInputNumber()[i][j]));
//							} else {
//								lbl_[i][j].setText("");
//							}
						}
					}
					
				}
			}
		});
		
		// 당첨 번호 라벨
		lbl = new JLabel[7];
		for (int i = 0; i < 7; i++) {
			lbl[i] = new JLabel();
			if (i < 6) {
				lbl[i].setText(String.valueOf(saveDataList.get(0).getMainNumber()[i]));
			} else {
				lbl[6].setText(String.valueOf(saveDataList.get(0).getBonusNumber()));
			}
			int bonus = 0;
			if (i == 6) {
				bonus = 20;
			}
			lbl[i].setBounds(i * 30 + 327 + bonus, 28, 30, 30);
			add(lbl[i]);
		}
		
		// 입력 번호 라벨
		lbl_ = new JLabel[5][6];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				lbl_[i][j] = new JLabel("0");
				lbl_[i][j].setBounds(j * 40 + 330, i * 40 + 110, 30, 30);
				add(lbl_[i][j]);
			}
		}
		
		// 당첨금, 사용 금액, 손익
		lbl__ = new JLabel[3];
		JLabel[] lbl___ = new JLabel[5];
		lbl___[0] = new JLabel("당첨금");
		lbl___[1] = new JLabel("사용금액");
		lbl___[2] = new JLabel("손익");
		lbl___[3] = new JLabel("당첨 번호");
		lbl___[4] = new JLabel("입력 번호");
		for (int i = 0; i < 3; i++) {
			lbl__[i] = new JLabel();
			add(lbl__[i]);
			add(lbl___[i]);
		}
		for (int i = 0; i < 5; i++) {
			add(lbl___[i]);
		}
		lbl___[0].setBounds(41, 2, 70, 30);
		lbl___[1].setBounds(123, 2, 70, 30);
		lbl___[2].setBounds(222, 2, 70, 30);
		lbl___[3].setBounds(407, 2, 70, 30);
		lbl___[4].setBounds(407, 73, 70, 30);
		lbl__[0].setBounds(20, 12, 95, 60);
		if (countMoney >= 0) {
			lbl__[1].setBounds(118, 12, 95, 60);
		} else if (countMoney < 0){
			lbl__[1].setBounds(120, 12, 95, 60);
		}
		lbl__[2].setBounds(195, 12, 95, 60);
		int sum = 0;
		for (int i = 0; i < saveDataList.size(); i++) {
			sum += saveDataList.get(i).getMoney();
		}
		lbl__[0].setText(String.valueOf(sum));
		lbl__[1].setText(String.valueOf(countMoney * 1000));
		lbl__[2].setText(String.valueOf(sum - countMoney * 1000));
		
		JButton btnEnd = new JButton("확인");
		btnEnd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnEnd.setBounds(265, 330, 70, 40);
		add(btnEnd);
		
		JPanel pnl = new JPanel();
		JLabel lnlBackGround = new JLabel();
		lnlBackGround.setIcon(new ImageIcon(CountFrame.class.getResource("/countBackGround.png")));
		pnl.add(lnlBackGround);
		pnl.setBounds(0, 0, 600, 430);
		add(pnl);
		
		setSize(600, 430);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
}
