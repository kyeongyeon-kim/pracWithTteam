package group4getLotto;




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
		
		JLabel rule = new JLabel("대충 사용법 설명서(필요없을지도?)");
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
		
		
		JPanel chabgeRemovePanel = new JPanel();
		chabgeRemovePanel.setBounds(365, 10, 101, 303);
		panel_2.add(chabgeRemovePanel);
		chabgeRemovePanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel changePanel = new JPanel();
		chabgeRemovePanel.add(changePanel);
		changePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton[] changeBtn = new JButton[5];
		for(int i = 0; i < 5; i++) {
			changeBtn[i] = new JButton("ch");
			changePanel.add(changeBtn[i]);
			
			changeBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AbstractButton abstractButton = (AbstractButton) e.getSource();
					boolean selected = abstractButton.getModel().isSelected();
					if(changeBtn[0] == e.getSource()) {
						emptyRow = 0;
						int labelStr = 0;
						for(int j = 0; j <= inputLabels.length; j++) {
							 // 출력 라벨에 있는 텍스트 인트형으로 변환해서 버튼 언셀렉
							labelStr = Integer.parseInt(inputLabels[emptyRow][j].getText());
							lottoNums[labelStr - 1].setSelected(!selected);
							inputNumSet1.add(labelStr);
							lottoNums[labelStr - 1].setStatus(false);
						}
						
					} else if(changeBtn[1] == e.getSource()) {
						emptyRow = 1;
						int labelStr = 0;
						for(int j = 0; j <= inputLabels.length; j++) {
							 // 출력 라벨에 있는 텍스트 인트형으로 변환해서 버튼 언셀렉
							labelStr = Integer.parseInt(inputLabels[emptyRow][j].getText());
							lottoNums[labelStr - 1].setSelected(!selected);
							inputNumSet1.add(labelStr);
							lottoNums[labelStr - 1].setStatus(false);
						}
					} else if(changeBtn[2] == e.getSource()) {
						emptyRow = 2;
						int labelStr = 0;
						for(int j = 0; j <= inputLabels.length; j++) {
							 // 출력 라벨에 있는 텍스트 인트형으로 변환해서 버튼 언셀렉
							labelStr = Integer.parseInt(inputLabels[emptyRow][j].getText());
							lottoNums[labelStr - 1].setSelected(!selected);
							inputNumSet1.add(labelStr);
							lottoNums[labelStr - 1].setStatus(false);
						}
					} else if(changeBtn[3] == e.getSource()) {
						emptyRow = 3;
						int labelStr = 0;
						for(int j = 0; j <= inputLabels.length; j++) {
							 // 출력 라벨에 있는 텍스트 인트형으로 변환해서 버튼 언셀렉
							labelStr = Integer.parseInt(inputLabels[emptyRow][j].getText());
							lottoNums[labelStr - 1].setSelected(!selected);
							inputNumSet1.add(labelStr);
							lottoNums[labelStr - 1].setStatus(false);
						}
					} else if(changeBtn[4] == e.getSource()) {
						emptyRow = 4;
						int labelStr = 0;
						for(int j = 0; j <= inputLabels.length; j++) {
							 // 출력 라벨에 있는 텍스트 인트형으로 변환해서 버튼 언셀렉
							labelStr = Integer.parseInt(inputLabels[emptyRow][j].getText());
							lottoNums[labelStr - 1].setSelected(!selected);
							inputNumSet1.add(labelStr);
							lottoNums[labelStr - 1].setStatus(false);
						}
					}
				}
			});
		}
		
		JPanel removePanel = new JPanel();
		chabgeRemovePanel.add(removePanel);
		removePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton[] removeBtn = new JButton[5];
		for(int i = 0; i < 5; i++) {
			removeBtn[i] = new JButton("re");
			removePanel.add(removeBtn[i]);
			
			removeBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(removeBtn[0] == e.getSource()) {
						for(int j = 0; j <= inputLabels.length; j++) {
							inputLabels[0][j].setText("0");
						}
					} else if(removeBtn[1] == e.getSource()) {
						for(int j = 0; j <= inputLabels.length; j++) {
							inputLabels[1][j].setText("0");
						}
					} else if(removeBtn[2] == e.getSource()) {
						for(int j = 0; j <= inputLabels.length; j++) {
							inputLabels[2][j].setText("0");
						}
					} else if(removeBtn[3] == e.getSource()) {
						for(int j = 0; j <= inputLabels.length; j++) {
							inputLabels[3][j].setText("0");
						}
					} else if(removeBtn[4] == e.getSource()) {
						for(int j = 0; j <= inputLabels.length; j++) {
							inputLabels[4][j].setText("0");
						}
					}
				}
			});
		}
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
