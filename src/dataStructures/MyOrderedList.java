/*
 * Works much like the MyArrayList using an array to store info but keeps 
 * data ordered.
 * 
 * @author Derek Spachman (2019)
 */
package dataStructures;

import java.util.Comparator;

public class MyOrderedList<T> {//implements Comparator{
    private T array[];
    private int size;
    private int length;
    
    /**
     * Length starts at 100.
     */
    MyOrderedList() {
        size = 0;
        length = 100;
        array = (T[]) new Object[size];
    }
    
    
    public void add(T data) {
        if(size == length-1) {
            T temp[] = array;
            length += length/2;
            array = (T[]) new Object[length];
            array = temp;
        }
        
        array[size] = data;
        size++;
    }

    /*
    @Override
    public int compare(Object t, Object t1) {
        
    }
    */
    
    
}
