/*
 * 
 */
package dataStructures;


public class Node<T>{
    private T data;
    private Node link;

    //explicit constructor
    Node(T d, Node l){ data = d; link = l; }
    
    //accessors
    public T getData() { return data; }
    public Node getLink() { return link; }

    //mutators
    public void setData(T data) { this.data = data; }
    public void setLink(Node link) { this.link = link; }
}