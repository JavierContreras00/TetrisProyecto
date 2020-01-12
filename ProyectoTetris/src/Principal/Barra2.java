package Principal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class Barra2 extends JFrame {


	JProgressBar current;
	  int num = 0;
	  public Barra2() {
	  super("Progress");
	  
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  JPanel pane = new JPanel();
	  pane.setLayout(new FlowLayout());
	  
	  JLabel jLabel = new JLabel("New label");
	  pane.add(jLabel);
	  current = new JProgressBar(0, 2000);
	  current.setValue(0);
	  current.setStringPainted(true);
	  pane.add(current);
	  setContentPane(pane);
	  }

	public void iterate() {
	  while (num < 2000) {
	  current.setValue(num);
	  try {
	  Thread.sleep(100);
	  } catch (InterruptedException e) { 
	    }
	  num += 95;
	  }
//	  if(num.getValue() == 2000) {
		  
	  }
	  
	public static void main(String[] arguments) {
	  Barra2 frame = new Barra2();
	  frame.pack();
	  frame.setVisible(true);
	  frame.iterate();
	  }
	  }


