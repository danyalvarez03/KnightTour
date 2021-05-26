/*
 * File: Chessboard.java
 * 
 * Programmer: Daniel A. Alvarez
 */

/** Implements a chessboard as an 8 by 8 two-dimensional array
 */
public class Chessboard {
    
    // a 2D chessboard for the knight to move
    private int [][] chessboard;
    
    public Chessboard()
    {
        // initiate the chessboard with 8 rows and 8 columns
        chessboard = new int [8][8];
    }
    
    /** Returns a boolean that represents if the desired move is legal
     * 
     * @param futureRow - the row where the knight will move
     * @param futureColumn - the column where the knight will move
     * @return - true if the move is legal and false if the move is illegal
     */
    public boolean isLegal(int futureRow, int futureColumn )
    {
        // check if the future row and column has been visited 
        // or is out of bounds
        if (futureRow >= 0 && futureRow < 8 &&
                futureColumn >= 0 && futureColumn < 8 &&
                chessboard [futureRow][futureColumn] == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /** Change the value of the new position of the knight
     * 
     * @param row - the new row where the knight moved
     * @param column - the new column where the knight moved
     * @param number - the new value of the position
     */
    public void changeNumber(int row, int column, int number)
    {
        chessboard [row][column] = number;
    }
    
    /** Convert the chessboard into a multiline string
     * 
     * @return - the multiline string that represents the board
     */
    public String toString()
    {
        // string that contains the representation of the chessboard
        String board = "================================\n";
        
        // iterate throught the board and add each value to the string
        for (int i = 0; i < chessboard.length; i++)
        {
            for (int j = 0; j < chessboard[i].length; j++)
            {
                // add value to the string
                board = board + String.format("%2d", chessboard [i][j]) + "  ";
            }
            
            board = board + "\n";  // start a new line after each row
        }
        
        return board;
    }
}
