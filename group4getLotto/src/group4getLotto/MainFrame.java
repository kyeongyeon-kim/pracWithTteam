
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

class MyToggleButton extends JToggleButton {
	private boolean status = true;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}

public class MainFrame extends JFrame implements ActionListener {
	private Random random = new Random();
	private JPanel contentPane;
	private Set<Integer> inputNumSet1 = new HashSet<>();
	private List<Integer> inputNumList1;
	private MyToggleButton[] lottoNums = new MyToggleButton[45];
	private JLabel[][] inputLabels = new JLabel[5][6];
	private JLabel[] statusLabels = new JLabel[5];
	private List[] resultArr = new ArrayList[5];
	private int fullRow = 0;
	private int autoCount = 0;
	private int manualCount = 0;
	private boolean modifying = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel left = new JPanel();
		left.setBounds(12, 10, 346, 541);
		contentPane.add(left);
		left.setLayout(null);

		GridLayout g = new GridLayout(9, 5);
		JPanel BtnPanel = new JPanel();
		BtnPanel.setLayout(g);
		BtnPanel.setBounds(12, 66, 322, 334);
		left.add(BtnPanel);

		// 확인버튼
		JButton select = new JButton("확인");
		select.setBounds(246, 410, 88, 32);
		left.add(select);
		confirmButton(select);

		// 토글버튼 45개 만들어서 생성하고 버튼 패널에 add하고 GridLayout 사용해서 정리하고 출력
		for (int i = 0; i < 45; i++) {
			lottoNums[i] = new MyToggleButton();
			lottoNums[i].setText(String.valueOf(i + 1));
			BtnPanel.add(lottoNums[i]);
			lottoNums[i].addActionListener(this);
		}

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(12, 452, 322, 79);
		left.add(panel_5);

		JLabel rule = new JLabel("대충 사용법 설명서(필요없을지도?)");
		panel_5.add(rule);

		JPanel right = new JPanel();
		right.setBounds(370, 10, 502, 541);
		contentPane.add(right);
		right.setLayout(null);

		// 자동, 반자동 구현
		JButton randombtn = new JButton("자동");
		autoButton(randombtn);

		randombtn.setBounds(146, 410, 88, 32);
		left.add(randombtn);

		JButton result = new JButton("구매 하기 !");
		result.setBounds(199, 455, 100, 40);
		right.add(result);
		resultButton(result);

		JPanel labelPanel = new JPanel();
		labelPanel.setBounds(65, 122, 349, 297);
		right.add(labelPanel);
		labelPanel.setLayout(new GridLayout(0, 6, 0, 0));
		for (int i = 0; i < inputLabels.length; i++) {
			for (int j = 0; j < inputLabels[i].length; j++) {
				inputLabels[i][j] = new JLabel("0");
				labelPanel.add(inputLabels[i][j]);
			}
		}

		// 자동 반자동 상태 입력하는거
		JPanel AutoOr = new JPanel();
		AutoOr.setBounds(12, 122, 47, 297);
		right.add(AutoOr);
		AutoOr.setLayout(new GridLayout(0, 1, 0, 0));
		for (int i = 0; i < statusLabels.length; i++) {
			statusLabels[i] = new JLabel("상태");
			AutoOr.add(statusLabels[i]);
		}

		JPanel changeRemovePanel = new JPanel();
		changeRemovePanel.setBounds(420, 122, 70, 297);
		right.add(changeRemovePanel);
		changeRemovePanel.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel changePanel = new JPanel();
		changeRemovePanel.add(changePanel);
		changePanel.setLayout(new GridLayout(0, 1, 0, 0));

