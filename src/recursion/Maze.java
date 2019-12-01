/*
 *
 *  
 * @author Derek Spachman (2019)
 */

package recursion;
import java.util.Scanner;

public class Maze {
    private int size;
    private char maze[][];
    
    /**
     * Lets user fill the maze. 1s are walls, 0s are paths, s is starting 
     * point (there may only be one), and e is the end (also only one).
     * @param size both number of rows and columns.
     */
    public Maze(int size) {
        this.size = size;
        maze = new char[size][size];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                maze[i][j] = scan.nextLine().charAt(0);
    }
    
    /**
     * Selects one of the two pre-made mazes.
     * @param size both the number of rows and columns.
     * @param choice true for 5 x 5 maze, false for 11 x 11 maze.
     */
    public Maze(int size, boolean choice) {
        this.size = size;
        maze = new char[size][size];
        sampleMaze(choice);
    }
    
    
    public void move(int i, int j) { 
        maze[i][j] = 'p';
        System.out.println(this.toString());
        if(!theEndIsNear(i, j)) {
            if(j+1 < size && maze[i][j+1] == '0') {//move right
                move(i, j+1);
                //maze[i][j] = '0';
            }
            else if(i+1 < size && maze[i+1][j] == '0') {//move down
                move(i+1, j);
                //maze[i][j] = '0';
            }
            else if(i-1 >= 0 && maze[i-1][j] == '0') {//move up
                move(i-1, j);
                //maze[i][j] = '0';
            }
            else if(j-1 >= 0 && maze[i][j-1] == '0') {//move left
                move(i, j-1);
                //maze[i][j] = '0';
            }
            //maze[i][j] = '0';
        }
        maze[i][j] = '0';
        return;
        //return this.toString();
    }
    
    
    private boolean theEndIsNear(int i, int j) {
        if(j+1 < size && maze[i][j+1] == 'e' ||
                i+1 < size && maze[i+1][j] == 'e' ||
                j-1 >= 0 && maze[i][j-1] == 'e' ||
                i-1 >= 0 && maze[i-1][j] == 'e')
            return true;
        return false;
    }
    
    /**
     * @return formated maze as a String.
     */
    @Override
    public String toString() {
        String toReturn = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                toReturn += maze[i][j];
            toReturn += '\n';
        }
        return toReturn;
    }
    
    
    public static void main(String[] args) {
        Maze maze = new Maze(11, false);
        //System.out.println(maze.move(3, 0));
        maze.move(3, 0);
    }
    
    
    /**
     * Two pre-made mazes.
     * @param choice true for 5 x 5, false for 11 x 11.
     */
    private void sampleMaze(boolean choice) {
        if(choice) {
            char temp[][] = {
                {'1', '1', '1', '1', '1'},
                {'s', '0', '1', '0', '1'},
                {'1', '0', '1', '0', 'e'},
                {'0', '0', '0', '0', '1'},
                {'1', '1', '1', '1', '1'}
            };
            maze = temp;
        }
        else  {
            char temp[][] = {
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '0', '0', '0', '0', '1', '0', '0', '0', '1'},
                {'1', '0', '1', '0', '0', '0', '1', '0', '1', '0', '1'},
                {'S', '0', '1', '0', '0', '0', '0', '0', '1', '0', '1'},
                {'1', '0', '1', '1', '1', '1', '1', '0', '1', '0', '1'},
                {'1', '0', '1', '0', '1', '0', '0', '0', '1', '0', '1'},
                {'1', '0', '0', '0', '1', '0', '1', '0', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '0', '1', '0', '0', '0', '1'},
                {'1', '0', '1', 'e', '1', '0', '1', '0', '0', '0', '1'},
                {'1', '0', '0', '0', '0', '0', '1', '0', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}
            };
            maze = temp;
        }
    }
}
