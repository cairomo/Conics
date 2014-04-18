import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;

import javax.swing.JColorChooser;

public class Conics {
	String equation;
	String shape = "parabola";
	Stack<Integer> coeff;
	Stack<String> op;
	Stack<String> terms;
	String firstOp = "";
	int numX = 0;
	int numY = 0;
	int numCaret = 0;
	//coefficients
	int x2co = 0;
	int xco = 0;
	int y2co = 0;
	int yco = 0;
	int constant = 0;
	int numOps = 0;
    static int[] indices = new int[5];
    static int[] coefficients = new int[5];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Conics(String equation) {
    	this.equation = equation; // in the form Ax^2 + Bxy + Cy^2 + Dx + Ey + F = 0
    	this.shape = shape;
    	this.coeff = coeff;
    	this.op = op;
    	this.terms = terms;
    	this.firstOp = firstOp;
    	this.numX = numX;
    	this.numY = numY;
    	this.numCaret = numCaret;
    	this.numOps = numOps;
    	this.x2co = x2co;
    	this.xco = xco;
    	this.y2co = y2co;
    	this.yco = yco;
    	this.constant = constant;
    }
    
    public static String getEquation(Conics c) {
    	return c.equation;
    }
    
    public static void setEquation(Conics c, String eq) {
    	c.equation = eq;
    }
    
    public static String getFirstOp(Conics c) {
    	return c.firstOp;
    }
    
    public static void setFirstOp(Conics c, String f) {
    	c.firstOp = f;
    }
    
    public static void setNumX(Conics c, int x) {
    	c.numX = x;
    }
    
    public static int getNumX(Conics c) {
    	return c.numX;
    }
    
    public static void setNumY(Conics c, int y) {
    	c.numX = y;
    }
    
    public static int getNumY(Conics c) {
    	return c.numY;
    }
    
    public static int getNumCaret(Conics c) {
    	return c.numCaret;
    }
    
    public static Stack<String> getTerms(Conics c) {
    	return c.terms;
    }
    
    public static String peekOp(Conics c) {
    	return c.op.peek();
    }
    
    public static Stack<String> getOp(Conics c) {
    	return c.op;
    }
    
    public static void setCoeff(Conics c,int ind,int val) {
    	c.coeff.add(ind, val);
    }
    
    public static int getTopCoeff(Conics c) {
    	return c.coeff.peek();
    }
    
    public static int getX2Co(Conics c) {
    	return c.x2co;
    }
    
    public static int getXCo(Conics c) {
    	return c.xco;
    }
    
    public static int getY2Co(Conics c) {
    	return c.y2co;
    }
    
    public static int getyCo(Conics c) {
    	return c.yco;
    }
    
    public static int getNumOps(Conics c) {
    	return c.numOps;
    }
    
    public static int getConstant(Conics c) {
    	return c.constant;
    }
    
    public static Stack<Integer> getCoeff(Conics c) {
    	return c.coeff;
    }
    
    public static boolean isInt(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        }
        return true;
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
    	
    public static void setShape(Conics c, String s) {
    	c.shape = s;
    }
    
    public static String getShape(Conics c) {
    	if(getFirstOp(c).equals("-")) {
    		setShape(c,"hyperbola");
    	}
    	if(getFirstOp(c).equals("+")) {
    		setShape(c,"ellipse");
    	}
    	if(getNumCaret(c) < 2) {
    		setShape(c,"parabola");
    	}
    	if(getOp(c).elementAt(getNumOps(c)-1).equals('=') || peekOp(c) == null) {
    		setShape(c,"not a conic section");
    	}
    	
    	return c.shape;
    }

    public static String getCenter(Conics c) {
    	
    	int xcoord = 0;
    	int ycoord = 0;
    	//change to use xco, y2co, etc instead of really long stuff like this
    	if((getTerms(c).elementAt(0).equals('x') && getTerms(c).elementAt(1).equals('X')) || 
    			(getTerms(c).elementAt(0).equals('X') && getTerms(c).elementAt(1).equals('x'))) {
    		xcoord = -(( getCoeff(c).elementAt(1) / getCoeff(c).elementAt(0) ) / 2 ) * (( getCoeff(c).elementAt(1) / getCoeff(c).elementAt(0) ) / 2 );
    	} else if(getTerms(c).elementAt(1).equals('y') && getTerms(c).elementAt(2).equals('Y') || 
    			getTerms(c).elementAt(1).equals('Y') && getTerms(c).elementAt(2).equals('y')) {
    		ycoord = -(( getCoeff(c).elementAt(2) / getCoeff(c).elementAt(1) ) / 2 ) * (( getCoeff(c).elementAt(2) / getCoeff(c).elementAt(1) ) / 2 );
    	}
    	return "(" + Integer.toString(xcoord) +  "," + Integer.toString(ycoord) + ")";
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
