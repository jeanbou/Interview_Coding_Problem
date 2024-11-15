package find_payments;

import java.util.*;
import java.io.*;

/**
* This class dedicate to efficient resolving of the Accounting Dilemma a specific case of well-known SubSum problem
* @author Ivan BUDNYK
* @version 1.0
*/

public class FindPayments {

    // Global constants
    private final static int TRANSC_PRES_MULTIP = 100; // Required to convert the incoming data to integer and optimise the algo using the info about the format of the values
    private final static int MULTIPLD_UPPER_BOUND = 1000000;
    private final static int MULTIPLD_LOWER_BOUND = 1; // 0.01$(minimal allowed transaction) * 100 (to int converter)
    // A specification based requirement
    private final static String OUTPUTFILE = "output.txt";
    
    // Variables
    private static int m_target = 0;  // the int-equivalent target sum  (i.e. target sum multiplied on 100)
    private static int n_size = 0;    // the real size of the array after screening out of unsuitable values
    private static Vector<Integer> tmpVector = new Vector<Integer>(); // temp vector used to store the suitable values screened out from the given file (note that we don't know the size)

    private static int setVectReadFromFileAndTargetValue(String aIncomingFileNameStr) throws IOException
    {
       /**
       * This method conducts smart reading of the given file using optimising screening out procedure
       * It sets the target sum values and set tmpVector
       * @param str The incoming file name
       * @return num The size of the data vector
       *             Negative return value indicates the type of error
       *             Zero means that there is only one matching transaction and there is no need to conduct calculation
       */

        // Get input
        Scanner fInScanner = new Scanner(new FileReader(aIncomingFileNameStr));
        int aRealVectorSize = 0;
        // Read the first target sum value, having a target value help us to slightly optimise the code
        if (fInScanner.hasNextFloat())
        {
           m_target = Math.round(fInScanner.nextFloat()*TRANSC_PRES_MULTIP); // Converted target value
        }
        else
        {
           System.out.println("Error (1) :: The read instance does not represent any float value, please re-check your incoming file");
           return -1;
        }
        int aUpperBoundInt = Math.min(MULTIPLD_UPPER_BOUND, m_target);
        // Read the rest of the file and put it SMARTLY into the data array while screening the values out
        while (fInScanner.hasNextLine())
        {
           if (fInScanner.hasNextFloat())
           {
              int aValueInt = Math.round(fInScanner.nextFloat()*TRANSC_PRES_MULTIP);

              // Optimisation trick, screen out the values
              if ( (aValueInt < MULTIPLD_LOWER_BOUND) || (aValueInt > aUpperBoundInt) )
              {
                   //System.out.println("Warning (1) :: The read value "+aValueInt/TRANSC_PRES_MULTIP+" skipped as it is out of range of the suitable for calculation values");
              }
              else // the value is OK
              {
                 if (m_target == aValueInt) // we are lucky
                 { // no need to process the calculation the suitable result is found by chance
                   PrintWriter fOut = new PrintWriter(OUTPUTFILE);
                   fOut.printf("%.2f\n",(double) m_target/TRANSC_PRES_MULTIP);
                   fOut.close();
                   System.out.println("A unique solution has found by scan");
                   return 0;
                 }
                 // put value into vector
                 aRealVectorSize++;
                 tmpVector.add(aValueInt);
              }
           }
           else
           {
              System.out.println("Error (2) :: The read instance does not represent any float value, please re-check your incoming file");
              return -2;
           }
        } // the end of data reading from file
        fInScanner.close();

       return aRealVectorSize;
    } // the end of getDataFromFile

    public static void main(String args[]) throws IOException
    {
        // please put correct file name if you want to run it from Eclipse
        n_size = setVectReadFromFileAndTargetValue(args[0]);

        if (n_size > 0) // there is sense to start SubSum algo
        {
            int Sentinel[]= new int[n_size+1];
            Sentinel[0] = 0; // Sentinel zero
            for (int j=1; j<=n_size; j++)
            {
               Sentinel[j] = tmpVector.get(j-1);
               //System.out.println(Sentinel[j]);
            } //System.out.println(Sentinel[0]);

            //long start_time = System.nanoTime();
            // Convert vector to an array to speed up the calculation

            // Init dynamic programming table
            int Cases[]=new int[m_target+1];
            Cases[0]=0;

            // For a possible sum it finds the smallest index such
            // that its input value is in a subset to achieve that sum.
            for (int posSum=1; posSum<=m_target; posSum++)
            {
              int j;
              for (j=1; j<=n_size; j++)
              {
                int leftover = posSum-Sentinel[j];  // To be achieved with other values
                if (leftover < 0)
                {   // Too much thrown away
                    continue;
                }
                if (Cases[leftover]== (-1))
                {   // No way to achieve leftover
                    continue;
                }
                if (Cases[leftover] < j)
                {  // Indices are included in ascending order.
                   break;
                }
              }
              Cases[posSum]= (j<=n_size) ? j : (-1);
            }
            
            //long end_time = System.nanoTime();
            //double difference = (end_time - start_time)/1e6;
            //System.out.printf("Time = %.4f ns\n",difference);
            // Storing the result
            PrintWriter fOut = new PrintWriter(OUTPUTFILE);
            if (Cases[m_target]==(-1))
            {
               System.out.println("NO SOLUTION\n");
               fOut.printf("NO SOLUTION\n");
            }
            else
            {
                for (int i=m_target;i>0;i-=Sentinel[Cases[i]])
                {
                   fOut.printf("%.2f\n",(double) Sentinel[Cases[i]]/TRANSC_PRES_MULTIP);
                }
            }
            fOut.close(); // the result stored

         } // the end of applicability dynamic programming if
         else 
         {
             //System.out.printf("Time = 0 ns\n");
             if (n_size != 0) // if n_size == 0 the solution has already found by chance
             {
                PrintWriter fOut = new PrintWriter(OUTPUTFILE);
                System.out.println("NO SOLUTION\n");
                fOut.printf("NO SOLUTION\n");
                fOut.close();
             }
         }

         
     } // the end of main

} // the end of FindPayments class

