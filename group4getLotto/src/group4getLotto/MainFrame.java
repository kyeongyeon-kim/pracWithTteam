import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
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

class MyToggleButton extends JToggleButton {
	private boolean printStatus = true;
	private int btnStatus = 0; // 0 안눌러진 상태 /1 수동/-1 자동
	private Color bg;

	public MyToggleButton(ImageIcon convertToNumber) {
		setIcon(convertToNumber);
	}

	public boolean isStatus() {
		return printStatus;
	}

	public int getBtnStatus() {
		return btnStatus;
	}

	public void setBtnStatus(int pressManual) {
		this.btnStatus = pressManual;
	}

	public void setStatus(boolean status) {
		this.printStatus = status;
	}
}

class MyLabel extends JLabel {
	private int btnStatus2 = 0;

	public int getBtnStatus2() {
		return btnStatus2;
	}

	public void setBtnStatus2(int btnStatus2) {
		this.btnStatus2 = btnStatus2;
	}

}

public class MainFrame extends JFrame implements ActionListener {
	public static final String LINK = "";
	private Random random = new Random();
	private JPanel contentPane;
	private Set<Integer> inputNumSet1 = new HashSet<>();
	private List<Integer> inputNumList1;
	private MyToggleButton[] lottoNums = new MyToggleButton[45];
	private MyLabel[][] inputLabels = new MyLabel[5][6];
	private JLabel[] statusLabels = new JLabel[5];
	private JLabel[] abcdeLabels = new JLabel[5];
	private List[] resultArr = new ArrayList[5];
	private int rowNum = 0;
	private boolean modifying = false;
	private ClassLoader classLoader;
	private Image image;
	private ImageIcon icon;
	private Image img;
	private JToggleButton randombtn;
	private ImageIcon iconYellow;
	private Image updateImg;
	private ImageIcon iconBlue;
	private ImageIcon iconRed;
	private ImageIcon iconGray;
	private ImageIcon iconGreen;
	private ImageIcon iconSet2;
	private Image imageSet2;
	private JButton[] changeBtns;
	private JButton[] removeBtns;

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

		// 전적확인버튼 (작업중)
		JButton mix = new JButton("미");
		mix.setSelected(true);
		mix.setBounds(12, 69, 63, 64);
		main.add(mix);

