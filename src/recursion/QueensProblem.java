/*
 * Using recursion and backtracking, this class will find and print all 
 * placements of queens on a board of given dimension.
 * 
 * @author Derek Spachman (2019)
 */
package recursion;

public class QueensProblem {
    private int board[][];
    private int size;
    
    /**
     * Board will be 4x4 which has only two solutions.
     */
    public QueensProblem() {
        size = 4;
        board = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                board[i][j] = 0;
    }
    
    
    /**
     * Board will be size x size.
     * @param size 
     */
    public QueensProblem(int size) {
        this.size = size;
        board = new int[size][size];
    }
    
    /**
     * Checks if queen is able to be placed in this row.
     * @param row the row to be checked.
     * @return false if a row contains a queen.
     */
    private boolean rowCheck(int row) {
        for (int i = 0; i < size; i++)
            if(board[row][i] == 1)
                return false;
        return true;
    }
    
    /**
     * Checks if queen is able to be placed in this column.
     * @param column the row to be checked.
     * @return false if a column contains a queen.
     */
    private boolean columnCheck(int column) {
        for (int i = 0; i < size; i++)
            if(board[i][column] == 1)
                return false;
        return true;
    }
    
    /**
     * Follows a backslash '\' line to see if a queen blocks this position.
     * @param row
     * @param column
     * @return false if queen blocks placement, else true
     */
    private boolean backwardDiagonalCheck(int row, int column) {
        int i = row;
        int j = column;
        for (; i < size && j < size; i++, j++)
            if(board[i][j] == 1)
                return false;
        i = row-1;
        j = column-1;
        for (;  i >= 0 && j >= 0; i--, j--)
            if(board[i][j] == 1)
                return false;
        return true;
    }
    
    /**
     * Follows a forward slash '/' line to see if a queen blocks this position.
     * @param row
     * @param column
     * @return false if queen blocks placement, else true
     */
    private boolean forwardDiagonalCheck(int row, int column) {
        int i = row;
        int j = column;
        for (; i >= 0 && j < size; i--, j++)
            if(board[i][j] == 1)
                return false;
        i = row+1;
        j = column-1;
        for (;  i < size && j >= 0; i++, j--)
            if(board[i][j] == 1)
                return false;
        return true;
    }
    
    /**
     * Puts queens on the board. This uses recursion and backtracking
     * @param row the row that this method uses to check for other queens.
     */
    public void putQueen(int row) {
        for (int i = 0; i < size; i++) {
            if(rowCheck(row) && columnCheck(i) && 
                    backwardDiagonalCheck(row, i) && 
                    forwardDiagonalCheck(row, i)) {
                board[row][i] = 1;
                if(row < size-1)
                    putQueen(row+1);
                else
                    printBoard();
            }
            board[row][i] = 0;
        }
    }
    
    /**
     * Formats the board where 'X' is an empty tile, and 'Q' is a queen.
     */
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(board[i][j] == 0)
                    System.out.print("X");
                else
                    System.out.print("Q");
            }
            System.out.println("");
        }
        System.out.println("******************");
    }
    
    
    /**
     * Starts the putQueen method at 0.
     */
    public void find() { putQueen(0); }
    
    public static void main(String[] args) {
        QueensProblem queens = new QueensProblem();
        queens.find();
    }
}