		JButton[] changeBtn = new JButton[5];
		for (int i = 0; i < 5; i++) {
			changeBtn[i] = new JButton("ch");
			changePanel.add(changeBtn[i]);

			changeBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					inputNumSet1.clear();
					AbstractButton abstractButton = (AbstractButton) e.getSource();
					boolean selected = abstractButton.getModel().isSelected();
					for (int i = 0; i < lottoNums.length; i++) {
						if (!lottoNums[i].isStatus()) {
							lottoNums[i].setSelected(selected);
							lottoNums[i].setStatus(true);
						}
					}
					try {
						if (changeBtn[0] == e.getSource()) {
							fullRow = 0;
							int labelStr = 0;
							for (int j = 0; j <= inputLabels.length; j++) {
								// 출력 라벨에 있는 텍스트 인트형으로 변환해서 버튼 언셀렉
								labelStr = Integer.parseInt(inputLabels[fullRow][j].getText());
								lottoNums[labelStr - 1].setSelected(!selected);
								inputNumSet1.add(labelStr);
								lottoNums[labelStr - 1].setStatus(false);
							}

						} else if (changeBtn[1] == e.getSource()) {
							fullRow = 1;
							int labelStr = 0;
							for (int j = 0; j <= inputLabels.length; j++) {
								// 출력 라벨에 있는 텍스트 인트형으로 변환해서 버튼 언셀렉
								labelStr = Integer.parseInt(inputLabels[fullRow][j].getText());
								lottoNums[labelStr - 1].setSelected(!selected);
								inputNumSet1.add(labelStr);
								lottoNums[labelStr - 1].setStatus(false);
							}
						} else if (changeBtn[2] == e.getSource()) {
							fullRow = 2;
							int labelStr = 0;
							for (int j = 0; j <= inputLabels.length; j++) {
								// 출력 라벨에 있는 텍스트 인트형으로 변환해서 버튼 언셀렉
								labelStr = Integer.parseInt(inputLabels[fullRow][j].getText());
								lottoNums[labelStr - 1].setSelected(!selected);
								inputNumSet1.add(labelStr);
								lottoNums[labelStr - 1].setStatus(false);
							}
						} else if (changeBtn[3] == e.getSource()) {
							fullRow = 3;
							int labelStr = 0;
							for (int j = 0; j <= inputLabels.length; j++) {
								// 출력 라벨에 있는 텍스트 인트형으로 변환해서 버튼 언셀렉
								labelStr = Integer.parseInt(inputLabels[fullRow][j].getText());
								lottoNums[labelStr - 1].setSelected(!selected);
								inputNumSet1.add(labelStr);
								lottoNums[labelStr - 1].setStatus(false);
							}
						} else if (changeBtn[4] == e.getSource()) {
							fullRow = 4;
							int labelStr = 0;
							for (int j = 0; j <= inputLabels.length; j++) {
								// 출력 라벨에 있는 텍스트 인트형으로 변환해서 버튼 언셀렉
								labelStr = Integer.parseInt(inputLabels[fullRow][j].getText());
								lottoNums[labelStr - 1].setSelected(!selected);
								inputNumSet1.add(labelStr);
								lottoNums[labelStr - 1].setStatus(false);
							}
						}
					} catch (ArrayIndexOutOfBoundsException e2) {
						JOptionPane.showMessageDialog(null, "해당 줄에 입력된 번호가 없습니다.");
					}
					modifying = true;
					autoCount = 0;
					manualCount = 0;
				}
			});
		}

		JPanel removePanel = new JPanel();
		changeRemovePanel.add(removePanel);
		removePanel.setLayout(new GridLayout(0, 1, 0, 0));

		JButton[] removeBtn = new JButton[5];
		for (int i = 0; i < 5; i++) {
			removeBtn[i] = new JButton("re");
			removePanel.add(removeBtn[i]);

			removeBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AbstractButton abstractButton = (AbstractButton) e.getSource();
					boolean selected = abstractButton.getModel().isSelected();
					if (removeBtn[0] == e.getSource()) {
						for (int j = 0; j <= inputLabels.length; j++) {
							inputLabels[0][j].setText("0");
							statusLabels[0].setText("상태");
						}
					} else if (removeBtn[1] == e.getSource()) {
						for (int j = 0; j <= inputLabels.length; j++) {
							inputLabels[1][j].setText("0");
							statusLabels[1].setText("상태");
						}
					} else if (removeBtn[2] == e.getSource()) {
						for (int j = 0; j <= inputLabels.length; j++) {
							inputLabels[2][j].setText("0");
							statusLabels[2].setText("상태");
						}
					} else if (removeBtn[3] == e.getSource()) {
						for (int j = 0; j <= inputLabels.length; j++) {
							inputLabels[3][j].setText("0");
							statusLabels[3].setText("상태");
						}
					} else if (removeBtn[4] == e.getSource()) {
						for (int j = 0; j <= inputLabels.length; j++) {
							inputLabels[4][j].setText("0");
							statusLabels[4].setText("상태");
						}
					}
					for (int i = 0; i < lottoNums.length; i++) {
						lottoNums[i].setSelected(selected);
						lottoNums[i].setStatus(true);
					}
					modifying = false;
					inputNumList1.clear();
					inputNumSet1.clear();
					autoCount = 0;
					manualCount = 0;
					fullRow = 0;
				}
			});
		}

	}

	public void resultButton(JButton result) {
		result.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int labelStr = 0;
				for (int i = 0; i < inputLabels.length; i++) {
					List<Integer> list = new ArrayList<>();
					for (int j = 0; j < inputLabels[i].length; j++) {
						labelStr = Integer.parseInt(inputLabels[i][j].getText());
						list.add(labelStr);
					}
					resultArr[i] = new ArrayList<>(list);
					System.out.println(resultArr[i]);
				}
//             다이얼 로그 호출하기
				JOptionPane.showMessageDialog(null, "강사님 임시 결과창입니다~ 참고바랍니다~!");
				// 결과창에 선택된 번호값 넘겨주는 방법
//            Money frame = new Money(resultArr[0], resultArr[1], resultArr[2], resultArr[3], resultArr[4], resultArr[5]);
//            frame.setLocationRelativeTo(null);
//            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            frame.setSize(400, 565);
//            frame.setVisible(true);
			}
		});
	}

	public void autoButton(JButton randombtn) {
		randombtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if (command.equals("자동")) {
					if (isAllRowFull(statusLabels) == 5 && !modifying) {
						JOptionPane.showMessageDialog(null, "모든번호가 다 선택되었습니다.");
						inputNumList1.clear();
						inputNumSet1.clear();
					} else if (inputNumSet1.size() == 6) {
						JOptionPane.showMessageDialog(null, "모든번호가 다 선택되었습니다.");
					} else {
						if (inputNumSet1.size() == 0) {
							while (inputNumSet1.size() < 6) {
								int randomNum = random.nextInt(44) + 1;
								inputNumSet1.add(randomNum + 1);
							}
							autoCount = 0;
							inputNumList1 = new ArrayList<>(inputNumSet1);
							Collections.sort(inputNumList1);
							for (int i = 0; i < inputNumList1.size(); i++) {
								int num = inputNumList1.get(i) - 1;
								lottoNums[num].setSelected(!selected);
								lottoNums[num].setStatus(false);
								autoCount++;
							}
						} else if (inputNumList1.size() < 6) {
							while (inputNumSet1.size() < 6) {
								int randomNum = random.nextInt(44) + 1;
								inputNumSet1.add(randomNum + 1);
								autoCount++;
							}
							inputNumList1 = new ArrayList<>(inputNumSet1);
							Collections.sort(inputNumList1);
							for (int i = 0; i < inputNumList1.size(); i++) {
								int num = inputNumList1.get(i) - 1;
								lottoNums[num].setSelected(!selected);
								lottoNums[num].setStatus(false);

							}
						}
					}
				}
			}
		});
	}

	public void confirmButton(JButton select) {
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if (!modifying) {
					fullRow = dicisionRowNum(statusLabels);
				}
				if (isAllRowFull(statusLabels) == 5 && !modifying) {
					JOptionPane.showMessageDialog(null, "모든번호가 다 선택되었습니다.");
				} else {
					try {
						inputNumList1 = new ArrayList<>(inputNumSet1);
						Collections.sort(inputNumList1);
						if (inputNumList1.size() == 6) {
							if (command.equals("확인")) {
								for (int i = 0; i < lottoNums.length; i++) {
									lottoNums[i].setSelected(selected);
									lottoNums[i].setStatus(true);
								}
								for (int i = 0; i < inputLabels[fullRow].length; i++) {
									String str = String.valueOf(inputNumList1.get(i));
									inputLabels[fullRow][i].setText(str);
								}
								// 자동,수동,반자동 여부 결정
								if (manualCount == 6 && autoCount == 0) {
									statusLabels[fullRow].setText("수동");
								} else if (autoCount == 6 && manualCount == 0) {
									statusLabels[fullRow].setText("자동");
								} else {
									statusLabels[fullRow].setText("반자동");
								}
								if (inputNumSet1.size() == 6) {
									modifying = false;
								} else {
									fullRow = 0;
									autoCount = 0;
									manualCount = 0;
								}
								inputNumList1.clear();
								inputNumSet1.clear();
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
				
			}
		});
	}

	// 수동 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		Object check = e.getSource();
		AbstractButton abstractButton = (AbstractButton) e.getSource();
		boolean selected = abstractButton.getModel().isSelected();
		if (isAllRowFull(statusLabels) == 5 && !modifying) {
			JOptionPane.showMessageDialog(null, "모든번호가 선택되었습니다.");
			for (int i = 0; i < lottoNums.length; i++) {
				if (check == lottoNums[i]) {
					lottoNums[i].setSelected(!selected);
					break;
				}
			}
		} else {
			for (int i = 0; i < lottoNums.length; i++) {
				if (check == lottoNums[i]) {
					if (lottoNums[i].isStatus()) {
						inputNumSet1.add(Integer.parseInt(lottoNums[i].getText()));
						lottoNums[i].setStatus(false);
						manualCount++;
						if (inputNumSet1.size() > 6 && !modifying) {
							JOptionPane.showMessageDialog(null, "6자리 이상은 입력할 수 없습니다.");
							inputNumSet1.remove(Integer.parseInt(lottoNums[i].getText()));
							lottoNums[i].setSelected(!selected);
							lottoNums[i].setStatus(true);
							manualCount--;
							break;
						} else if (inputNumSet1.size() > 6 && modifying) {
							JOptionPane.showMessageDialog(null, "6자리 이상은 입력할 수 없습니다.");
							inputNumSet1.remove(Integer.parseInt(lottoNums[i].getText()));
							lottoNums[i].setSelected(!selected);
							lottoNums[i].setStatus(true);
							manualCount--;
						}
					} else if (!lottoNums[i].isStatus()) {
						lottoNums[i].setStatus(true);
						inputNumSet1.remove(Integer.parseInt(lottoNums[i].getText()));
						manualCount--;
					}
				}
			}
		}
		if (manualCount < 0) {
			manualCount = 0;
		}
	}

	public static int falseCount(MyToggleButton[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i].isStatus()) {
				count++;
			}
		}
		return count;
	}

	// 상태값을 통해 비어있는 행에 도착할 수 있도록 해주는 메소드
	public static int dicisionRowNum(JLabel[] Labels) {
		int count = 0;
		for (int i = 0; i < Labels.length; i++) {
			if (!Labels[i].getText().equals("상태")) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}

	// 상태값을 통해 비어있는 행이 몇개인지 알려주는 메소드
	public static int isAllRowFull(JLabel[] Labels) {
		int count = 0;
		for (int i = 0; i < Labels.length; i++) {
			if (!Labels[i].getText().equals("상태")) {
				count++;
			}
		}
		return count;
	}
}