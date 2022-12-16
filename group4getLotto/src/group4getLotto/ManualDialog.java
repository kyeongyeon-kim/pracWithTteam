import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ImagePanel extends JPanel {
	private Image image;

	public ImagePanel() {
		
	}
	public ImagePanel(Image image) {
		this.image = image;
		setSize(new Dimension(image.getWidth(null), image.getHeight(null)));
		setLayout(null);

	}

	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}

}

public class ManualDialog extends JDialog {

	public ManualDialog() {
		ImagePanel panel = new ImagePanel();
		JLabel baseLabel = new JLabel();
		panel.setBackground(new Color(0, 0, 0));
		baseLabel.setIcon(new ImageIcon(ManualDialog.class.getClassLoader().getResource("manual.png")));
		panel.add(baseLabel);
		add(panel);
		pack();
		setTitle("로또프로그램 사용 설명");
		setSize(610, 930);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}