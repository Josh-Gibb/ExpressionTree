/**
 * @author Josh Gibb
 * Node.java
 */
public class Node {
    // Declaring all variables needed in the node
    String data;
    Node left = null;
    Node right = null;
    
    // Constructor, giving the node a data value
    public Node(String data){
        this.data = data;
    }
    
    // Overload Constructor, when the method has three parameters
    public Node(String data, Node right, Node left){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    //toString displays the data of the node
    public String toString(){
        return data;
    }
}
