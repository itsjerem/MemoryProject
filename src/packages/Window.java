package packages;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {

	private JFrame frame;

	public final List<ImageButton> buttons = new ArrayList<ImageButton>();

	public ImageButton selectedButton = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(
				4, 4, 0, 0));

		for (int i = 0; i < 16; i++) {
			ImageButton button = new ImageButton(i, null,
					new ImageIcon("/Users/jerem/Workflow/poubelle/MemoryProject/src/img/1.png"));
			// Add on click listener
			button.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(selectedButton == null) {
						selectedButton = button;
						button.toggle();
					}
					
				}
			});
			buttons.add(button);
			mainPanel.add(button);
		}
		
		frame.getContentPane().add(mainPanel);
	}
	



}
