/*
 *  
INPUT: There will be 5 sets of data. Each set will consist of a string representing an equation in general form. 
The ^ will be used to denote exponents. 
 
OUTPUT: For each set of data, print the type of figure the equation produces. If it is a circle, print the 
location of its center in ordered pair format (x,y) and its radius. If it is an ellipse, print the location of its center 
and the length of its major axis. If it is a hyperbola, print its center and the equation of the principal axis. If it is 
a parabola, print its vertex and the equation of the axis of symmetry
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Conics {
    static String equation = ""; // in the form Ax^2 + Bxy + Cy^2 + Dx + Ey + F = 0
    //coefficients
    int A = 0; //x^2
    int B = 0; //xy
    int C = 0; //y^2
    int D = 0; //x
    int E = 0; //y
    int F = 0; //constant
    static Stack<String> form = new Stack<String>(); // stack to check if equation is entered correctly
    static int[] indices = new int[5];
    static int[] coefficients = new int[5];
    static String type;
    static String center; // for a parabola, this is also the vertex
    static String axis; // of principal axis of hyperbola, or of symmetry of parabola
    static int length; // of either radius or major axis

    public Conics(String equation) {
    	this.equation = equation;
    }
    
    public static boolean isCoeff(String equation, String term){
    	//if the equation has given term
    	if(equation.indexOf(term) == -1){
    		return false;
    	}
    	return true;
    }
    
    public static boolean isXY(String equation){
    	//checks to see if the xy term exists (it should not)
    	if(equation.indexOf("xy") != -1){
    		return false;
    	}
    	else return true;
    }
    
    public static int[] indexTerms(String equation,int[] indices, int[] coefficients){
    	for(int i = 1;i<equation.length();++i){
    		if((equation.substring(i-1,i)).equals("x^2")){
    			coefficients[0] = Integer.parseInt(equation.substring(0,i));
    		}
    		else coefficients[0] = 0;
    	}
    	
    	for(int i = 1;i<equation.length();++i){
    		if((equation.substring(i-1,i)).equals("y^2")){
    			coefficients[2] = Integer.parseInt(equation.substring(0,i)); // probably incorrect
    		}
    	}
    	return coefficients;
    }
    
    public static void assignCoeff(String equation){
    	// assigns actual values to A B C D E F from coefficients gotten in findCoeff
    	
    }
    
	public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String     ");
        equation = br.readLine();
        equation = equation.toLowerCase();
        System.out.println("you entered: " + equation); //test
        
        //for exceptions
        try{
            int i = Integer.parseInt(br.readLine());
        } catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        } 
    }
}
