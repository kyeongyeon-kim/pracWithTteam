package group4getLotto;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

class Images extends Frame {
	Image img;
	public Images(String filename) {
		Toolkit t = Toolkit.getDefaultToolkit();
		this.img = t.getImage(filename);
	}
	public void paint(Graphics g) {
		g.drawImage(img, 20, 20, this);
	}
	public static void main(String[] args) {
		Frame f = new Images("1.png");
		f.setSize(25, 25);
		f.setVisible(true);
	}	
}


