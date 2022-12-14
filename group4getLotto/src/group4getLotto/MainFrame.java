import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

class ToggleButton extends JToggleButton {
	private boolean status = true;

	public ToggleButton(ImageIcon convertToNumber) {
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
	private ToggleButton[] lottoNums = new ToggleButton[45];
	private JLabel[][] inputLabels = new JLabel[5][6];
	private JLabel[] statusLabels = new JLabel[5];
	private JLabel[] abcdeLabels = new JLabel[5];
	private List[] resultArr = new ArrayList[5];
	private int fullRow = 0;
	private int manualCount = 0;
	private boolean modifying = false;
	private ClassLoader classLoader;
	private Image image;
	private ImageIcon icon;
	private Image img;
	private JToggleButton randombtn;
	private int quantityIntNum;
	private boolean autoMode = false;
	private int printAutoMode;

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
		setBounds(100, 100, 1000, 600);

		// 백그라운드 이미지
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("background.png");

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

		// 그리드 레이아웃
		GridLayout g = new GridLayout(9, 5, 3, 3);

		// 메인 패널
		JPanel main = new JPanel();
		main.setBounds(12, 10, 960, 541);
		contentPane.add(main);
		main.setLayout(null);
		main.setOpaque(false);

		// 혼합, 자동 선택 토글버튼
		ButtonGroup group = new ButtonGroup();
		JToggleButton mix = new JToggleButton("미");
		mix.setSelected(true);
		mix.setBounds(12, 69, 63, 64);
		main.add(mix);

		JToggleButton mixRandom = new JToggleButton("구현");
		mixRandom.setBounds(12, 143, 63, 64);
		main.add(mixRandom);
		group.add(mix);
		group.add(mixRandom);

		// 버튼 패널
		JPanel BtnPanel = new JPanel();
		BtnPanel.setLayout(g);
		BtnPanel.setBounds(87, 69, 314, 368);
		BtnPanel.setOpaque(false);
		main.add(BtnPanel);

		// 확인버튼
		JButton select = new JButton("확인");
		select.setBounds(313, 447, 88, 33);
		select.setBackground(new Color(255, 0, 0, 0));
		select.setOpaque(false);
		select.setBorderPainted(false);
		confirmButton(select);
		main.add(select);

		// ABCDE 출력 패널
		JPanel abcde = new JPanel();
		abcde.setBounds(413, 107, 33, 312);
		main.add(abcde);
		abcde.setLayout(new GridLayout(0, 1, 0, 0));

		String[] alphabet = { "A", "B", "C", "D", "E" };
		for (int i = 0; i < abcdeLabels.length; i++) {
			abcdeLabels[i] = new JLabel(alphabet[i]);
			abcde.add(abcdeLabels[i]);
			abcdeLabels[i].setHorizontalAlignment(JLabel.CENTER);
		}
		// 토글버튼 45개 만들어서 생성하고 버튼 패널에 add하고 GridLayout 사용해서 정리하고 출력ImageIcon iconSet;
		ImageIcon iconSet;
		ImageIcon iconYellow = new ImageIcon("y.png");
		ImageIcon iconBlue = new ImageIcon("b.png");
		ImageIcon iconRed = new ImageIcon("r.png");
		ImageIcon iconGray = new ImageIcon("g.png");
		ImageIcon iconGreen = new ImageIcon("green.png");

		for (int i = 0; i < 45; i++) {
			if (i < 10) {
				iconSet = iconYellow;
			} else if (i < 20) {
				iconSet = iconBlue;
			} else if (i < 30) {
				iconSet = iconRed;
			} else if (i < 40) {
				iconSet = iconGray;
			} else {
				iconSet = iconGreen;
			}
			Image imageSet = iconSet.getImage();
			Image updateImg = imageSet.getScaledInstance(31, 31, Image.SCALE_SMOOTH);
			lottoNums[i] = new ToggleButton(new ImageIcon(updateImg));
			lottoNums[i].setText(String.format("%02d", i + 1));
			lottoNums[i].setIconTextGap(-22);
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
		randombtn = new JToggleButton("자동");
		randombtn.setOpaque(false);
		randombtn.setBorderPainted(false);
		randombtn.setBackground(new Color(255, 0, 0, 0));
		randombtn.setBounds(214, 447, 88, 33);
		autoButton(randombtn);
		main.add(randombtn);

		// 복권 이름
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(12, 10, 277, 57);

		// 구매 버튼
		JButton result = new JButton("구매 하기 !");
		result.setBounds(620, 429, 100, 40);
		main.add(result);
		result.setBorderPainted(false);
		resultButton(result);
		result.setBackground(new Color(255, 0, 0, 0));
		result.setOpaque(false);

		// 결과 확인창 6*5
		JPanel labelPanel = new JPanel();
		labelPanel.setBounds(496, 107, 351, 312);
		main.add(labelPanel);
		labelPanel.setOpaque(false);
		labelPanel.setLayout(new GridLayout(0, 6, 0, 0));
		for (int i = 0; i < inputLabels.length; i++) {
			for (int j = 0; j < inputLabels[i].length; j++) {
				inputLabels[i][j] = new JLabel("0");
				labelPanel.add(inputLabels[i][j]);
			}
		}

		// 자동 반자동 상태 입력하는거
		JPanel status = new JPanel();
		status.setBounds(447, 107, 47, 312);
		main.add(status);
		status.setOpaque(false);
		status.setLayout(new GridLayout(0, 1, 0, 0));
		for (int i = 0; i < statusLabels.length; i++) {
			statusLabels[i] = new JLabel("상태");
			status.add(statusLabels[i]);
			statusLabels[i].setHorizontalAlignment(JLabel.CENTER);
		}

		// 수정 패널

		JPanel changePanel = new JPanel();
		changePanel.setLayout(new GridLayout(0, 1, 0, 0));
		main.add(changePanel);
		changePanel.setOpaque(false);
		changePanel.setBounds(849, 107, 50, 312);

		// 리셋 패널
		JPanel removePanel = new JPanel();
		removePanel.setLayout(new GridLayout(0, 1, 0, 0));
		main.add(removePanel);
		removePanel.setBounds(898, 107, 50, 312);
		removePanel.setOpaque(false);

		// 콤보박스
		String[] quantity = { "미구현", "1", "2", "3", "4", "5" };
		JComboBox quantityBox = new JComboBox(quantity);
		quantityBox.setBounds(144, 447, 58, 33);
		main.add(quantityBox);
		quantityBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String quantityNum = "1";
				quantityNum = quantityBox.getSelectedItem().toString();

//            quantityIntNum = Integer.parseInt(quantityNum);
			}
		});

		JLabel lblNewLabel_1 = new JLabel("적용 수량");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(60, 447, 78, 33);
		main.add(lblNewLabel_1);

		// 수정버튼
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
//                     JOptionPane.showMessageDialog(null, "해당 줄에 입력된 번호가 없습니다.");
					}
					modifying = true;
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
								inputLabels[0][j].setIcon(new ImageIcon());
								statusLabels[0].setText("상태");
							}
						} else if (removeBtn[1] == e.getSource()) {
							for (int j = 0; j <= inputLabels.length; j++) {
								inputLabels[1][j].setText("0");
								inputLabels[1][j].setIcon(new ImageIcon());
								statusLabels[1].setText("상태");
							}
						} else if (removeBtn[2] == e.getSource()) {
							for (int j = 0; j <= inputLabels.length; j++) {
								inputLabels[2][j].setText("0");
								inputLabels[2][j].setIcon(new ImageIcon());
								statusLabels[2].setText("상태");
							}
						} else if (removeBtn[3] == e.getSource()) {
							for (int j = 0; j <= inputLabels.length; j++) {
								inputLabels[3][j].setText("0");
								inputLabels[3][j].setIcon(new ImageIcon());
								statusLabels[3].setText("상태");
							}
						} else if (removeBtn[4] == e.getSource()) {
							for (int j = 0; j <= inputLabels.length; j++) {
								inputLabels[4][j].setText("0");
								inputLabels[4][j].setIcon(new ImageIcon());
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
						manualCount = 0;
						fullRow = 0;
					} catch (NullPointerException e2) {
						//
					}

				}
			});
		}

	}

