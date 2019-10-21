package Package;



import java.awt.BorderLayout;

import java.awt.EventQueue;



import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import javax.swing.JButton;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import javax.swing.JLabel;



public class VentanaPrincipal extends JFrame {



	private JPanel absPane;



	/**

	 * Launch the application.

	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					VentanaPrincipal frame = new VentanaPrincipal();

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

	public VentanaPrincipal() {

		setTitle("VentanaPrincipal");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 300, 235);

		absPane = new JPanel();

		absPane.setToolTipText("");

		absPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(absPane);

		absPane.setLayout(null);

		

		JButton btnPlay = new JButton("Play");

		btnPlay.setBounds(100, 72, 85, 21);

		absPane.add(btnPlay);

		

		JButton btnScore = new JButton("Score");

		btnScore.setBounds(100, 103, 85, 21);

		absPane.add(btnScore);

		

		JButton btnOptions = new JButton("Options");

		btnOptions.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}

		});

		btnOptions.setBounds(100, 134, 85, 21);

		absPane.add(btnOptions);

		

		JButton btnExit = new JButton("Exit");

		btnExit.setBounds(100, 165, 85, 21);

		absPane.add(btnExit);

		

		JLabel lblTetrisdeusto = new JLabel("TetrisDeusto");

		lblTetrisdeusto.setBounds(100, 36, 85, 13);

		absPane.add(lblTetrisdeusto);

	}

}
