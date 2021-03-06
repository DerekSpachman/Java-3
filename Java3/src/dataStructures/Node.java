/*
 * Node to store generic data.
 * 
 * @author Derek Spachman (2019)
 */
package dataStructures;


public class Node<T>{
    private T data;
    private Node link;

    //constructors
    Node() { data = null; link = null; }
    Node(T d, Node l){ data = d; link = l; }
    
    //accessors
    public T getData() { return data; }
    public Node getLink() { return link; }

    //mutators
    public void setData(T data) { this.data = data; }
    public void setLink(Node link) { this.link = link; }
}