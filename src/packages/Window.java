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
			ImageIcon icon = new ImageIcon(new ImageIcon("src/img/1.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
			ImageButton button = new ImageButton(i, "img", icon);
			button.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (selectedButton == null) {
						selectedButton = button;
						toggleButton(button, true);
						System.out.println("Selected button: " + button.emplacement);
					} else {

						// If the same button is clicked, do nothing
						if (selectedButton.emplacement == button.emplacement) {
							System.out.println("Same button");
							return;
						}

						// If the button is already displayed, do nothing
						if (button.displayed) {
							System.out.println("Button already displayed");
							return;
						}

						toggleButton(button, true);
						System.out.println("Clicked button: " + button.emplacement);

						// If the buttons match, do something
						if (selectedButton.name == button.name) {
							System.out.println("Match" + selectedButton.name + " " + button.name);
							toggleButton(selectedButton, true);
							selectedButton = null;
						} else {
							System.out.println("No match");

							// Reset the buttons after 1 second
							Thread t = new Thread(new Runnable() {
								public void run() {
									try {
										Thread.sleep(1000);
										toggleButton(selectedButton, false);
										toggleButton(button, false);
										selectedButton = null;
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
							});
							t.start();
						}

					}

				}
			});
			buttons.add(button);
			mainPanel.add(button);
		}

		frame.getContentPane().add(mainPanel);
	}
	
	public void toggleButton(ImageButton button, boolean displayed) {
		button.displayed = displayed;
		button.toggle();
	}

	

	



}
