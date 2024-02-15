package packages;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Image;
import java.awt.Dimension;


public class ImageButton extends JButton {
	public final String name;
	public final ImageIcon image;
	public ImageIcon defaultImage = new ImageIcon(new ImageIcon("src/img/0.jpeg").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));	
	public final int emplacement;
	
	public boolean displayed;
	
	public ImageButton(int emplacement, String name, ImageIcon image) {
			this.emplacement = emplacement;
			this.name = name;
			this.image = image;
			this.setIcon(defaultImage);

			this.setPreferredSize(new Dimension(1000, 1000));
	}
	
	public void toggle() {
		displayed = displayed ? true : false;
		if(displayed == true) 
				this.setIcon(image);
		else
			this.setIcon(defaultImage);
	}
	

}
