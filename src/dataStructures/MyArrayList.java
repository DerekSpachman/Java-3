/*
 * 
 */
package dataStructures;


public class MyArrayList<T>{
    private T array[];
    private int size;
    private int length;
    private int DEFAULT_LENGTH = 10;
    
    /**
     * Default constructor.
     */
    MyArrayList(){
        size = 0;
        length = 10;
        array = (T[])(new Object[DEFAULT_LENGTH]);
    }
    
    /**
     * Explicit constructor that uses a given length.
     * @param l is a given length to initialize an array.
     */
    MyArrayList(int l){
        length = l;
        size = 0;
        array = (T[])(new Object[length]);
    }
    
    /**
     * Returns the element at the given index.
     * @param index is the index for the array.
     * @return the element at the given index in the array. 
     */
    public T get(int index){
        if(index > size)
            System.out.println(errorMessages.Errors.arrayOutOfBounds());
        return array[index];
    }
    
    /**
     * Adds an element to the end of MyArrayList.
     * @param e element to be added.
     */
    public void add(T e){
        if(size == length)
            increaseLength();
        array[size] = e;
        size++;
    }
    
    /**
     * Adds a given element to a given index and appends the element currently 
     * at that index to the end of the MyArrayList.
     * @param index to place a given element at.
     * @param e is the element to be placed at the given index.
     */
    public void add(int index, T e){
        if(index >= size)
            System.out.println(errorMessages.Errors.arrayOutOfBounds());
        else{
            T temp = array[index];
            array[index] = e;
            array[size] = temp;
            size++;
        }
    }
    
    /**
     * Used to increase the length of array once the and length are equal.
     */
    private void increaseLength(){
        length += length/2;
        T temp[] = array;
        array = (T[])new Object[length];
        for (int i = 0; i < size; i++)
            array[i] = temp[i];
    }
    
    /**
     * Replaces the current element at the given index with the given element.
     * @param index to the position of interest.
     * @param e is the element to be placed at the given index.
     */
    public void set(int index, T e){
        if(index > size)
            System.out.println(errorMessages.Errors.arrayOutOfBounds());
        array[index] = e;
    }
    
    /**
     * Clears the MyArrayList.
     */
    public void clear(){
        size = 0;
        array = (T[])new Object[length];
    }
    
    
    /**
     * Checks if MyArrayList contains anything.
     * @return if MyArrayList contains anything.
     */
    public boolean isEmpty(){ return size == 0; }
    
    
    public void remove(T e){
        boolean found = false;
        T temp[] = (T[])new Object[size-1];
        for (int i = 0; i < size; i++) {
            if( !found && array[i].toString().equals(e))
                found = true;
            else if(!found)
                temp[i] = array[i];
            else //if(found)
                temp[i-1] = array[i];
        }
        if(found){
            size--;
            array = temp;
        }
    }
    
    /**
     * Removes the element at the given index and returns what was at that 
     * position.
     * @param index in MyArrayList to be deleted.
     * @return the element that was removed
     */
    public T remove(int index){
        if(index >= size)
            System.out.println(errorMessages.Errors.arrayOutOfBounds());
        else{
            T toReturn = array[index];
            T temp[] = (T[])new Object[size-1];

            for (int i = 0; i < size; i++) {
                if(i < index)
                    temp[i] = array[i];
                else if(i > index)
                    temp[i-1] = array[i];
            }
            array = temp;
            size--;
            return toReturn;
        }
        return (T)"";
    }
    
    /**
     * Displays the MyArrayList in a String.
     * @return the String representation of MyArrayList.
     */
    @Override
    public String toString(){
        String s = "";
        for (int i = 0; i < size; i++) 
            s+= array[i]+" ";
        return s;
    }
    
    /**
     * returns the size of MyArrayList.
     * @return size.
     */
    public int getSize(){ return size; }
    
    
    public static void main(String[] args){
        MyArrayList a = new MyArrayList(5);
        
        //add(T e)
        a.add('a');
        a.add('b');
        a.add('c');
        a.add('d');
        a.add('e');
        a.add('f');
        a.add('g'); //will be full
        a.add('h');
        System.out.println(a.toString());
        
        //add(int index, T e)
        a.add(0, 'z');
        System.out.println("a.add(0, 'z'): "+a.toString());
        a.add(8, 'x');
        System.out.println("a.add(8, 'x'): "+a.toString());
        
        //remove(int index)
        a.remove(0);
        System.out.println("a.remove(0): "+a.toString());
        a.remove(a.getSize()-1);
        System.out.println("a.remove(a.getSize()-1): "+a.toString());
        
        //set(int index)
        a.set(7, 'i');
        System.out.println("a.set(7, 'i'): "+a.toString());
        
        //get(int index)
        System.out.println("a.get(0): "+a.get(0));
        
        //remove(T e)
        a.remove("b");
        System.out.println("a.remove(\"b\"): "+a.toString());
        a.remove("i");
        System.out.println("a.remove(\"i\"): "+a.toString());
        
        //isEmpty()
        System.out.println("isEmpty(): "+a.isEmpty()+", array: "+a.toString());
        
        //clear() then isEmpty()
        a.clear();
        System.out.println("clear() then isEmpty(): "+a.isEmpty()+", array: "+a.toString());
    }
}