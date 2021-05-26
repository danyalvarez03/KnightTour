
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/*
 * File: Knight.java
 * 
 * Programmer: Daniel A. Alvarez
 */

/** A test class for The Knight's Tour program
 */
public class KnightTourTester {

    /** Main method of the KnightTourTester class
     * 
     */
    public static void main(String[] args) throws FileNotFoundException 
    { 
        // create a new file to store the output
        File outputFile = new File ("output.txt");
        
        // create a PrintWriter object
        PrintWriter outFile = new PrintWriter(outputFile);
        
        // create a KnightTour object
        KnightTour tours = new KnightTour();
        
        // ask the user to enter the desired number of tours
        String input = JOptionPane.showInputDialog("How many tours"
                + " should the knight make?");
        
        // convert the number of tours to an integer
        int numberOfTours = Integer.parseInt(input);
        
        // conduct the amount of tours that the user asked
        tours.conductTour(numberOfTours);
        
        // print the results to the console
        System.out.println("The Best Tour (of " + numberOfTours + ")\n\n" +
                tours.printResults());
        
        // print the results to the output file
        outFile.println("The Best Tour (of " + numberOfTours + ")\n\n" +
                tours.printResults());
        
        outFile.close();   // close the output file
    }
    
}
