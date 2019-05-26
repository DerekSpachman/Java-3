/*
if r == c
 /

package matrix;

public class Matrix {
    private int rows, columns;
    private double array[][];
    
    Matrix(int r, int c){
        rows = r;
        columns = c;
        array = new double[r][c];
        for (int i = 0; i < r; i++) 
            for (int j = 0; j < c; j++) 
                array[i][j] = 0;
    }
    
    public void setEntry(int r, int c, double value){ array[r][c] = value; }
    
    public Matrix add(Matrix m){
        if(rows != m.columns)
            throw dimensionMismatch;
        
        double newArray[][] = new double[rows][m.columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < m.columns; j++)
                newArray[i][j] = array[i][j]+m.array[i][j];
        
    }
}
*/
