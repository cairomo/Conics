/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 



/* TextDemo.java requires no other files. */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Display extends JPanel implements ActionListener {

    protected static JTextField textField;
    protected static JTextArea textArea;
    private final static String newline = "\n";
    
    public static final int ROWS = 80;
	public static final int COLS = 100;
	private final int X_GRID_OFFSET = 25; // 25 pixels from left
	private final int Y_GRID_OFFSET = 200; // 40 pixels from top
	private final int GRID_WIDTH = 5;
	private final int GRID_HEIGHT = 5;

	// Note that a final field can be initialized in constructor
	private final int DISPLAY_WIDTH = 800; 
	private final int DISPLAY_HEIGHT = 600;
	private StartButton startStop;
	private ClearButton Clear;
	private boolean paintloop = false;

    public Display(int DISPLAY_WIDTH, int DISPLAY_HEIGHT) {
        super(new GridBagLayout());
        

        textField = new JTextField(DISPLAY_WIDTH);
        textField.setToolTipText("enter in the form Ax^2 + Bxy + Cy^2 + Dx + Ey + F = 0");
        textField.addActionListener(this);

        textArea = new JTextArea(40, DISPLAY_WIDTH);
        textArea.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        add(textField, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
        
    }
    public void init() {
		setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);

		// Example of setting up a button.
		// See the StartButton class nested below.
		startStop = new StartButton();
		startStop.setBounds(100, 550, 100, 36);
		add(startStop);
		startStop.setVisible(true);

		//Clear button
		Clear = new ClearButton();
		Clear.setBounds(300, 550, 100, 36);
		add(Clear);
		Clear.setVisible(true);

		repaint();
	}
    
    public void paintComponent(Graphics g) {
		final int TIME_BETWEEN_REPLOTS = 100; // change to your liking

		g.setColor(Color.GRAY);
		drawGrid(g);
		drawButtons();

		if (paintloop) {
			try {
				Thread.sleep(TIME_BETWEEN_REPLOTS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
		repaint();
	}
    
    void drawGrid(Graphics g) {
		for (int row = 0; row <= ROWS; row++) {
			g.drawLine(X_GRID_OFFSET,
					Y_GRID_OFFSET + (row * (GRID_HEIGHT + 1)), X_GRID_OFFSET
					+ COLS * (GRID_WIDTH + 1), Y_GRID_OFFSET
					+ (row * (GRID_HEIGHT + 1)));
		}
		for (int col = 0; col <= COLS; col++) {
			g.drawLine(X_GRID_OFFSET + (col * (GRID_WIDTH + 1)), Y_GRID_OFFSET,
					X_GRID_OFFSET + (col * (GRID_WIDTH + 1)), Y_GRID_OFFSET
					+ ROWS * (GRID_HEIGHT + 1));
		}
	}

    
    private void drawButtons() {
		startStop.repaint();
	}

    public void actionPerformed(ActionEvent evt) {
        textArea.append(Conics.type + newline);
        textArea.append(Conics.center + newline);
        textArea.append(Conics.length + newline);
        textArea.append(Conics.axis + newline);
        textField.selectAll();

        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
    
    public String getEquation(ActionEvent evt) {
    	return textField.getText();
    }
    
    private class StartButton extends JButton implements ActionListener {
		StartButton() {
			super("Start");
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent arg0) {
			// nextGeneration(); // test the start button
			if (this.getText().equals("Start")) {
				setText("Stop");
				repaint();
				
			} else {
				togglePaintLoop();
				setText("Start");
			}
		}

	}
	private class ClearButton extends JButton implements ActionListener {
		ClearButton() {
			super("Clear");		
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent arg0) {
			// nextGeneration(); // test the start button
			for(int ROW = 0;ROW <100; ROW++){
				for(int col = 0; col < 80; col++) {
					//clear graph somehow
					repaint();
				}

			}

		
		}
	
	
	}
	
    public void togglePaintLoop() {
		paintloop = !paintloop;
	}

	public void setPaintLoop(boolean value) {
		paintloop = value;
	}


    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Conics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        frame.add(new Display(70,40));
        
        frame.add(textField, BorderLayout.NORTH);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
