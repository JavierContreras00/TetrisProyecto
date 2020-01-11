package Package;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.JLabel;

public class ProgressBar extends JFrame {

	private Timer t;
	private ActionListener ac;
	private int x = 0;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgressBar frame = new ProgressBar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProgressBar() {
		initComponents();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JProgressBar progressBar = new JProgressBar();
		contentPane.add(progressBar, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}

}
