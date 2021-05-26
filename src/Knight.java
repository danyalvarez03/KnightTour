/*
 * File: Knight.java
 * 
 * Programmer: Daniel A. Alvarez
 */

/** Implements a Knight that moves through the Chessboard
 */
public class Knight {
    
    private int currentRow;      // current row where the knight is located
    private int currentColumn;   // current column where the knight is located
    
    // all possible moves in a column
    private static final int [] colMoves = 
            new int[] {2, 1, -1, -2, -2, -1, 1, 2};
    
    // all possible moves in a row
    private static final int [] rowMoves = 
            new int[] {-1, -2, -2, -1, 1, 2, 2, 1};
    
    /** Create a knight object and set it to the position (0,0) in the table
     * 
     */
    public Knight()
    {
        currentRow = 0;       // set row to 0
        currentColumn = 0;    // set colummn to 0
    }
    
    /** Get the current row where the knight is located
     * 
     * @return - the row where the knight is located
     */
    public int getRow()
    {
        return currentRow;
    }
    
    /** Get the current column where the knight is located
     * 
     * @return - the column where the knight is located
     */
    public int getColumn()
    {
        return currentColumn;
    }
    
    /** Determine whether a move is legal or not
     * 
     * @param board - the board in which the knight is located
     * @param moveNum - the number of the move
     * @return - a boolean, true if the move is legal, false if is not
     */
    public boolean canMove(Chessboard board, int moveNum)
    {
        // move the row by the desired number
        int possibleRow = currentRow + rowMoves[moveNum];
        
        // move the column by the desired number
        int possibleColumn = currentColumn + colMoves[moveNum];
         
        // check if the new position is legal and return the result
        return board.isLegal(possibleRow, possibleColumn);
    }
    
    /** Moves the knight to the first legal location
     * 
     * @param moveNum - the number of the move
     */
    public void move(int moveNum)
    {
        // get the horizontal movement and update the current location
        currentRow = currentRow + rowMoves[moveNum];
        // get the vertical movement and update the current location
        currentColumn = currentColumn + colMoves[moveNum];
    }
}