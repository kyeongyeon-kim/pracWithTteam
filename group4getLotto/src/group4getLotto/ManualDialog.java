import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

class ImagePanel extends JPanel {
	private Image image;

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
		ImagePanel panel = new ImagePanel(new ImageIcon("/inputColor/manual.jpg").getImage());
		add(panel);
		pack();
		
		setSize(450, 550);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}