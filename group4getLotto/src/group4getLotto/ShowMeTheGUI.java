package prac;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class MyToggleButton extends JToggleButton {
	private boolean status = true;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	} 
	
}
public class ShowMeTheGUI extends JFrame implements ActionListener{
	private JPanel contentPane;
	private Set<Integer> inputNumSet1 = new HashSet<>();
	private List<Integer> inputNumList1;
	private MyToggleButton[] lottoNums = new MyToggleButton[45];
	private JLabel[][] inputLabels = new JLabel[5][6];
	private int emptyRow = 0;
	private List<List> lists = new ArrayList<>();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowMeTheGUI frame = new ShowMeTheGUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ShowMeTheGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 346, 541);
		contentPane.add(panel);
		panel.setLayout(null);
		
		GridLayout g = new GridLayout(9, 5);
		JPanel BtnPanel = new JPanel();
		BtnPanel.setLayout(g);
		BtnPanel.setBounds(12, 53, 322, 365);
		panel.add(BtnPanel);
		// 토글버튼 45개 만들어서 생성하고 버튼 패널에 add하고 GridLayout 사용해서 정리하고 출력
		for(int i = 0; i < 45; i++) {
			lottoNums[i] = new MyToggleButton();
			lottoNums[i].setText(String.valueOf(i + 1));
			BtnPanel.add(lottoNums[i]);
			lottoNums[i].addActionListener(this);
		}
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(12, 428, 322, 103);
		panel.add(panel_5);
		
		JLabel rule = new JLabel("대충 사용법 설명서");
		panel_5.add(rule);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(370, 10, 502, 541);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton randombtn = new JButton("자동");
		randombtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		randombtn.setBounds(148, 480, 100, 40);
		panel_1.add(randombtn);
		
		JButton select = new JButton("확인");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				try {
					if (inputNumList1.size() == 6) {
						if (command.equals("확인")) {
							for (int i = 0; i < lottoNums.length; i++) {
								lottoNums[i].setSelected(selected);
							}
									for (int i = 0; i < inputLabels[emptyRow].length; i++) {
										String str = String.valueOf(inputNumList1.get(i));
										inputLabels[emptyRow][i].setText(str);
									}	
									emptyRow++;
									lists.add(inputNumList1);
									inputNumList1.clear();
									inputNumSet1.clear();
									for (int i = 0; i < lottoNums.length; i++) {
										lottoNums[i].setStatus(true);
									}
						}
					} else {
						JOptionPane.showMessageDialog(null, "6개를 선택해주세요.");
					}
				} catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(null, "6개를 선택해주세요.");
				} catch (ArrayIndexOutOfBoundsException exception) {
					JOptionPane.showMessageDialog(null, "모든번호가 다 선택되었습니다.");
					inputNumList1.clear();
					inputNumSet1.clear();
				}
			}
		});
		select.setBounds(260, 480, 100, 40);
		panel_1.add(select);
		
		JLabel lblNewLabel_5 = new JLabel("뭐 제목 같은거");
		lblNewLabel_5.setBounds(211, 54, 88, 33);
		panel_1.add(lblNewLabel_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 97, 478, 334);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel labelPanel = new JPanel();
		labelPanel.setBounds(12, 10, 341, 303);
		panel_2.add(labelPanel);
		labelPanel.setLayout(new GridLayout(0, 6, 0, 0));
		for(int i = 0; i < inputLabels.length; i++) {
			for(int j = 0; j < inputLabels[i].length; j++) {
				inputLabels[i][j] = new JLabel("0");
				labelPanel.add(inputLabels[i][j]);
			}
		}
		
		
		JPanel removePanel = new JPanel();
		removePanel.setBounds(365, 10, 101, 303);
		panel_2.add(removePanel);
		removePanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNewButton = new JButton("수정");
		removePanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("초기화");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		removePanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("수정");
		removePanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("초기화");
		removePanel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("수정");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		removePanel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("초기화");
		removePanel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("수정");
		removePanel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("초기화");
		removePanel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		removePanel.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("초기화");
		removePanel.add(btnNewButton_9);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object check = e.getSource();
		AbstractButton abstractButton = (AbstractButton) e.getSource();
		boolean selected = abstractButton.getModel().isSelected();
		for(int i = 0; i < lottoNums.length; i++) {
			if(check == lottoNums[i]) {
				if(lottoNums[i].isStatus() == true) {
					inputNumSet1.add(Integer.parseInt(lottoNums[i].getText()));
					lottoNums[i].setStatus(false);
					
					if(inputNumSet1.size() > 6) {
						JOptionPane.showMessageDialog(null, "6자리 이상은 입력할 수 없습니다.");
						inputNumSet1.remove(Integer.parseInt(lottoNums[i].getText()));
						lottoNums[i].setSelected(!selected);
						break;
					}	
					
				} else if(lottoNums[i].isStatus() == false) {
					lottoNums[i].setStatus(true);
					inputNumSet1.remove(Integer.parseInt(lottoNums[i].getText()));
				}
			} 
		}
		System.out.println(inputNumSet1);
		inputNumList1 = new ArrayList<>(inputNumSet1);
		Collections.sort(inputNumList1);
	}

}
