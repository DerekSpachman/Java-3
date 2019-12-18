/*
 * Node to store generic data.
 * 
 * @author Derek Spachman (2019)
 */
package dataStructures;


public class Node<T>{
    private T data;
    private Node link;

    /**
     * Creates a node with no data and no links.
     */
    Node() { 
        data = null; 
        link = null; 
    }
    
    /**
     * Creates a node with given data and link.
     * @param d generic data
     * @param l node that follows this node.
     */
    Node(T d, Node l){ 
        data = d; 
        link = l; 
    }
    
    /**
     * @return data from this node.
     */
    public T getData() { return data; }
    
    /**
     * @return the node that follows this node.
     */
    public Node getLink() { return link; }

    /**
     * Sets the data to be stored in this node.
     * @param data the data to be stored.
     */
    public void setData(T data) { this.data = data; }
    
    /**
     * Sets the node that this node is connected to.
     * @param link the following node.
     */
    public void setLink(Node link) { this.link = link; }
}