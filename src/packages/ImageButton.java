package packages;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class ImageButton extends JButton {
	public final String name;
	public final ImageIcon image;
	public ImageIcon defaultImage;
	
	public final int emplacement;
	
	public boolean displayed;
	
	public ImageButton(int emplacement, String name, ImageIcon image) {
			this.emplacement = emplacement;
			this.name = name;
			this.image = image;
			this.setIcon(image);
	}
	
	public void toggle() {
		displayed = displayed ? true : false;
		if(displayed == true) 
				this.setIcon(image);
		else
			this.setIcon(defaultImage);
	}
	

}
