/*
 * A large number of simple recursive projects are contained in this class. 
 * 
 * @author Derek Spachman
 */
package recursion;

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
     * Determines if a given word contains "elf".
     * @param word word to be checked if it contains "elf".
     * @param index current index of word.
     * @param count number of correct characters.
     * @return true if word contains "elf" else false.
     */
    public static boolean elfish(String word, int index, int count) {
        if(count == 3)
            return true;
        if(word.charAt(index) != "elf".charAt(count))
            count = 0;
        if(word.charAt(index) == "elf".charAt(count))
            count++;
        return elfish(word, index+1, count);
    }
    
    /**
     * Determines if a given word contains x.
     * @param word word to be checked if it contains x.
     * @param index current index of word.
     * @param x word of interest.
     * @param count number of correct characters.
     * @return true if word contains x else false.
     */
    public static boolean xish(String word, int index, String x, int count) {
        if(x.equals(x))
            return true;
        if(word.charAt(index) != x.charAt(count)) {
            x = "";
            count = 0;
        }
        if(word.charAt(index) == x.charAt(count)){
            x += word.charAt(index);
            count++;
        }
        return xish(word, index+1, x, count);
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
        
    }
    
    /**
     * Recursively finds all subsets of a given word.
     * 
     * @author Derek Spachman
     */
    public class Subsets {
        private String word;
        private int index;
        private String subsets;
        
        /**
         * The initial constructor.
         * @param word is the word to be broken apart.
         */
        public Subsets(String word) {
            this.word = word;
            index = 0;
            subsets = word+" ";
        }
        
        /**
         * The constructor to be called during recursion.
         * @param word is the word to be broken apart.
         * @param index is where the current recursion stage is along word.
         * @param subset is the collection of subsets.
         */
        public Subsets(String word, int index, String subset) {
            this.word = word;
            this.index = index;
            subsets = subset;
        }
        
        /**
         * @return all the subsets currently discovered.
         */
        public String getSubsets() { return subsets; }
        
        /**
         * Method that actually finds the subsets.
         * @return all the subsets of the word.
         */
        public String findSubset() {
            if(index == word.length()-1){
                return subsets+" "+word.charAt(index)+" { }";
            }
            System.out.println(word.charAt(index));
            subsets += " "+word.charAt(index);
            return new SimpleRecursion.Subsets(word, ++index, subsets).findSubset();
        }
    }
    
    /**
     * This class provides an instance version of the ancientSquareRoot() in 
     * the SimpleRecurssion class.
     */
    public class AncientAlgorithm {
        private double base;
        private double guess;
        private int index;
        
        /**
         * Constructor
         * @param base base number.
         * @param guess user guess that increases in accuracy with each
         * recursive stage.
         * @param index number of times the recursion will occur.
         */
        public AncientAlgorithm(double base, double guess, int index) {
            this.base = base;
            this.guess = guess;
            this.index = index;
        }
        
        /**
         * @return the square root of the given attributes.
         */
        public double squareRoot() {
            if(index <= 1)
                return (guess+base/guess)/2;
            return new SimpleRecursion.AncientAlgorithm(base, 
                    (guess+base/guess)/2, index-1).squareRoot();
        }
    }
}