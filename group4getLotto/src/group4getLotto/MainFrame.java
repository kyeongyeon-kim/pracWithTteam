
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

class MyToggleButton extends JToggleButton {
	private boolean status = true;

	public MyToggleButton(ImageIcon convertToNumber) {
		setIcon(convertToNumber);
	}

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
	private ClassLoader classLoader;
	private Image image;
	private ImageIcon icon;
	private Image img;
	private JButton randombtn;

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

	// 이미지 넣기 메소드
	public ImageIcon convertToNumber(String name, int width, int height) {
		String imageName = name;
		Toolkit kit = Toolkit.getDefaultToolkit();
		classLoader = getClass().getClassLoader();
		image = kit.getImage(classLoader.getResource(imageName));
		image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		icon = new ImageIcon(image);
		return icon;
	}

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 690);

		// 백그라운드 이미지
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("100.png");

		contentPane = new JPanel() {
			@Override
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, this);
				setOpaque(false);
				super.paint(g);
			}
		};

		contentPane.setBackground(new Color(255, 0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 왼쪽 패널
		JPanel left = new JPanel();
		left.setBounds(12, 10, 346, 541);
		contentPane.add(left);
		left.setLayout(null);
		left.setOpaque(false);
		left.setBackground(new Color(255, 0, 0, 0));

		// 그리드 레이아웃
		GridLayout g = new GridLayout(9, 5, 10, 10);

		// 버튼 패널
		JPanel BtnPanel = new JPanel();
		BtnPanel.setLayout(g);
		BtnPanel.setBounds(12, 134, 322, 334);
		BtnPanel.setOpaque(false);
		left.add(BtnPanel);

		// 확인버튼
		JButton select = new JButton("확인");
		select.setBounds(201, 478, 88, 32);
		left.add(select);
		select.setBackground(new Color(255, 0, 0, 0));
		select.setOpaque(false);
		select.setBorderPainted(false);
		confirmButton(select);

		// 토글버튼 45개 만들어서 생성하고 버튼 패널에 add하고 GridLayout 사용해서 정리하고 출력
		for (int i = 0; i < 45; i++) {
			String name = "ball/" + (i + 1) + ".png";
			lottoNums[i] = new MyToggleButton(convertToNumber(name, 25, 25));
			lottoNums[i].setText(String.valueOf(i + 1));
			BtnPanel.add(lottoNums[i]);
			lottoNums[i].setForeground(Color.white);
			lottoNums[i].setBackground(new Color(255, 0, 0, 0));
			lottoNums[i].addActionListener(this);
			lottoNums[i].setOpaque(false);
			lottoNums[i].setBorderPainted(false);
		}

//      JPanel panel_5 = new JPanel();
//      panel_5.setBounds(12, 452, 322, 79);
//      left.add(panel_5);
//
//      JLabel rule = new JLabel("대충 사용법 설명서(필요없을지도?)");
//      panel_5.add(rule);

		// 오른쪽 패널
		JPanel right = new JPanel();
		right.setBounds(370, 10, 514, 541);
		contentPane.add(right);
		right.setLayout(null);
		right.setOpaque(false);

		// 자동, 반자동 구현
		JButton randombtn = new JButton("자동");
		randombtn.setOpaque(false);
		randombtn.setBorderPainted(false);
		randombtn.setBackground(new Color(255, 0, 0, 0));
		randombtn.setBounds(82, 478, 88, 32);
		left.add(randombtn);
		autoButton(randombtn);

		// 복권 이름
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(12, 10, 277, 57);
		left.add(lblNewLabel);

		// 구매 버튼
		JButton result = new JButton("구매 하기 !");
		result.setBounds(199, 455, 100, 40);
		right.add(result);
		result.setBorderPainted(false);
		resultButton(result);
		result.setBackground(new Color(255, 0, 0, 0));
		result.setOpaque(false);

		// 결과 확인창 6*5
		JPanel labelPanel = new JPanel();
		labelPanel.setBounds(135, 133, 279, 297);
		right.add(labelPanel);
		labelPanel.setOpaque(false);
		labelPanel.setLayout(new GridLayout(0, 6, 0, 0));
		for (int i = 0; i < inputLabels.length; i++) {
			for (int j = 0; j < inputLabels[i].length; j++) {
				inputLabels[i][j] = new JLabel("0");
				labelPanel.add(inputLabels[i][j]);
			}
		}

		// 자동 반자동 상태 입력하는거
		JPanel AutoOr = new JPanel();
		AutoOr.setBounds(87, 133, 47, 297);
		right.add(AutoOr);
		AutoOr.setOpaque(false);
		AutoOr.setLayout(new GridLayout(0, 1, 0, 0));
		for (int i = 0; i < statusLabels.length; i++) {
			statusLabels[i] = new JLabel("상태");
			AutoOr.add(statusLabels[i]);
		}

		// 수정 패널

		JPanel changePanel = new JPanel();
		changePanel.setLayout(new GridLayout(0, 1, 0, 0));
		right.add(changePanel);
		changePanel.setOpaque(false);
		changePanel.setBounds(426, 133, 35, 297);

		// 리셋 패널
		JPanel removePanel = new JPanel();
		removePanel.setLayout(new GridLayout(0, 1, 0, 0));
		right.add(removePanel);
		removePanel.setBounds(467, 133, 35, 297);
		removePanel.setOpaque(false);

		// 수정 버튼
		JButton[] changeBtn = new JButton[5];
		for (int i = 0; i < 5; i++) {
			changeBtn[i] = new JButton(new ImageIcon("102.png"));
			changePanel.add(changeBtn[i]);
			changeBtn[i].setBackground(new Color(255, 0, 0, 0));
			changeBtn[i].setOpaque(false);
			changeBtn[i].setBorderPainted(false);
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

		// 리셋버튼
		JButton[] removeBtn = new JButton[5];
		for (int i = 0; i < 5; i++) {
			removeBtn[i] = new JButton(new ImageIcon("101.png"));
			removePanel.add(removeBtn[i]);
			removeBtn[i].setOpaque(false);
			removeBtn[i].setBorderPainted(false);
			removeBtn[i].setBackground(new Color(255, 0, 0, 0));
			removeBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AbstractButton abstractButton = (AbstractButton) e.getSource();
					boolean selected = abstractButton.getModel().isSelected();
					try {
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
					} catch (NullPointerException e2) {

					}

				}
			});
		}

	}

	public void resultButton(JButton result) {
		result.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isAllRowFull(statusLabels) == 0) {
					JOptionPane.showMessageDialog(null, "구매할 번호를 선택해 주세요.");
				} else {
					int labelStr = 0;
					for (int i = 0; i < inputLabels.length; i++) {
						List<Integer> list = new ArrayList<>();
						for (int j = 0; j < inputLabels[i].length; j++) {
							labelStr = Integer.parseInt(inputLabels[i][j].getText());
							list.add(labelStr);
						}
						resultArr[i] = new ArrayList<Integer>(list);
					}
//                다이얼 로그 호출하기
//               JOptionPane.showMessageDialog(null, "강사님 임시 결과창입니다~ 참고바랍니다~!");
//               Money frame = new Money(resultArr[0], resultArr[1], resultArr[2], resultArr[3], resultArr[4]);
//               frame.setLocationRelativeTo(null);
//               frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//               frame.setSize(1000, 700);
//               frame.setVisible(true);
//               for (int i = 0; i < inputLabels.length; i++) {
//                  statusLabels[i].setText("상태");
//                  for (int j = 0; j < inputLabels[i].length; j++) {
//                     inputLabels[i][j].setText("0");
//                  }
//               }
				}

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
						// JOptionPane.showMessageDialog(null, "모든번호가 다 선택되었습니다.");
						inputNumList1.clear();
						inputNumSet1.clear();
					} else if (inputNumSet1.size() == 6) {
						// JOptionPane.showMessageDialog(null, "모든번호가 다 선택되었습니다.2");
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
					JOptionPane.showMessageDialog(null, "1회 최대 5개만 구매할 수 있습니다.");
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
								}
								inputNumList1.clear();
								inputNumSet1.clear();
							}
						} else {
							JOptionPane.showMessageDialog(null, "번호 6개를 선택해주세요.");
						}
					} catch (NullPointerException exception) {
						JOptionPane.showMessageDialog(null, "6개를 선택해주세요.");
					} catch (ArrayIndexOutOfBoundsException exception) {
						// JOptionPane.showMessageDialog(null, "모든번호가 다 선택되었습니다.");
						inputNumList1.clear();
						inputNumSet1.clear();
					}
				}
				autoCount = 0;
				manualCount = 0;
			}
		});
	}

	// 수동 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		Object check = e.getSource();
		System.out.println(manualCount);
		System.out.println(autoCount);
		AbstractButton abstractButton = (AbstractButton) e.getSource();
		boolean selected = abstractButton.getModel().isSelected();
		if (isAllRowFull(statusLabels) == 5 && !modifying) {
			// JOptionPane.showMessageDialog(null, "모든번호가 선택되었습니다.");
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
							inputNumSet1.remove(Integer.parseInt(lottoNums[i].getText()));
							lottoNums[i].setSelected(!selected);
							lottoNums[i].setStatus(true);
							manualCount--;
							break;
						} else if (inputNumSet1.size() > 6 && modifying) {
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

	public int falseCount(MyToggleButton[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i].isStatus()) {
				count++;
			}
		}
		return count;
	}

	// 상태값을 통해 비어있는 행에 도착할 수 있도록 해주는 메소드
	public int dicisionRowNum(JLabel[] Labels) {
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
	public int isAllRowFull(JLabel[] Labels) {
		int count = 0;
		for (int i = 0; i < Labels.length; i++) {
			if (!Labels[i].getText().equals("상태")) {
				count++;
			}
		}
		return count;
	}

}