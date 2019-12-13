package Package;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Panel;

public class ventanaOpciones extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaOpciones frame = new ventanaOpciones();
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
	public ventanaOpciones() {
		setTitle("Opciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRotarDerecha = new JLabel("Rotar Derecha");
		lblRotarDerecha.setBounds(12, 123, 93, 13);
		contentPane.add(lblRotarDerecha);
		
		JLabel lblRotarIzquierda = new JLabel("Rotar Izquierda");
		lblRotarIzquierda.setBounds(12, 146, 93, 13);
		contentPane.add(lblRotarIzquierda);
		
		JLabel lblMoverDerecha = new JLabel("Mover Derecha");
		lblMoverDerecha.setBounds(12, 169, 93, 13);
		contentPane.add(lblMoverDerecha);
		
		JLabel lblMoverIzquierda = new JLabel("Mover Izquierda");
		lblMoverIzquierda.setBounds(12, 192, 93, 13);
		contentPane.add(lblMoverIzquierda);
		
		JLabel lblBajarSuave = new JLabel("Bajar Suave");
		lblBajarSuave.setBounds(12, 215, 93, 13);
		contentPane.add(lblBajarSuave);
		
		JLabel lblBajarDeGolpe = new JLabel("Bajar de Golpe");
		lblBajarDeGolpe.setBounds(12, 238, 93, 13);
		contentPane.add(lblBajarDeGolpe);
		
		JLabel lblEnsearLaPieza = new JLabel("Ense\u00F1ar la Pieza Fantasma");
		lblEnsearLaPieza.setBounds(12, 284, 168, 13);
		contentPane.add(lblEnsearLaPieza);
		
		JLabel lblMusica = new JLabel("Musica");
		lblMusica.setBounds(12, 329, 46, 13);
		contentPane.add(lblMusica);
		
		JButton btnSalir = new JButton("Atras");
		btnSalir.setBounds(117, 375, 111, 21);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal p = new ventanaPrincipal(); 
				p.setVisible(true);
				ventanaOpciones.this.dispose();
				
			}
			
		});
		
		JPanel panelRotarDerecha = new JPanel();
		panelRotarDerecha.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelRotarDerecha.setBounds(224, 123, 119, 13);
		contentPane.add(panelRotarDerecha);
		
		JPanel panelRotarIzquierda = new JPanel();
		panelRotarIzquierda.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelRotarIzquierda.setBounds(224, 146, 119, 13);
		contentPane.add(panelRotarIzquierda);
		
		JPanel panelMoverDerecha = new JPanel();
		panelMoverDerecha.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelMoverDerecha.setBounds(224, 169, 119, 13);
		contentPane.add(panelMoverDerecha);
		
		JPanel panelMoverIzquierda = new JPanel();
		panelMoverIzquierda.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelMoverIzquierda.setBounds(224, 192, 119, 13);
		contentPane.add(panelMoverIzquierda);
		
		JPanel panelBajarSuave = new JPanel();
		panelBajarSuave.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelBajarSuave.setBounds(224, 215, 119, 13);
		contentPane.add(panelBajarSuave);
		
		JPanel panelBajarDeGolpe = new JPanel();
		panelBajarDeGolpe.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelBajarDeGolpe.setBounds(224, 238, 119, 13);
		contentPane.add(panelBajarDeGolpe);
		
		JPanel panelPiezaFantasma = new JPanel();
		panelPiezaFantasma.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelPiezaFantasma.setBounds(224, 284, 119, 13);
		contentPane.add(panelPiezaFantasma);
		
		JPanel panelMusica = new JPanel();
		panelMusica.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelMusica.setBounds(224, 329, 119, 13);
		contentPane.add(panelMusica);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 0, 347, 61);
		contentPane.add(panel_1);
		
		Panel panel = new Panel();
		panel_1.add(panel);
		panel.setBackground(Color.YELLOW);
		panel.setLayout(null);
	}
}
