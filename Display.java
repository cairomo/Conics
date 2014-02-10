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
	private JTextField eqField;
	private JTextField answer;
	private JLabel eqDescription;
	private JLabel ansDescription;
	Conics c = new Conics("4x^2 + 16y^2 + 3x + 4y = 0");
	
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
		
		eqField = new JTextField();
		eqField.setSize(100,20);
		add(eqField);
		eqField.setLocation(100,100);
		eqField.setVisible(true);
		eqField.setEditable(true);
		
		answer = new JTextField();
		answer.setSize(100,20);
		add(answer);
		answer.setLocation(100,150);
		answer.setVisible(true);
		answer.setEditable(false);
		
		Solve = new SolveButton();
		Solve.setBounds(200,100,100,25);
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
				showEquation();
				
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
