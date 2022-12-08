package group4getLotto;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

class MyToggleButton1 extends JToggleButton{
	private boolean status = true;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	} 
	
}

class Print extends JFrame implements ActionListener{

	private MyToggleButton[] rottoNums;
	private Set<Integer> inputNumSet1 = new HashSet<>();
	private JButton[] inputNums;
	private JButton select;
	private List<Integer> inputNumList1;
	
	public Print() {
		GridLayout g = new GridLayout(5, 9);
		JPanel main = new JPanel();
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		select = new JButton("확인");
		
		inputNums = new JButton[6];
		for(int i = 0; i < inputNums.length; i++) {
			inputNums[i] = new JButton();
			inputNums[i].setPreferredSize(new Dimension(50, 50));
			right.add(inputNums[i]);
		}
		
		rottoNums = new MyToggleButton[45];
		for(int i = 0; i < 45; i++) {
			rottoNums[i] = new MyToggleButton();
			rottoNums[i].setText(String.valueOf(i + 1));
			left.add(rottoNums[i]);
			rottoNums[i].addActionListener(this);
		}		
		main.add(left);
		main.add(right);
		main.add(select);
		add(main);
		left.setLayout(g);
		
		select.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < inputNumList.size(); i++) {
					inputNums[i].setText(String.valueOf(inputNumList.get(i)));
				}
			}
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object check = e.getSource();
		for(int i = 0; i < rottoNums.length; i++) {
			if(check == rottoNums[i]) {
				if(rottoNums[i].isStatus() == true) {
					inputNumSet.add(Integer.parseInt(rottoNums[i].getText()));
					rottoNums[i].setStatus(false);
					
					if(inputNumSet.size() > 6) {
						JOptionPane.showMessageDialog(null, "6자리 이상은 입력할 수 없습니다.");
						inputNumSet.remove(Integer.parseInt(rottoNums[i].getText()));
						break;
					}	
					
				} else if(rottoNums[i].isStatus() == false){
					rottoNums[i].setStatus(true);
					inputNumSet.remove(Integer.parseInt(rottoNums[i].getText()));
				}
			} 
		}
		System.out.println(inputNumSet);
		inputNumList = new ArrayList<>(inputNumSet);
		Collections.sort(inputNumList);
		
	}


}

public class NewGUI {
	public static void main(String[] args) {
		new Print();
	}
}
