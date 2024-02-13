package packages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Button;

public class MemoryProject {

	private JFrame frmTarkov;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemoryProject window = new MemoryProject();
					window.frmTarkov.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MemoryProject() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTarkov = new JFrame();
		frmTarkov.setTitle("Tarkov");
		frmTarkov.setBounds(100, 100, 450, 300);
		frmTarkov.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel paneHeader = new JPanel();
		frmTarkov.getContentPane().add(paneHeader, BorderLayout.NORTH);
		paneHeader.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblSettings = new JLabel("Options");
		lblSettings.setBackground(Color.WHITE);
		lblSettings.setToolTipText("Options");
		paneHeader.add(lblSettings);
		
		JLabel lblTimer = new JLabel("Temps :");
		lblTimer.setBackground(Color.GRAY);
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setToolTipText("temps");
		paneHeader.add(lblTimer);
		
		JPanel paneBody = new JPanel();
		frmTarkov.getContentPane().add(paneBody, BorderLayout.CENTER);
		paneBody.setLayout(new GridLayout(4, 4, 0, 0));
		
		Button button = new Button("New button");
		paneBody.add(button);
		
		Button button_1 = new Button("New button");
		paneBody.add(button_1);
		
		Button button_2 = new Button("New button");
		paneBody.add(button_2);
		
		Button button_3 = new Button("New button");
		paneBody.add(button_3);
		
		Button button_4 = new Button("New button");
		paneBody.add(button_4);
		
		Button button_5 = new Button("New button");
		paneBody.add(button_5);
		
		Button button_6 = new Button("New button");
		paneBody.add(button_6);
		
		Button button_7 = new Button("New button");
		paneBody.add(button_7);
		
		Button button_8 = new Button("New button");
		paneBody.add(button_8);
		
		Button button_9 = new Button("New button");
		paneBody.add(button_9);
		
		Button button_10 = new Button("New button");
		paneBody.add(button_10);
		
		Button button_11 = new Button("New button");
		paneBody.add(button_11);
		
		Button button_12 = new Button("New button");
		paneBody.add(button_12);
		
		Button button_13 = new Button("New button");
		paneBody.add(button_13);
		
		Button button_14 = new Button("New button");
		paneBody.add(button_14);
		
		Button button_15 = new Button("New button");
		paneBody.add(button_15);
		
		JPanel paneFooter = new JPanel();
		frmTarkov.getContentPane().add(paneFooter, BorderLayout.SOUTH);
		
		JLabel lblTriesLeft = new JLabel("Essais restants");
		paneFooter.add(lblTriesLeft);
	}

}
