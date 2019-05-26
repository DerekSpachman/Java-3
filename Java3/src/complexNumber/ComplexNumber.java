/*
 * This class creates a complex number, a number with a real part and an 
 * imaginary part: 2 + 3i. Complex numbers may be added, subtracted, 
 * multiplied, divided, as well as have the magnitude found, and check for 
 * equality between two comlex numbers.
 * 
 * @author Derek Spachman (2019)
 */
package complexNumber;


public class ComplexNumber {
    private int a, b;
    
    //explicit constructor
    ComplexNumber(int a, int b){
        this.a = a;
        this.b = b;
    }
    
    /**
     * returns the sum of two ComplexNumbers.
     * @param cn is the other ComplexNumber.
     * @return a new ComplexNumber that is the sum of the two.
     */
    public ComplexNumber add(ComplexNumber cn){
        return new ComplexNumber( (a+cn.a), (b+cn.b));
    }
    
    /**
     * returns the difference of two ComplexNumbers.
     * @param cn is the other ComplexNumber.
     * @return a new ComplexNumber that is the difference of the two.
     */
    public ComplexNumber subtract(ComplexNumber cn){
        return new ComplexNumber( (a-cn.a), (b-cn.b));
    }
    
    /**
     * returns the square root of the real part squared plus the imaginary 
     * part squared.
     * @param cn is the other ComplexNumber.
     * @return a real number (double).
     */
    public double magnitude(ComplexNumber cn){
        return Math.sqrt((double)(a*a) + (double)(b*b));
    }
    
    /**
     * checks if the real parts and the imaginary parts are the same.
     * @param cn the other Complex number.
     * @return true if each part are the same else returns false.
     */
    public boolean equal(ComplexNumber cn){ return a==cn.a && b==cn.b; }
    
    /**
     * returns the product of two ComplexNumbers.
     * @param cn is the other ComplexNumber.
     * @return a new ComplexNumber that is the product of the two.
     */
    public ComplexNumber multiply(ComplexNumber cn){
        return new ComplexNumber( (a*cn.a - b*cn.b), (a*cn.b + b*cn.a) );
    }
    
    /**
     * returns the quotient of two ComplexNumbers.
     * @param cn is the other ComplexNumber.
     * @return a new ComplexNumber that is the quotient of the two.
     */
    public ComplexNumber divide(ComplexNumber cn){
        return new ComplexNumber( (a*cn.a + b*cn.b)/(cn.a*cn.a + cn.b*cn.b), 
                (b*cn.a - a*cn.b)/(cn.a*cn.a + cn.b*cn.b) );
    }
    
    /**
     * returns format a+bi.
     * @return a string representation of this ComplexNumber.
     */
    @Override
    public String toString(){ return a+"+"+b+"i"; }
}
