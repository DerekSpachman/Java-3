/*
 *
 *
 * @author Derek Spachman
 */
package recursion;

import java.util.Iterator;
import java.util.Stack;

public class SimpleRecursion {
    
    /**
     * Recursively finds the power of a base number.
     * @param base
     * @param exponent
     * @return the value of the base raised to the exponent. 
     */
    public static double power(double base, double exponent) {
        if(exponent > 0) {
            if(exponent % 2 == 0) { //if even
                double number = power(base, exponent/2);
                return number * number;
            }
            else //if exponent is odd
                return base * power(base, --exponent);
        }
        else if(exponent < 0)
            return 1/power(base, -exponent);
        return  1; //if(exponent == 0) //base case
    }
    
    /**
     * Recursively searches a given array that is sorted in ascending order.
     * @param array pre-sorted in ascending order.
     * @param data integer value being searched.
     * @param index starting point. 
     * @return the index the data is found or -1 if data is not in array.
     */
    public static int search(int array[], int data, int index) {
        if(index >= array.length)
            return -1;
        else if(array[index] == data)
            return index;
        return search(array, data, index+1);
    }
    
    /**
     * This is an ancient algorithm for solving the square root of a 
     * nonnegative number. This uses static recursion.
     * @param base number taking the square root of.
     * @param guess the guess the the user takes.
     * @param index number of times equation is used to achieve a more precise 
     * number.
     * @return an increasingly correct guess to the actual square root of a
     * given base based on the initial index.
     */
    public static double ancientSquareRoot(double base, double guess, int index) {
        if(index <= 1)
            return (guess+base/guess)/2;
        return ancientSquareRoot(base, (guess+base/guess)/2, index-1);
    }
    
    /**
     * 
     * @param word
     * @param index
     * @param elf
     * @param i
     * @return 
     */
    public static boolean elfish(String word, int index, String elf, int i) {
        if(elf.equals("elf"))
            return true;
        if(word.charAt(index) != "elf".charAt(i)) {
            elf = "";
            i = 0;
        }
        if(word.charAt(index) == "elf".charAt(i)){
            elf += word.charAt(index);
            i++;
        }
        return elfish(word, index+1, elf, i);
    }
    
    
    public static boolean xish(String word, int index, String x, int i) {
        if(x.equals(x))
            return true;
        if(word.charAt(index) != x.charAt(i)) {
            x = "";
            i = 0;
        }
        if(word.charAt(index) == x.charAt(i)){
            x += word.charAt(index);
            i++;
        }
        return elfish(word, index+1, x, i);
    }
    
    
    
    
    
    public static void main(String[] args) {
        SimpleRecursion simpleRecursion = new SimpleRecursion();
        /*
        //2 4 8 16 32 64 128 256 512 1024 2048
        System.out.println("2^11 = "+power(2, 11));
        System.out.println("2^-3 = "+power(2, -3));
        
        System.out.println("");
        
        int size = 10;
        int array[] = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = i*2;
        System.out.println(search(array, 8, 0));
        
        System.out.println("")
        
        //17.5, 15.8928, 15.8116, 15.8114
        System.out.println(ancientSquareRoot(250, 10, 4));
        SimpleRecursion.AncientAlgorithm ancientAlgorithm = 
                simpleRecursion.new AncientAlgorithm(250, 10, 3);
        System.out.println(ancientAlgorithm.squareRoot());
        
        System.out.println();
        
        System.out.println(elfish("delf", 0, "", 0));
        System.out.println(elfish("deelf", 0, "", 0));
        
        System.out.println();
        
        System.out.println(xish("abcd", 0, "abcd", 0));
        System.out.println(xish("x123", 0, "xx123", 0));
        
        System.out.println();
        */
        SimpleRecursion.Subsets ob = simpleRecursion.new Subsets("word");
        //System.out.println(ob.findSubset());
        
        //System.out.println("");
        
        SimpleRecursion.Hanoi hanoi = simpleRecursion.new Hanoi(3);
        System.out.println(hanoi.play(hanoi));
    }
    
    
    public class Subsets {
        private String word;
        private int index;
        private String subsets;
        
        public Subsets(String word) {
            this.word = word;
            index = 0;
            subsets = word+" ";
        }
        
        public Subsets(String word, int index, String subset) {
            this.word = word;
            this.index = index;
            subsets = subset;
        }
        
        
        public String getSubsets() { return subsets; }
        
        public String findSubset() {
            if(index == word.length()-1){
                return subsets+" "+word.charAt(index)+" { }";
            }
            System.out.println(word.charAt(index));
            subsets += " "+word.charAt(index);
            return new SimpleRecursion.Subsets(word, ++index, subsets).findSubset();
        }
    }
    
    /*
     * This class provides an instance version of the ancientSquareRoot() in 
     * the SimpleRecurssion class.
     */
    public class AncientAlgorithm {
        private double base;
        private double guess;
        private int index;
        
        public AncientAlgorithm(double base, double guess, int index) {
            this.base = base;
            this.guess = guess;
            this.index = index;
        }
        
        public double squareRoot() {
            if(index <= 1)
                return (guess+base/guess)/2;
            return new SimpleRecursion.AncientAlgorithm(base, 
                    (guess+base/guess)/2, index-1).squareRoot();
        }
    }
    
    
    public class Hanoi {
        private int disks; //number of disks
        private Stack peg1;
        private Stack peg2;
        private Stack peg3;
        
        public Hanoi(int size) {
            disks = size;
            peg1 = new Stack();
            peg2 = new Stack();
            peg3 = new Stack();
            for (int i = disks-1; i >= 0; i--)
                peg1.push(i);
        }
        
        
        public String play(Hanoi hanoi) {
            if(gameOver())
                return this.toString();
            //change object
            return this.toString()+"\n\n"+play(hanoi);
            
        }
        
        
        //move method
        public void move() {
            //if() {
                
            //}
        }
        
        
        private boolean validMove() {
            //if()
                
            return false;
        }
        
        
        private boolean gameOver() { 
            int p1, p2, p3;
            p1 = p2 = p3 = 0;
            
            for(Iterator itr = peg1.iterator(); itr.hasNext(); itr.next())
                p1++;
            if(p1 == disks)
                return true;
            
            for(Iterator itr = peg2.iterator(); itr.hasNext(); itr.next())
                p2++;
            if(p2 == disks)
                return true;
            
            for(Iterator itr = peg3.iterator(); itr.hasNext(); itr.next())
                p3++;
            if(p3 == disks)
                return true;
            
            return false;
        }
        
        
        @Override
        public String toString() {
            Iterator itr1 = peg1.iterator();
            Iterator itr2 = peg2.iterator();
            Iterator itr3 = peg3.iterator();
            
            String toReturn ="peg1\tpeg2\tpeg3\n-------------------------\n";
            while(itr1.hasNext() || itr2.hasNext() || itr3.hasNext()) {
                if(itr1.hasNext())
                    toReturn += itr1.next()+"\t";
                else
                    toReturn += " \t";
                if(itr2.hasNext())
                    toReturn += itr2.next()+"\t";
                else
                    toReturn += " \t";
                if(itr3.hasNext())
                    toReturn += itr3.next();
                toReturn += "\n";
            }
            
            return toReturn;
        }
        
    }
}
