import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;

import javax.swing.JColorChooser;

public class Conics {
	//coefficients
	private double x2 = 0;
	private double x = 0;
	private double y2 = 0;
	private double y = 0;
	private double constant = 0;
	private String type = "";
    static int[] indices = new int[5];
    static int[] coefficients = new int[5];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Conics(double x2, double y2, double x, double y, double constant, String type) {
    	this.x2 = x2; // in the form Ax^2 + Bxy + Cy^2 + Dx + Ey + F = 0
    	this.x = x;
    	this.y2 = y2;
    	this.y = y;
    	this.constant = constant;
    	this.type = type;
    }
  
    
    public double getX2() {
    	return this.x2;
    }
    
    public double getX() {
    	return this.x;
    }
    
    public double getY2() {
    	return this.y2;
    }
    
    public double getY() {
    	return this.y;
    }
  
    public double getConstant() {
    	return this.constant;
    }
    
    
    public boolean isInt(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        }
        return true;
    }
    
    public double getCenterX() {
    	if(this.getType() != "parabola") {
    		return (- this.getX() / (2 * this.getX2()));
    	} else {
    		if(this.getX2() != 0) {
    			return (- this.getX() / (2 * this.getX2()));
    		} else {
    			return (- this.getY() / (2 * this.getX2()));
    		}
    	}
 
    }
    
    public double getCenterY() {
    	if(this.getType() != "parabola") {
    		return (- this.getY() / (2 * this.getX2()));
    	} else {
    		if(this.getX2() != 0) {
    			return (- (this.getConstant() - this.getX() * this.getX() / (4 * this.getX2())) / ( -  this.getY()));
    		} else {
    			return (- (this.getConstant() - this.getY() * this.getY() / (4 * this.getY2())) / ( -  this.getX()));
    		}
    	}
    	
    }
    


    
    public String getType() {
    	if(this.getX2() != 0 && this.getY2() != 0) {
    		if((this.getX2() > 0 && this.getY2() < 0) ||
    				(this.getX2() < 0 && this.getY2() > 0)) {
    			this.setType("hyperbola");
    		} else if(this.getX2() == this.getY2()) {
    			this.setType("circle");
    		} else {
    			this.setType("ellipse");
    		}
    	} else {
    		this.setType("parabola");
    	}
    	return this.type;
    }

    /*
    public static void initCoeff(Conics c) {
    	Character[] co = new Character[getEquation(c).length()];
    	for(int i = 0;i<co.length;++i) {
    		co[i] = new Character(getEquation(c).charAt(i));
    	}
    	
    	Stack<Integer> temp = new Stack<Integer>();
    	
    	for(int i = 0;i<co.length;++i) {
    			temp.add(Integer.parseInt((co[i].toString())));
    	
    		}
    	String s = "";
    	for(int i = 0;i<co.length;++i) {
    		if(isInt(co[i].toString())) {
    			s += co[i];
    		} else if(co[i].equals('^') || co[i].equals('+') || co[i].equals('-') || co[i].equals('=')) {
    			if(co[i].equals('^')) {
    				c.numCaret++;
    				c.numOps++;
    			}
    			if(getFirstOp(c).equals(null)) {
    				setFirstOp(c,co[i].toString());
    			}
    			getOp(c).add(co[i].toString());
    		} else if(co[i].equals('x') || co[i].equals('Y') || co[i].equals('X') || co[i].equals('y')) {
    			if(co[i].equals('x') || co[i].equals('X')) {
    				//c.x2co = co[i];
    				c.numX++;
    			}
    			if(co[i].equals('y') || co[i].equals('Y')) {
    				c.numY++;
    			}
    			getTerms(c).add(co[i].toString());
    			getCoeff(c).add(Integer.parseInt(s));
    			s = "";
    		}
    	}
    	if(getTerms(c).elementAt(0).equals('x') || getTerms(c).elementAt(0).equals('X')) {
    		
    	}
    } */
    	
    public void setType(String s) {
    	this.type = s;
    }
    
    public String getCenter(Conics c) {
    	
    	int xcoord = 0;
    	int ycoord = 0;
    	//change to use xco, y2co, etc instead of really long stuff like this
    	/*
    	 
    			(getTerms(c).elementAt(0).equals('X') && getTerms(c).elementAt(1).equals('x'))) {
    		xcoord = -(( getCoeff(c).elementAt(1) / getCoeff(c).elementAt(0) ) / 2 ) * (( getCoeff(c).elementAt(1) / getCoeff(c).elementAt(0) ) / 2 );
    	} else if(getTerms(c).elementAt(1).equals('y') && getTerms(c).elementAt(2).equals('Y') || 
    			getTerms(c).elementAt(1).equals('Y') && getTerms(c).elementAt(2).equals('y')) {
    		ycoord = -(( getCoeff(c).elementAt(2) / getCoeff(c).elementAt(1) ) / 2 ) * (( getCoeff(c).elementAt(2) / getCoeff(c).elementAt(1) ) / 2 );
    	}
    	return "(" + Integer.toString(xcoord) +  "," + Integer.toString(ycoord) + ")"; */
    	return "";
    }
    
    
    /*
    public static void init() {
        System.out.print("Enter String     ");
        try {
			equation = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        equation = equation.toLowerCase();
        System.out.println("you entered: " + equation); //test
    } */
    
}
