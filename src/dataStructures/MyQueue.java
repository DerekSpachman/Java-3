/*
 * Queues follow a first in first out policy. This means thatr the first 
 * element to enter the queue will be the first to leave the queue. This 
 * queue uses linked list technique.
 * 
 * @author Derek Spachman
 */
package dataStructures;

public class MyQueue<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;
    
    public MyQueue(){ first = last = null; }
    
    
    public MyQueue(T data) { 
        last = null;
        first = new Node(data, last); 
    } 
    
    /**
     * Places data at the end of the queue.
     * @param data is information to be stored. 
     */
    public void queue(T data) {
        if(empty())
            first = new Node(data, last);
        else if(last == null) {
            Node node = new Node(data, null);
            first.setLink(node);
            last = node;
        }
        else {
            Node node = new Node(data, null);
            last.setLink(node);
            last = node;
        }
        size++;
    }
    
    /**
     * Retrieves and removes data from the front of the queue.
     * @return data from the front of the queue.
     */
    public T deQueue() {
        if(!empty()){
            T data = first.getData();
            first = first.getLink();
            size--;
            return data;
        }
        return null;
    }
    
    /**
     * Returns 1 based number of nodes in the queue.
     * @return size of queue.
     */
    public int size() { return size; }
    
    /**
     * Returns data stored at front of queue without removing the element, or
     * null if empty.
     * @return data at front of queue or null.
     */
    public T peek() { return first.getData(); }
    
    /**
     * If queue is empty returns true else returns false.
     * @return true if queue is empty.
     */
    public boolean empty() { return first == null; }
    
    /**
     * Checks if queue contains the given data and returns true if it does.
     * @param data is the element to be searched for.
     * @return true if data exists in queue, else false.
     */
    public boolean contains(T data) {
        Node<T> node = first;
        while(node != null) {
            if(node.getData().equals(data))
                return true;
            node = node.getLink();
        }
        return false;
    }
    
    /**
     * Empties the queue.
     */
    public void clear() { first = last = null; }
    
    @Override
    public String toString() {
        String toReturn = "";
        if(!empty()){
            Node node = first;
            while(node != null){
                toReturn += node.getData().toString()+" ";
                node = node.getLink();
            }
        }
        return toReturn;
    }
    
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        
        q.queue("q");
        q.queue("u");
        q.queue("e");
        q.queue("u");
        q.queue("e");
        q.toString();
        System.out.println(q.toString());
        
        System.out.println("Dequeue returns and removes: "+q.deQueue());
        
        System.out.println("Peek returns: "+q.peek());
        
        System.out.println("Contains \'e\': "+q.contains("e"));
        System.out.println("Contains \'f\': "+q.contains("f"));
        
        System.out.println("Queue size is: "+q.size());
        
        System.out.println("Queue is empty: "+q.empty());
        
        System.out.println("Dequeued all elements.");
        q.deQueue(); q.deQueue(); q.deQueue(); q.deQueue();
        
        System.out.println("Queue is empty: "+q.empty());
    }
}