		// 설명서버튼
		JButton manualBtn = new JButton("설명");
		manualBtn.setBounds(12, 143, 63, 64);
		main.add(manualBtn);
		manualBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ManualDialog();
			}
		});

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
		confirmButton(select);
		main.add(select);

		// ABCDE 출력 패널
		JPanel abcde = new JPanel();
		abcde.setBounds(413, 107, 33, 312);
		main.add(abcde);
		abcde.setLayout(new GridLayout(0, 1, 0, 0));
		abcde.setBackground(new Color(255, 0, 0, 0));

		String[] alphabet = { "A", "B", "C", "D", "E" };
		for (int i = 0; i < abcdeLabels.length; i++) {
			abcdeLabels[i] = new JLabel(alphabet[i]);
			abcde.add(abcdeLabels[i]);
			abcdeLabels[i].setHorizontalAlignment(JLabel.CENTER);
		}
		// 토글버튼 45개 만들어서 생성하고 버튼 패널에 add하고 GridLayout 사용해서 정리하고 출력ImageIcon iconSet;
		ImageIcon iconSet;
		iconYellow = new ImageIcon("y.png");
		iconBlue = new ImageIcon("b.png");
		iconRed = new ImageIcon("r.png");
		iconGray = new ImageIcon("g.png");
		iconGreen = new ImageIcon("gr.png");

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
			updateImg = imageSet.getScaledInstance(31, 31, Image.SCALE_SMOOTH);
			lottoNums[i] = new MyToggleButton(new ImageIcon(updateImg));
			lottoNums[i].setText(String.format("%02d", i + 1));
			lottoNums[i].setIconTextGap(-22);
			BtnPanel.add(lottoNums[i]);
			lottoNums[i].setForeground(Color.white);
			lottoNums[i].setBackground(new Color(255, 0, 0, 0));
			lottoNums[i].addActionListener(this);
			lottoNums[i].setOpaque(false);
			lottoNums[i].setBorderPainted(false);
			lottoNums[i].setSelectedIcon(new ImageIcon("black2.png"));
		}

		// 오른쪽 패널
		JPanel right = new JPanel();
		right.setBounds(370, 10, 514, 541);
		contentPane.add(right);
		right.setLayout(null);
		right.setOpaque(false);

		// 자동, 반자동 구현
		randombtn = new JToggleButton("자동");
		randombtn.setOpaque(false);
		randombtn.setBackground(new Color(255, 0, 0, 0));
		randombtn.setBounds(214, 447, 88, 33);
		autoButton(randombtn);
		main.add(randombtn);

		// 복권 이름
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(12, 10, 277, 57);

		// 구매 버튼
		JButton result = new JButton("구매 하기 !");
		result.setBounds(603, 429, 100, 40);
		main.add(result);
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
				inputLabels[i][j] = new MyLabel();
				inputLabels[i][j].setText("0");
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
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1.setBounds(60, 447, 78, 33);
		main.add(lblNewLabel_1);

		JButton close = new JButton("종료");
		close.setOpaque(false);
		close.setBackground(new Color(255, 0, 0, 0));
		close.setBounds(848, 491, 100, 40);
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		main.add(close);

		// 수정버튼 메소드
		changeBtns = new JButton[5];
		for (int i = 0; i < 5; i++) {
			changeBtns[i] = new JButton(new ImageIcon("remove.png"));
			changePanel.add(changeBtns[i]);
			changeBtns[i].setBackground(new Color(255, 0, 0, 0));
			changeBtns[i].setOpaque(false);
			changeBtns[i].setBorderPainted(false);
			changeBtns[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AbstractButton abstractButton = (AbstractButton) e.getSource();
					boolean selected = abstractButton.getModel().isSelected();
					modifying = true;
					inputNumSet1.clear();
					for (int i = 0; i < lottoNums.length; i++) {
						if (!lottoNums[i].isStatus()) {
							lottoNums[i].setSelected(selected);
							lottoNums[i].setStatus(true);
							changeBtns[rowNum].setIcon(new ImageIcon("remove.png"));
						}
					}
					try {
						if (changeBtns[0] == e.getSource()) {
							rowNum = 0;
							int labelStr = 0;
							for (int j = 0; j <= inputLabels.length; j++) {
								// 출력 라벨에 있는 텍스트 인트형으로 변환해서 버튼 언셀렉
								labelStr = Integer.parseInt(inputLabels[rowNum][j].getText());
								lottoNums[labelStr - 1].setSelected(!selected);
								inputNumSet1.add(labelStr);
								lottoNums[labelStr - 1].setStatus(false);
								changeBtns[rowNum].setIcon(new ImageIcon("resetR.png"));
								lottoNums[labelStr - 1].setBtnStatus(inputLabels[rowNum][j].getBtnStatus2());
							}

						} else if (changeBtns[1] == e.getSource()) {
							rowNum = 1;
							int labelStr = 0;
							for (int j = 0; j <= inputLabels.length; j++) {
								// 출력 라벨에 있는 텍스트 인트형으로 변환해서 버튼 언셀렉
								labelStr = Integer.parseInt(inputLabels[rowNum][j].getText());
								lottoNums[labelStr - 1].setSelected(!selected);
								inputNumSet1.add(labelStr);
								lottoNums[labelStr - 1].setStatus(false);
								changeBtns[rowNum].setIcon(new ImageIcon("resetR.png"));
								lottoNums[labelStr - 1].setBtnStatus(inputLabels[rowNum][j].getBtnStatus2());
							}
						} else if (changeBtns[2] == e.getSource()) {
							rowNum = 2;
							int labelStr = 0;
							for (int j = 0; j <= inputLabels.length; j++) {
								// 출력 라벨에 있는 텍스트 인트형으로 변환해서 버튼 언셀렉
								labelStr = Integer.parseInt(inputLabels[rowNum][j].getText());
								lottoNums[labelStr - 1].setSelected(!selected);
								inputNumSet1.add(labelStr);
								lottoNums[labelStr - 1].setStatus(false);
								changeBtns[rowNum].setIcon(new ImageIcon("resetR.png"));
								lottoNums[labelStr - 1].setBtnStatus(inputLabels[rowNum][j].getBtnStatus2());
							}
						} else if (changeBtns[3] == e.getSource()) {
							rowNum = 3;
							int labelStr = 0;
							for (int j = 0; j <= inputLabels.length; j++) {
								// 출력 라벨에 있는 텍스트 인트형으로 변환해서 버튼 언셀렉
								labelStr = Integer.parseInt(inputLabels[rowNum][j].getText());
								lottoNums[labelStr - 1].setSelected(!selected);
								inputNumSet1.add(labelStr);
								lottoNums[labelStr - 1].setStatus(false);
								changeBtns[rowNum].setIcon(new ImageIcon("resetR.png"));
								lottoNums[labelStr - 1].setBtnStatus(inputLabels[rowNum][j].getBtnStatus2());
							}
						} else if (changeBtns[4] == e.getSource()) {
							rowNum = 4;
							int labelStr = 0;
							for (int j = 0; j <= inputLabels.length; j++) {
								// 출력 라벨에 있는 텍스트 인트형으로 변환해서 버튼 언셀렉
								labelStr = Integer.parseInt(inputLabels[rowNum][j].getText());
								lottoNums[labelStr - 1].setSelected(!selected);
								inputNumSet1.add(labelStr);
								lottoNums[labelStr - 1].setStatus(false);
								changeBtns[rowNum].setIcon(new ImageIcon("resetR.png"));
								lottoNums[labelStr - 1].setBtnStatus(inputLabels[rowNum][j].getBtnStatus2());
							}
						}
					} catch (ArrayIndexOutOfBoundsException e2) {
						modifying = false;
					}
				}
			});
		}

		// 초기화버튼 메소드
		removeBtns = new JButton[5];
		for (int i = 0; i < 5; i++) {
			removeBtns[i] = new JButton(new ImageIcon("reset.png"));
			removePanel.add(removeBtns[i]);
			removeBtns[i].setOpaque(false);
			removeBtns[i].setBorderPainted(false);
			removeBtns[i].setBackground(new Color(255, 0, 0, 0));
			removeBtns[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AbstractButton abstractButton = (AbstractButton) e.getSource();
					boolean selected = abstractButton.getModel().isSelected();
					try {
						if (removeBtns[0] == e.getSource()) {
							rowNum = 0;
							for (int j = 0; j <= inputLabels.length; j++) {
								inputLabels[0][j].setText("0");
								inputLabels[0][j].setForeground(Color.BLACK);
								inputLabels[0][j].setIcon(new ImageIcon());
								statusLabels[0].setText("상태");
							}
						} else if (removeBtns[1] == e.getSource()) {
							rowNum = 1;
							for (int j = 0; j <= inputLabels.length; j++) {
								inputLabels[1][j].setText("0");
								inputLabels[1][j].setForeground(Color.BLACK);
								inputLabels[1][j].setIcon(new ImageIcon());
								statusLabels[1].setText("상태");
							}
						} else if (removeBtns[2] == e.getSource()) {
							rowNum = 2;
							for (int j = 0; j <= inputLabels.length; j++) {
								inputLabels[2][j].setText("0");
								inputLabels[2][j].setForeground(Color.BLACK);
								inputLabels[2][j].setIcon(new ImageIcon());
								statusLabels[2].setText("상태");
							}
						} else if (removeBtns[3] == e.getSource()) {
							rowNum = 3;
							for (int j = 0; j <= inputLabels.length; j++) {
								inputLabels[3][j].setText("0");
								inputLabels[3][j].setForeground(Color.BLACK);
								inputLabels[3][j].setIcon(new ImageIcon());
								statusLabels[3].setText("상태");
							}
						} else if (removeBtns[4] == e.getSource()) {
							rowNum = 4;
							for (int j = 0; j <= inputLabels.length; j++) {
								inputLabels[4][j].setText("0");
								inputLabels[4][j].setForeground(Color.BLACK);
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
						rowNum = 0;
					} catch (NullPointerException e2) {

					}
					randombtn.setSelected(selected);
					for (int i = 0; i < lottoNums.length; i++) {
						lottoNums[i].setBtnStatus(0);
					}
					for (int i = 0; i < 5; i++) {
						changeBtns[i].setIcon(new ImageIcon("remove.png"));
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
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				boolean selected = abstractButton.getModel().isSelected();
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
//                      다이얼 로그 호출하기
						new Money(resultArr);

						for (int j = 0; j < inputLabels.length; j++) {
							statusLabels[j].setText("상태");
							for (int k = 0; k < inputLabels[j].length; k++) {
								inputLabels[j][k].setIcon(new ImageIcon());
								inputLabels[j][k].setText("0");
								inputLabels[j][k].setForeground(Color.black);
							}
						}
						for (int i = 0; i < lottoNums.length; i++) {
							lottoNums[i].setSelected(selected);
							lottoNums[i].setStatus(false);
							lottoNums[i].setBtnStatus(0);
						}
						for (int j = 0; j < 5; j++) {
							changeBtns[j].setIcon(new ImageIcon("remove.png"));
						}
						inputNumList1.clear();
						inputNumSet1.clear();
						rowNum = 0;
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
					if (isAllRowFull(statusLabels) == 5 && !modifying) {
						inputNumList1.clear();
						inputNumSet1.clear();
						randombtn.setSelected(!selected);
					} else if (inputNumSet1.size() == 6) {
						randombtn.setSelected(!selected);
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
								lottoNums[num].setBtnStatus(-1);
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
								if (lottoNums[num].getBtnStatus() != 1) {
									lottoNums[num].setBtnStatus(-1);
								}
							}
						}
					}
				} else if (!selected) {
					inputNumList1.clear();
					inputNumSet1.clear();
					for (int i = 0; i < lottoNums.length; i++) {
						lottoNums[i].setSelected(selected);
						lottoNums[i].setStatus(true);
						lottoNums[i].setBtnStatus(0);
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
					rowNum = dicisionRowNum(statusLabels);
					randombtn.setSelected(selected);
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
								for (int j = 0; j < 5; j++) {
									changeBtns[j].setIcon(new ImageIcon("remove.png"));
								}
								for (int i = 0; i < inputLabels[rowNum].length; i++) {
									if (inputNumList1.get(i) < 11) {
										iconSet2 = iconYellow;
									} else if (inputNumList1.get(i) < 21) {
										iconSet2 = iconBlue;
									} else if (inputNumList1.get(i) < 31) {
										iconSet2 = iconRed;
									} else if (inputNumList1.get(i) < 41) {
										iconSet2 = iconGray;
									} else {
										iconSet2 = iconGreen;
									}
									imageSet2 = iconSet2.getImage();
									updateImg = imageSet2.getScaledInstance(31, 31, Image.SCALE_SMOOTH);
									inputLabels[rowNum][i].setText(String.format("%02d", inputNumList1.get(i)));
									inputLabels[rowNum][i].setIcon(new ImageIcon(updateImg));
									inputLabels[rowNum][i].setForeground(Color.white);
									inputLabels[rowNum][i].setIconTextGap(-22);
								}

								int count = -1;
								for (int i = 0; i < lottoNums.length; i++) {
									if (lottoNums[i].getBtnStatus() != 0) {
										count++;
										inputLabels[rowNum][count].setBtnStatus2(lottoNums[i].getBtnStatus());
									}
								}
								// 자동,수동,반자동 여부 결정
								int manualCount = 0;
								int autoCount = 0;
								for (int i = 0; i < lottoNums.length; i++) {
									if (lottoNums[i].getBtnStatus() == 1) {
										manualCount++;
									} else if (lottoNums[i].getBtnStatus() == -1) {
										autoCount++;

									}
								}
								if (manualCount == 6) {
									statusLabels[rowNum].setText("수동");
								} else if (autoCount == 6) {
									statusLabels[rowNum].setText("자동");
								} else {
									statusLabels[rowNum].setText("반자동");
								}
								if (inputNumSet1.size() == 6) {
									modifying = false;
								} else {
									rowNum = 0;
								}
								inputNumList1.clear();
								inputNumSet1.clear();

								for (int i = 0; i < lottoNums.length; i++) {
									lottoNums[i].setBtnStatus(0);
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "번호 6개를 선택해주세요.");
						}
					} catch (NullPointerException exception) {
						JOptionPane.showMessageDialog(null, "번호 6개를 선택해주세요.");
					} catch (ArrayIndexOutOfBoundsException exception) {
						inputNumList1.clear();
						inputNumSet1.clear();
					}
				}
				randombtn.setSelected(selected);
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
						lottoNums[i].setBtnStatus(1);
						if (inputNumSet1.size() > 6 && !modifying) {
							inputNumSet1.remove(Integer.parseInt(lottoNums[i].getText()));
							lottoNums[i].setSelected(!selected);
							lottoNums[i].setStatus(true);
							lottoNums[i].setBtnStatus(0);
							break;
						} else if (inputNumSet1.size() > 6 && modifying) {
							inputNumSet1.remove(Integer.parseInt(lottoNums[i].getText()));
							lottoNums[i].setSelected(!selected);
							lottoNums[i].setStatus(true);
							lottoNums[i].setBtnStatus(0);
						}
					} else if (!lottoNums[i].isStatus()) {
						lottoNums[i].setStatus(true);
						inputNumSet1.remove(Integer.parseInt(lottoNums[i].getText()));
						lottoNums[i].setBtnStatus(0);
					}
				}
			}
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