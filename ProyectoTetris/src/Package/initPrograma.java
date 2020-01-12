package Package;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class initPrograma extends JFrame {

/**
* 
*/
private static final long serialVersionUID = 1L;
public static Connection con;

public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
initPrograma frame = new initPrograma();

} catch (Exception e) {
e.printStackTrace();
}
}
});
}



public initPrograma() {

JFrame frame = new JFrame("Con la base de Datos");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLayout(new FlowLayout());
frame.setLocationRelativeTo(null);
frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\ventanas\\logore.png"));
frame.setBounds(500,500,500,500);


final JProgressBar jprogressBar = new JProgressBar();
final JLabel status = new JLabel("Conectando...");
frame.add(status);
frame.add("jProgressBar", jprogressBar);

frame.pack();
frame.setVisible(true);



SwingWorker sw = new SwingWorker() { 
@Override
public void done() {
jprogressBar.setIndeterminate(false);
status.setText("Conectado...");
jprogressBar.setValue(100);
try {
Thread.sleep(500);
if (con!=null) {
VentanaLogIn.main(con);
}else {
JOptionPane.showMessageDialog(frame, "No se ha podido acceder a la base de datos.");
}
} catch (InterruptedException e) {
e.printStackTrace();
}
frame.dispose();
}

@Override
protected Object doInBackground() throws Exception {
jprogressBar.setIndeterminate(true);
con = BD.initBD(null);
return null;
}

};
sw.execute(); 

}


}