// 구매하기 버튼
	public void resultButton(JButton result) {
		result.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isAllRowFull(statusLabels) == 0) {
					JOptionPane.showMessageDialog(null, "구매할 번호를 선택해 주세요.");
				} else {
					int result = JOptionPane.showConfirmDialog(null, "구매를 확정 하시겠습니까?", "구매 확인",
							JOptionPane.YES_NO_OPTION);
					if (result == 0) {
						int labelStr = 0;
						for (int i = 0; i < inputLabels.length; i++) {
							List<Integer> list = new ArrayList<>();
							for (int j = 0; j < inputLabels[i].length; j++) {
								labelStr = Integer.parseInt(inputLabels[i][j].getText());
								list.add(labelStr);
							}
							resultArr[i] = new ArrayList<Integer>(list);
						}
//                         다이얼 로그 호출하기

						new Money(resultArr);

						for (int j = 0; j < inputLabels.length; j++) {
							statusLabels[j].setText("상태");
							for (int k = 0; k < inputLabels[j].length; k++) {
								inputLabels[j][k].setIcon(new ImageIcon());
								inputLabels[j][k].setText("0");
							}
						}
					}
				}

			}
		});
	}

// 자동버튼
	public void autoButton(JToggleButton randombtn) {
		randombtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if (selected) {
					autoMode = true;
					if (isAllRowFull(statusLabels) == 5 && !modifying) {
						// JOptionPane.showMessageDialog(null, "모든번호가 다 선택되었습니다.");
						inputNumList1.clear();
						inputNumSet1.clear();
					} else if (inputNumSet1.size() == 6) {
						for (int i = 0; i < lottoNums.length; i++) {
							lottoNums[i].setSelected(!selected);
							lottoNums[i].setStatus(false);
						}
						// JOptionPane.showMessageDialog(null, "모든번호가 다 선택되었습니다.2");
					} else {
						if (inputNumSet1.size() == 0) {
							while (inputNumSet1.size() < 6) {
								int randomNum = random.nextInt(44) + 1;
								inputNumSet1.add(randomNum + 1);
							}
							inputNumList1 = new ArrayList<>(inputNumSet1);
							Collections.sort(inputNumList1);
							for (int i = 0; i < inputNumList1.size(); i++) {
								int num = inputNumList1.get(i) - 1;
								lottoNums[num].setSelected(selected);
								lottoNums[num].setStatus(false);
							}
						} else if (inputNumSet1.size() != 0) {
							while (inputNumSet1.size() < 6) {
								int randomNum = random.nextInt(44) + 1;
								inputNumSet1.add(randomNum + 1);
							}
							inputNumList1 = new ArrayList<>(inputNumSet1);
							Collections.sort(inputNumList1);
							for (int i = 0; i < inputNumList1.size(); i++) {
								int num = inputNumList1.get(i) - 1;
								lottoNums[num].setSelected(selected);
								lottoNums[num].setStatus(false);

							}
						}
					}
				} else if (!selected) {
					autoMode = false;
					inputNumList1.clear();
					inputNumSet1.clear();
					for (int i = 0; i < lottoNums.length; i++) {
						lottoNums[i].setSelected(selected);
						lottoNums[i].setStatus(true);
					}
				}
			}
		});
	}

	// 확인 버튼
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
					randombtn.setSelected(selected);
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
								if (manualCount == 6) {
									statusLabels[fullRow].setText("수동");
								} else if (manualCount == 0) {
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
								randombtn.setSelected(selected);
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
				manualCount = 0;

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

	public int falseCount(ToggleButton[] arr) {
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