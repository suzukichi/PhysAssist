package guis;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private JFrame frame;
	public MainWindow panel;
	
	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 100, 448, 537);
		frame.setResizable(false);
		panel = new MainWindow();
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
