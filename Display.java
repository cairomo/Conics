import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Display extends JComponent implements MouseListener, MouseMotionListener {
	
	private final int DISPLAY_WIDTH; 
	private final int DISPLAY_HEIGHT;
	private JLabel description;
	private SolveButton Solve;
	private JTextField A, B, C, D, E;
	private JLabel xsquared, x, ysquared, y, end;
	private JTextField type;
	private JTextField center;
	private JLabel eqDescription;
	private JLabel ansDescription;
	public static String eq;
	Conics c = new Conics(1,2,3,4,5);
	
	public Display(int width, int height) {
		DISPLAY_WIDTH = width;
		DISPLAY_HEIGHT = height;
		init();
	}
	
	public void init() {
		setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);
		

		addMouseListener(this);
		addMouseMotionListener(this);
		
		description = new JLabel("Enter your equation, then press 'solve'");
		description.setSize(950,20);
		add(description);
		description.setLocation(220, 20);
		description.setVisible(true);
		
		eqDescription = new JLabel("Equation:");
		eqDescription.setSize(300,20);
		add(eqDescription);
		eqDescription.setLocation(10, 100);
		eqDescription.setVisible(true);
		
		ansDescription = new JLabel("Solution");
		ansDescription.setSize(300,20);
		add(ansDescription);
		ansDescription.setLocation(10, 150);
		ansDescription.setVisible(true);
		
		A = new JTextField();
		A.setSize(30,20);
		add(A);
		A.setLocation(100,100);
		A.setVisible(true);
		A.setEditable(true);
		
		B = new JTextField();
		B.setSize(30,20);
		add(B);
		B.setLocation(170,100);
		B.setVisible(true);
		B.setEditable(true);
		
		C = new JTextField();
		C.setSize(30,20);
		add(C);
		C.setLocation(240,100);
		C.setVisible(true);
		C.setEditable(true);
		
		D = new JTextField();
		D.setSize(30,20);
		add(D);
		D.setLocation(310,100);
		D.setVisible(true);
		D.setEditable(true);
		
		E = new JTextField();
		E.setSize(30,20);
		add(E);
		E.setLocation(380,100);
		E.setVisible(true);
		E.setEditable(true);
		
		xsquared = new JLabel("x^2 +");
		xsquared.setSize(50,20);
		add(xsquared);
		xsquared.setLocation(130, 100);
		xsquared.setVisible(true);
		
		x = new JLabel("x +");
		x.setSize(50,20);
		add(x);
		x.setLocation(200, 100);
		x.setVisible(true);
		
		ysquared = new JLabel("y^2 +");
		ysquared.setSize(50,20);
		add(ysquared);
		ysquared.setLocation(270, 100);
		ysquared.setVisible(true);
		
		y = new JLabel("y +");
		y.setSize(50,20);
		add(y);
		y.setLocation(340, 100);
		y.setVisible(true);
		
		end = new JLabel("= 0");
		end.setSize(50,20);
		add(end);
		end.setLocation(410, 100);
		end.setVisible(true);
		
		
		type = new JTextField();
		type.setSize(100,20);
		add(type);
		type.setLocation(100,150);
		type.setVisible(true);
		type.setEditable(false);
		
		center = new JTextField();
		center.setSize(100,20);
		add(center);
		center.setLocation(100,200);
		center.setVisible(true);
		center.setEditable(false);
		
		Solve = new SolveButton();
		Solve.setBounds(450,100,100,25);
		add(Solve);
		Solve.setVisible(true);
		Solve.setToolTipText("Click to show solution");
		
	}
	
	
	public static void showEquation() {
		
	}
	
	
	private class SolveButton extends JButton implements ActionListener {
		SolveButton() {
			super("Solve");
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent arg0) {
			// nextGeneration(); // test the start button
			if (this.getText().equals("Solve")) {
			//	Conics.setEquation(c, A.getText());
				type.setText(Conics.getShape(c));
				center.setText(Conics.getCenter(c));
			} else {
				setText("Start");
			}
		}
	}
	
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
