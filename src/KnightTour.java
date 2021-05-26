/*
 * File: Knight.java
 * 
 * Programmer: Daniel A. Alvarez
 */

/** Implements the tours that the knight makes
 */

import java.util.ArrayList;
import java.util.Random;

public class KnightTour {
    
    private int longestTour;        // the number of moves in the longest tour
    private int longestTourNumber;      // the number of the longest tour
    private String longestTourBoard;    // the board for the longest tour
    private int [] numberOfTours;   // stores the number of tour of each length
    
    /** Initialize instance variables and construct a KnightTour object
     * 
     */
    public KnightTour()
    {
        longestTour = 0;               // set the longest tour to 0
        longestTourNumber = 0;         // set the longest tou number to 0
        longestTourBoard = "";         // initialize the board string
        numberOfTours = new int[64];   // set numberOfTour to a length of 64
    }
    
    /** Creates a Chessboard and a Knight, 
     * and makes the Knight move until it has no more possible moves
     * 
     * @param tours - amount if tours that the user desires
     */
    public void conductTour(int tours)
    {   
        // conduct the number of tours that the user entered
        for (int i = 0; i < tours; i++)
        {
            Chessboard board = new Chessboard();  // create a Chessboard object
            Knight knight = new Knight();         // create a Knight object;
            
            // create a tour length counter
            int currentTourLength = 1;
        
            // set the location (0,0) to be the first in the tour
            board.changeNumber( 0, 0, 1);
            
            // create an ArrayList to store attempted moves
            ArrayList<Integer> attempMoves= new ArrayList<Integer>();
        
            // create a random object
            Random gen = new Random();
            
            // take random moves from 0 to 7 until one works, or none work
            while(attempMoves.size() < 8)
            {
                // generate a random number from 0 to 7
                int randMove = gen.nextInt(8);
            
                // check if the current random move hasn't been attempted before
                if(!attempMoves.contains(randMove) && 
                        knight.canMove(board, randMove))
                {
                    knight.move(randMove);   // move the knight
                    currentTourLength++;     // add one move to the counter
                
                    // update the position on the board
                    board.changeNumber(knight.getRow(), 
                        knight.getColumn(),currentTourLength);
                        
                    attempMoves.clear();     // clear the attempted moves
                        
                }
                else if(!attempMoves.contains(randMove))
                {
                    // add the move to the list of attempted moves
                    attempMoves.add(randMove);
                }
            }
        
            // check if the last tour was the longest
            if (currentTourLength > longestTour)
            {
                // store the last tour as the longest
                longestTour = currentTourLength;
            
                // store the last board as the longest
                longestTourBoard = board.toString();
                
                // add the number of the longest tour
                longestTourNumber = i + 1;
            }
       
            // add one to the count of tours of the same length
            numberOfTours[currentTourLength] = 
                    numberOfTours[currentTourLength] + 1;
        }    
    }    
    
    /** Creates a multiline string that contains the the longest tour length,
     * a string representation of its board,
     * and the number of tours of each length
     * 
     * @return - the string containing the longest tour 
     * and the number of tours of each length
     */
    public String printResults()
    {
        // create a string to store the number of tours of each length
        String amountOfTours = "Tour Length    Number of Tours\n" + 
                "===========    ===============\n";
        
        // traverse the numberOfTours array
        for (int i = 0; i < 64; i++)
        {
            // check if there are no tours of this length
            if (numberOfTours[i] != 0)
            {  
                // add all the tours of each length to the string
                amountOfTours = amountOfTours + String.format("%7d", i) + 
                        String.format("%16d", numberOfTours[i]) + "\n";
            }    
        }
        
        // create a string that displays the length and the board of the tour
        String longestTourString = "Tour #" + longestTourNumber + 
                "\nTour Length: " + longestTour + 
                "\n" + longestTourBoard;
        
        return longestTourString + "\n\n" + amountOfTours;
    }
}
