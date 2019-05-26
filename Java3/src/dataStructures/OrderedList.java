/*
 * 
 
package dataStructures;
import java.util.Comparator;


public class OrderedList<T> implements Comparator<Node<T>>{

    private int size;
    private Node<T> first;
    
    
    public int search(T e){
        int i = 1;
        for (Node temp = first; temp != null; temp = temp.getLink()){
            if(temp.getData().toString().equals(e.toString()))
                return i;
            i++;
        }
        return -1;
    }
    
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

    @Override
    public int compare(Node<T> t, Node<T> t1) {
        if(Integer.valueOf(t.getData().toString()) > 
                Integer.valueOf(t1.getData().toString()))
            return 1;
        else if(Integer.valueOf(t.getData().toString()) < 
                Integer.valueOf(t1.getData().toString()))
            return -1;
        return 0;
    }
    
}
*/