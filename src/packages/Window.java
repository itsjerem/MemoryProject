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
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import packages.Save;

public class Window {

	private JFrame frame;

	public final List<ImageButton> buttons = new ArrayList<ImageButton>();
	public final ArrayList<Integer> emplacements = new ArrayList<Integer>();

	public ImageButton selectedButton = null;
	public boolean gameDisabled = false;

	public int tries = 8;
	public int timeElapsed = 0;
	public int buttonsFinded = 0;

	// Panels
	public JPanel mainPanel = new JPanel();
	public JPanel scorePanel = new JPanel();
	public JPanel headerPanel = new JPanel();
	public JPanel panel = new JPanel();
	public JPanel headerOptionsPanel = new JPanel();
	public JPanel footerPanel = new JPanel();

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
			@Override
			public void actionPerformed(ActionEvent e) {
				timeElapsed++;
				timerLbl.setText("Temps : " + timeElapsed);
			}
		});

		
		mainPanel.setLayout(new GridLayout(
			4, 4, 0, 0));
			JLabel triesLbl = new JLabel("Essais restants : " + tries);
			
		startGame(timer, timerLbl, triesLbl, mainPanel);
		
				frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel.add(headerOptionsPanel);
		headerOptionsPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		headerOptionsPanel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Options");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Nouvelle partie");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startGame(timer, timerLbl, triesLbl, mainPanel);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		panel.add(headerPanel);
		headerPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		timerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(timerLbl);		
		timer.start();

		frame.getContentPane().add(mainPanel);
		
		frame.getContentPane().add(footerPanel, BorderLayout.SOUTH);
		footerPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		triesLbl.setToolTipText("Essais restants :" + tries);
		triesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		footerPanel.add(triesLbl);

		scorePanel.setLayout(new GridLayout(0, 1, 0, 0));

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Meilleurs scores");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Create a new window with the best scores
				Save.loadScores();

				JFrame scoreFrame = new JFrame();
				scoreFrame.setBounds(100, 100, 450, 300);
				scoreFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				scoreFrame.setVisible(true);

				JPanel scorePanel = new JPanel();
				scoreFrame.getContentPane().add(scorePanel, BorderLayout.CENTER);
				scorePanel.setLayout(new GridLayout(0, 1, 0, 0));

				JLabel scoreLbl = new JLabel("Meilleurs scores");
				scoreLbl.setHorizontalAlignment(SwingConstants.CENTER);
				scorePanel.add(scoreLbl);

				int[] scores = Save.loadScores();
				if (scores != null) {
					for (int i = 0; i < scores.length; i++) {
						String string = scores[i] == 0 ? "Aucun score enregistré" : "Score: " + scores[i]; 
						JLabel lbl = new JLabel(string);
						lbl.setHorizontalAlignment(SwingConstants.CENTER);
						scorePanel.add(lbl);
					}
				} else {
					JLabel lbl = new JLabel("Aucun score enregistré");
					lbl.setHorizontalAlignment(SwingConstants.CENTER);
					scorePanel.add(lbl);
				}

				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
	}
	
	public void toggleButton(ImageButton button, boolean displayed) {
		button.displayed = displayed;
		button.toggle();
	}



	

	private void startGame(Timer timer, JLabel timerLbl, JLabel triesLbl, JPanel mainPanel) {
		Save.CreateFile();
		gameDisabled = false;
		
		mainPanel.removeAll();

		buttonsFinded = 0;
		selectedButton = null;
		
		tries = 8;
		triesLbl.setText("Essais restants : " + tries);

		timeElapsed = 0;
		timerLbl.setText("Temps : 0");
		timer.start();

		for (int j = 0; j < 16; j++)
			emplacements.add(j);
		
			for (int i = 0; i < 16; i++) {
			int randomIndex = (int) (Math.random() * emplacements.size());
			int emplacement = emplacements.get(randomIndex);
			emplacements.remove(randomIndex);

			String name = "img" + (emplacement / 2 + 1);

			ImageIcon icon = new ImageIcon(new ImageIcon("src/img/" + (emplacement / 2 + 1) + ".png").getImage()
					.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
			ImageButton button = new ImageButton(emplacement, name, icon);

			button.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (gameDisabled)
						return;

					if (button.displayed)
						return;

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
											endGame(false, timer, timeElapsed, triesLbl);

									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
							});
							t.start();

						}

						if (buttonsFinded == 8) 
							endGame(true, timer, timeElapsed, triesLbl);

					}

				}
			});

			// Change the button's size
			button.setSize(100, 100);

			buttons.add(button);
			mainPanel.add(button);
		}

		System.out.println("Game started");
	}
	
	public void endGame(boolean isWin, Timer timer, int score, JLabel triesLbl) {
		System.out.println(isWin ? "You win" : "You lose");
		System.out.println("Score: " + score);
		gameDisabled = true;
		timer.stop();
		if (isWin) {
        Save.saveScore(score);
		} else {
			triesLbl.setText("Game Over");
		}
		

		for (ImageButton button : buttons) {
			toggleButton(button, true);
		}
	}
	

	



}
