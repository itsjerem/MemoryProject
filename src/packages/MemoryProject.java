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

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemoryProject window = new MemoryProject();
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
	public MemoryProject() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblSettings = new JLabel("Options");
		lblSettings.setBackground(Color.WHITE);
		lblSettings.setToolTipText("Options");
		panel.add(lblSettings);
		
		JLabel lblTimer = new JLabel("Temps :");
		lblTimer.setBackground(Color.GRAY);
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setToolTipText("temps");
		panel.add(lblTimer);
	}

}
