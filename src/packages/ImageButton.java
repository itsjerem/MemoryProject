package packages;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class ImageButton extends JButton {
	public final String name;
	public final BufferedImage image;
	public BufferedImage defaultImage;
	
	public final int emplacement;
	
	public boolean displayed;
	
	public ImageButton(int emplacement, String name, BufferedImage image) {
			this.emplacement = emplacement;
			this.name = name;
			this.image = image;
			this.setIcon(new ImageIcon(defaultImage));
	}
	
	public void toggle() {
		displayed = displayed ? true : false;
		if(displayed == true) 
				this.setIcon(new ImageIcon(this.image));
		else
			this.setIcon(new ImageIcon(defaultImage));
	}
	
	public Image getImage() {
		return image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	}

}
