package packages;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {

	private JFrame frame;

	public final List<ImageButton> buttons = new ArrayList<ImageButton>();

	public ImageButton selectedButton = null;
	public boolean gameDisabled = false;

	public int tries = 8;
	
	public int buttonsFinded = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setResizable(false);
					window.frame.setSize(400, 400);
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

		JLabel timerLbl = new JLabel("Temps : 0");
		Timer timer = new Timer(1000, new ActionListener() {
			int timeElapsed = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				timeElapsed++;
				timerLbl.setText("Temps : " + timeElapsed);
			}
		});

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(
				4, 4, 0, 0));
		JLabel triesLbl = new JLabel("Essais restants : " + tries);


		ArrayList<Integer> emplacements = new ArrayList<Integer>();
		for (int j = 0; j < 16; j++)
			emplacements.add(j);
				emplacements.sort((a, b) -> 1 - 2 * (int) Math.random());

		for (int i = 0; i < 16; i++) {
			int randomIndex = (int) (Math.random() * emplacements.size());
			int emplacement = emplacements.get(randomIndex);
			emplacements.remove(randomIndex);

			String name = "img" + (emplacement / 2 + 1);

			ImageIcon icon = new ImageIcon(new ImageIcon("src/img/"+ (emplacement / 2 + 1) + ".png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
			ImageButton button = new ImageButton(emplacement, name, icon);
				

			button.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (gameDisabled) return;

					if (selectedButton == null) {
						selectedButton = button;
						toggleButton(button, true);
						System.out.println("Selected button: " + button.emplacement + " " + button.name);
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
						System.out.println("Clicked button: " + button.emplacement + " " + button.name);

						// If the buttons match, do something
						if (selectedButton.name.equals(button.name)) {
							System.out.println("Match " + selectedButton.name + " " + button.name);
							toggleButton(selectedButton, true);
							selectedButton = null;
							buttonsFinded++;
						} else {
							System.out.println("No match " + selectedButton.name + " " + button.name);
							System.err.println(selectedButton.name.equals(button.name));

							// Reset the buttons after 1 second
							gameDisabled = true;
							Thread t = new Thread(new Runnable() {
								public void run() {
									try {
										Thread.sleep(1000);
										toggleButton(selectedButton, false);
										toggleButton(button, false);
										selectedButton = null;
										gameDisabled = false;

										tries--;
										triesLbl.setText("Essais restants : " + tries);
										if (tries == 0) 
											endGame(false, timer);

									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
							});
							t.start();
							
							
						}
						

						if (buttonsFinded == 8) 
							endGame(true, timer);


					}

				}
			});

			// Change the button's size
			button.setSize(100, 100);

			buttons.add(button);
			mainPanel.add(button);
		}
		
		JPanel headerPanel = new JPanel();
		frame.getContentPane().add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		// Créer un JLabel pour afficher le temps
		timerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(timerLbl);
		// Créer un Timer qui se déclenche toutes les secondes
		
		timer.start();

		frame.getContentPane().add(mainPanel);
		
		JPanel footerPanel = new JPanel();
		frame.getContentPane().add(footerPanel, BorderLayout.SOUTH);
		footerPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		triesLbl.setToolTipText("Essais restants :" + tries);
		triesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		footerPanel.add(triesLbl);
	}
	
	public void toggleButton(ImageButton button, boolean displayed) {
		button.displayed = displayed;
		button.toggle();
	}

	public void endGame(boolean isWin, Timer timer) {
		gameDisabled = true;
		System.out.println(isWin ? "You win" : "You lose");
		timer.stop();

		for (ImageButton button : buttons) {
			toggleButton(button, true);
		}
	}
	

	



}
