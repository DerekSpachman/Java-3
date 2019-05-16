/*
 * A Stck in Java is a data structure that contains a stack of Objects. Stacks
 * follow a first in last out policy. This stck uses doublely linked list.
 */
package dataStructures;

public class MyStack<T> {
    private Node last;
    private Node first;
    private int size;
    
    /**
     * Default constructor. Initializes first and last to null and size to 0.
     */
    MyStack(){
        last = first = null;
        size = 0;
    }
    
    /**
     * Checks if the stack is empty. 
     * @return true if stack is empty, else it returns false.
     */
    public boolean empty(){ return first == null; }
    
    /**
     * Returns the element on top of the stack without deleting it.
     * @return the element on top of the stack.
     */
    public T peek(){ return (T)last.getData(); }
    
    /**
     * Removes and returns the top element from the stack.
     * @return the top element from the stack.
     */
    public T pop(){
        T toReturn = null;
        if(!empty()){
            if(!last.equals(first)){
                toReturn = (T)last.getData();
                Node previous = first;
                for (; previous.getLink() != last; 
                        previous = previous.getLink()){ }
                previous.setLink(last.getLink());
                last = previous;
                size--;
            }
            else{
                toReturn = (T)last.getData();
                last = first = null; 
            }
        }
        return toReturn;
    }
    
    /**
     * pushes the given element on top of the stack.
     * @param e is the element to be pushed on top of the stack.
     */
    public void push(T e){
        if(!empty()){
            Node newlast = new Node(e, null);
            last.setLink(newlast);
            last = newlast;
        }
        else{
            last = new Node(e, null);
            first = last;
        }
    }
    
    /**
     * An index+1 of where this element is located, is returned.
     * @param e is the element being searched for.
     * @return the index+1 of where the element is found. -1 if element is not 
     * found. 
     */
    public int search(T e){
        int i = 1;
        for (Node temp = first; temp != null; temp = temp.getLink()){
            if(temp.getData().toString().equals(e.toString()))
                return i;
            i++;
        }
        return -1;
    }
    
    /**
     * A String representation of MyStack in top down order.
     * @return a String representation of MyStack in top down order.
     */
    @Override
    public String toString(){
        String toReturn = "";
        for (Node temp = first; temp != null; temp = temp.getLink())
            toReturn = temp.getData().toString()+" "+toReturn;
        return toReturn;
    }
    
    
    public static void main(String[] args){
        MyStack stack = new MyStack();
        
        //push(T e)
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');
        System.out.println("MyStack: "+stack.toString());
        
        //peek()
        System.out.println("peek: "+stack.peek());
        
        //search(T e)
        System.out.println("search('a'): "+stack.search('a'));
        System.out.println("search('c'): "+stack.search('c'));
        System.out.println("search('z'): "+stack.search('z'));
        
        //empty()
        System.out.println("empty: "+stack.empty());
        
        //pop()
        System.out.println("pop: "+stack.pop());
        System.out.println("pop: "+stack.pop());
        System.out.println("pop: "+stack.pop());
        System.out.println("pop: "+stack.pop());
        System.out.println("pop: "+stack.pop());
        
        //empty()
        System.out.println("empty: "+stack.empty());
    }
}
