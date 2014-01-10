import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Conics {
    static String equation = ""; // in the form Ax^2 + Bxy + Cy^2 + Dx + Ey + F = 0
    //coefficients
    int A = 0; //x^2
    int B = 0; //xy
    int C = 0; //y^2
    int D = 0; //x
    int E = 0; //y
    int F = 0; //constant
    static String x2 = "x^2";
    static String xy = "xy";
    static String y2 = "y^2";
    static String x = "x";
    static String y = "y";
    String[] terms = new String[]{x2,xy,y2,x,y};
    //probably a lot of unnecessary variables?
    
    public static boolean isCoeff(String equation, String term){
    	//if the equation has given term
    	if(equation.indexOf(term) == -1){
    		return false;
    	}
    	return true;
    }
	
    public static int findCoeff(String equation, String term){
		//finds x^2 coefficient and returns it as an integer
    	int index, coeff, prev;
    	index = equation.indexOf(term);
    	prev = 
    	coeff = Integer.parseInt(equation.substring(0,index)); //substring should not be (0,index) because that works for only the x^2 coefficient
    	return coeff;
    }
    
    public static int[] indexTerms(String equation,String[] terms){
    	
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
        if(isCoeff(equation, x2)) System.out.println("the " + x2 + " coefficient is " + findCoeff(equation, x2)); //test
        
        //for exceptions
        try{
            int i = Integer.parseInt(br.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
        
        
        
    }
	
	
}
