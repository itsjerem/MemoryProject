package packages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

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
		
		JPanel panel_1 = new JPanel();
		paneBody.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		paneBody.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		paneBody.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		paneBody.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		paneBody.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		paneBody.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		paneBody.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		paneBody.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		paneBody.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		paneBody.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		paneBody.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		paneBody.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		paneBody.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		paneBody.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		paneBody.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		paneBody.add(panel_16);
		
		JPanel paneFooter = new JPanel();
		frmTarkov.getContentPane().add(paneFooter, BorderLayout.SOUTH);
		
		JLabel lblTriesLeft = new JLabel("Essais restants");
		paneFooter.add(lblTriesLeft);
	}

}
