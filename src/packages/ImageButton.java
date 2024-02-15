package packages;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class ImageButton extends JButton {
	public final String name;
	public final ImageIcon image;
	public ImageIcon defaultImage = new ImageIcon("src/img/3.png");
	
	public final int emplacement;
	
	public boolean displayed;
	
	public ImageButton(int emplacement, String name, ImageIcon image) {
			this.emplacement = emplacement;
			this.name = name;
			this.image = image;
			this.setIcon(defaultImage);
	}
	
	public void toggle() {
		System.out.println("toggle");
		displayed = displayed ? true : false;
		if(displayed == true) 
				this.setIcon(image);
		else
			this.setIcon(defaultImage);
	}
	

}
