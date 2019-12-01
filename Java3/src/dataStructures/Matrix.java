/*
 * This class allows for manipulation of Matricies through a variety of means.
 * 
 * @author Derek Spachman (2019)
*/

package dataStructures;

import java.util.Comparator;

public class Matrix implements Comparable<Matrix>, Comparator<Matrix> {
    private int rows, columns;
    private int array[][];
    
    /**
     * Initializes an empty Matrix then fills it with zeros.
     * @param r number of rows.
     * @param c number of columns.
     */
    Matrix(int r, int c){
        rows = r;
        columns = c;
        array = new int[rows][columns];
        for (int i = 0; i < rows; i++) 
            for (int j = 0; j < columns; j++) 
                array[i][j] = 0;
    }
    
    /**
     * Fills the Matrix at the given index with the given value.
     * @param r row index.
     * @param c column index.
     * @param value to be set at index.
     */
    public void setEntry(int r, int c, int value){ array[r][c] = value; }
    
    /**
     * @param row index for the row.
     * @param column index for the column.
     * @return value stored at the given index.
     */
    public int getEntry(int row, int column) { 
        if(row > rows || column > columns)
            throw new exceptionHandler.IndexOutOfBoundsException("Given index does not exist");
        return array[row][column];
    }
    
    /**
     * Adds two Matricies together and returns the sum as a Matrix.
     * @param m the second Matrix.
     * @return the sum as a Matrix.
     */
    public Matrix add(Matrix m){
        if(rows != m.columns)
            throw new exceptionHandler.IndexOutOfBoundsException("Matricies cannot be added due to demensions.");
        
        Matrix newMatrix = new Matrix(rows, m.columns);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < m.columns; j++)
                newMatrix.setEntry(i, j, array[i][j]+m.array[i][j]);
        return newMatrix;
    }
    
    /**
     * Subtracts two Matricies and returns the difference as a Matrix.
     * @param m the second Matrix.
     * @return the difference as a Matrix.
     */
    public Matrix subtract(Matrix m){
        if(rows != m.columns)
            throw new exceptionHandler.IndexOutOfBoundsException("Matricies cannot be subtracted due to demensions");
        
        Matrix newMatrix = new Matrix(rows, m.columns);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < m.columns; j++)
                newMatrix.setEntry(i, j, array[i][j]-m.array[i][j]);
        return newMatrix;
    }
    
    /**
     * Multiplies this and a given Matrix together then returns the product.
     * @param m the other Matrix.
     * @return the product of the two matrixes together.
     */
    public Matrix multiply(Matrix m) {
        if(columns != m.rows)
            throw new exceptionHandler.IndexOutOfBoundsException("Matricies cannot be multiplied due to demensions");
        
        Matrix product = new Matrix(rows, m.columns);
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < m.columns; j++)
                product.setEntry(i, j, this.getEntry(i, j)*m.getEntry(i, j)
                        +product.getEntry(i, j));
        return product;
    }
    
    /**
     * Check if a given Matrix is the exact same.
     * @param m the other Matrix.
     * @return true if they are equal.
     */
    public boolean equals(Matrix m) {
        if(rows == m.rows && columns == m.columns) {
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < columns; j++)
                    if(this.getEntry(i, j) != m.getEntry(i, j))
                        return false;
            return true;
        }
        return false;
    }
    
    /**
     * Reverses this Matrix and returns it.
     * @return the reversed Matrix.
     */
    public Matrix transpose() {
        Matrix transpose = new Matrix(rows, columns);
        int index1, index2;
        index1 = index2 = 0;
        for (int i = rows-1; i >= 0; i--) {
            for (int j = columns-1; j >= 0; j--) {
                transpose.setEntry(index1, index2, this.getEntry(i, j));
                index2++;
            }
            index2 = 0;
            index1++;
        }
        return transpose;
    }
    
    /**
     * Determines which matrix has a larger sum.
     * @param matrix the other matrix that this one is compared to.
     * @return if equal 0, if the sum of this matrix is greater than the given
     *      matrix 1, else -1.
     */
    @Override
    public int compareTo(Matrix matrix) {
        double sum1, sum2;
        sum1 = sum2 = 0;
        
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                sum1 += Math.abs(array[i][j]);
        for (int i = 0; i < matrix.rows; i++)
            for (int j = 0; j < matrix.columns; j++)
                sum2 += Math.abs(matrix.getEntry(i, j));
        
        if(sum1 < sum2)
            return -1;
        if(sum1 > sum2)
            return 1;
        return 0;
    }
    
    /**
     * Determines which matrix has a larger sum.
     * @param m1 this matrix.
     * @param m2 the other matrix that this one is compared to.
     * @return if equal 0, if the sum of this matrix is greater than the given
     *      matrix -1, else 1.
     */
    @Override
    public int compare(Matrix m1, Matrix m2) { return m1.compareTo(m2) * -1; }
    
    /**
     * Formats the data stored in Matrix as one would expect to see it.
     * @return the Matrix in a formated String.
     */
    @Override
    public String toString() {
        String toReturn = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                toReturn += array[i][j]+" ";
            toReturn += "\n";
        }
        return toReturn;
    }
    
    
    public static void main(String[] args) {
        Matrix m = new Matrix(2, 3);
        Matrix m1 = initalizeMatrix(1);
        Matrix m2 = initalizeMatrix(2);
        Matrix m3 = initalizeMatrix(3);
        Matrix m4 = initalizeMatrix(4);
        Matrix m5 = new Matrix(2, 2);
        Matrix m6 = new Matrix(2, 2);
        
        /*
        System.out.println("Matrix 1\n"+m1.toString()+"\nMatrix 2\n"+m2.toString());
        Matrix added = m1.add(m2);
        System.out.println("added");
        System.out.println(added.toString());
        
        System.out.println("subtracted");
        Matrix subtracted = m1.subtract(m2);
        System.out.println(subtracted.toString());
        
        System.out.println("Matrix 1 and Matrix 2 are equal: "+m1.equals(m2));
        System.out.println("New Matrix 1 is equal to a new Matrix 2: "
                + new Matrix(4, 4).equals(new Matrix(4, 4))+"\n");///////////////////////////////////////
        
        System.out.println("Matrix 3\n"+m3.toString()+"\nMatrix 4\n"+m4.toString());
        System.out.println("multiplied");
        Matrix multiplied = m3.multiply(m4);
        System.out.println(multiplied.toString());
        
        System.out.println("Matrix 1\n"+m1+"\ntranspose\n"+m1.transpose());
        
        System.out.println("m1 compareTo m2: "+m1.compareTo(m2));
        System.out.println("m1 compareTo m3: "+m1.compareTo(m3));
        System.out.println("m1 compareTo m1: "+m1.compareTo(m1));
        
        System.out.println("Compare m1, m2: "+m1.compare(m1, m2));
        System.out.println("Compare m1, m3: "+m1.compare(m1, m3));
        System.out.println("Compare m1, m1: "+m1.compare(m1, m1));
        */
        
    }
    
    /**
     * Four example matrixes.
     * @param option which of the four matrixes is to be selected.
     * @return the example matrix.
     */
    private static Matrix initalizeMatrix(int option) {
        Matrix m = new Matrix(3, 2);
        if(option == 1) { //25
            m.setEntry(0, 0, 2);    m.setEntry(0, 1, 5);
            m.setEntry(1, 0, -3);   m.setEntry(1, 1, 8);
            m.setEntry(2, 0, 7);    m.setEntry(2, 1, 5);
        }
        else if(option == 2) { //32
            m.setEntry(0, 0, -3);   m.setEntry(0, 1, 10);
            m.setEntry(1, 0, 2);    m.setEntry(1, 1, 8);
            m.setEntry(2, 0, 9);    m.setEntry(2, 1, 0);
        }
        else if(option == 3) { //12
            m = new Matrix(2, 3);
            m.setEntry(0, 0, 1);    m.setEntry(0, 1, 2);    m.setEntry(0, 2, 3);
            m.setEntry(1, 0, 3);    m.setEntry(1, 1, 2);    m.setEntry(1, 2, 1);
        }
        else if(option == 4) {
            m.setEntry(0, 0, 2);    m.setEntry(0, 1, 5);
            m.setEntry(1, 0, -3);   m.setEntry(1, 1, 8);
            m.setEntry(2, 0, 7);    m.setEntry(2, 1, 5);
        }
        return m;
    }
}