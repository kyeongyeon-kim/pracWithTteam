import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
//class MainFrame{
//	private List<SaveData> saveDataList = new ArrayList<>(); // 메인 필드에 추가
//	private int countMoney;
//	
//	public MainFrame() {
//		// 생성자
//		JButton btnNew = new JButton("이전 회차"); // + group 및 토글버튼 주석 처리
//		btnNew.setBounds(12, 69, 63, 64);;
//		main.add(btnNew);
//		btnNew.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (saveDataList.size() > 0) {
//					countFream();
//				}
//			}
//		});
//		
//		// 구매하기에 추가
//		saveDataList.add(new SaveData());
//		saveDataList.get(saveDataList.size() - 1).setBonusNumber(money.getRan().getLottoBonus());
//		saveDataList.get(saveDataList.size() - 1).setMainNumber(money.getRan().getLottoMain());
//
//		int[][] saveDataInputNumberList = new int[5][6];
//
//		for (int i = 0; i < 5; i++) {
//			boolean sw = false;
//			for (int j = 0; j < 6; j++) {
//				saveDataInputNumberList[i][j] = (int) resultArr[i].get(j);
//				if ((int) resultArr[i].get(j) != 0) {
//					sw = true;
//				}
//			}
//			if (sw) {
//				countMoney++;
//			}
//		}
//		saveDataList.get(saveDataList.size() - 1).setInputNumber(saveDataInputNumberList);
//		saveDataList.get(saveDataList.size() - 1).setMoney(money.getRan().getMoney());
//	}
//	
//	public void countFream() {
//		new CountFrame(saveDataList, countMoney);
//	}
//}
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
					JOptionPane.showMessageDialog(null, "잘못된 입력입니다. ");
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
							if ((int) saveDataList.get(tfNum - 1).getInputNumber()[i][j] != 0) {
								lbl_[i][j].setText(String.valueOf(saveDataList.get(tfNum - 1).getInputNumber()[i][j]));
							} else {
								lbl_[i][j].setText("");
							}
						}
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "잘못된 입력입니다. ");
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
			lbl[i].setBounds(i * 40 + 350, 20, 30, 30);
			add(lbl[i]);
		}
		
		// 입력 번호 라벨
		lbl_ = new JLabel[5][6];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				lbl_[i][j] = new JLabel("0");
				lbl_[i][j].setBounds(j * 40 + 350, i * 40 + 120, 30, 30);
				add(lbl_[i][j]);
			}
		}
		
		// 당첨금, 사용 금액, 손익
		lbl__ = new JLabel[3];
		JLabel[] lbl___ = new JLabel[3];
		lbl___[0] = new JLabel("당첨금");
		lbl___[1] = new JLabel("사용 금액");
		lbl___[2] = new JLabel("손익");
		for (int i = 0; i < 3; i++) {
			lbl__[i] = new JLabel();
			lbl___[i].setBounds(i * 100 + 30, 20, 90, 30);
			lbl__[i].setBounds(i * 100 + 30, 40, 90, 30);
			add(lbl__[i]);
			add(lbl___[i]);
		}
		int sum = 0;
		for (int i = 0; i < saveDataList.size(); i++) {
			sum += saveDataList.get(i).getMoney();
		}
		lbl__[0].setText(String.valueOf(sum));
		lbl__[1].setText(String.valueOf(countMoney * 1000));
		lbl__[2].setText(String.valueOf(sum - countMoney * 1000));
		
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
}
