package ap;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Vector;

public class GenerateAPData {
	
	private final static int NUMINST = 2147483646;// number of instances generated totally for the file
	// Global constants
    private final static int TRANSC_PRES_MULTIP = 100; // Required to convert the incoming data to integer and optimise the algo using the info about the format of the values
    private final static int MULTIPLD_UPPER_BOUND = 1000000;
    private final static int MULTIPLD_LOWER_BOUND = 1; // 0.01$(minimal allowed transaction) * 100 (to int converter)
    // A specification based requirement
    private final static String OUTPUTFILE = "income.txt";
    
    // Variables
    private static int m_target = 0;  // the int-equivalent target sum  (i.e. target sum multiplied on 100)
    private static int n_size = 0;    // the real size of the array after screening out of unsuitable values
    private static Vector<Integer> tmpVector = new Vector<Integer>(); // temp vector used to store the suitable values screened out from the given file (note that we don't know the size)
    
    public static void main(String args[]) throws IOException
    {

         //n_size = setVectReadFromFileAndTargetValue("income.txt");
    	PrintWriter fOut = new PrintWriter(OUTPUTFILE);
    	for(int i=1; i<=NUMINST; i++)
    	{
    		Random rand = new Random();
    		int randomNum = rand.nextInt((MULTIPLD_UPPER_BOUND - MULTIPLD_LOWER_BOUND) + 1) + MULTIPLD_LOWER_BOUND;
    		fOut.printf("%.2f\n",(double) randomNum/TRANSC_PRES_MULTIP);
    		//System.out.println(randomNum);
    	}
    	Random rand = new Random();
		int randomNum = rand.nextInt((MULTIPLD_UPPER_BOUND - MULTIPLD_LOWER_BOUND) + 1) + MULTIPLD_LOWER_BOUND;
		fOut.printf("%.2f",(double) randomNum/TRANSC_PRES_MULTIP);
    	fOut.close(); // the result stored
    System.out.println("The end of data generation");

    }
}
