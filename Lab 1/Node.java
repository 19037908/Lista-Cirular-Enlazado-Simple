/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularlistlabone;

/**
 *
 * @author morag
 */
public class Node {

    String value;   // node data

    Node next;

    /**
     *
     * Constructor that initialize the value of the variables.
     */
    public void Node() {
        this.value = "";
        this.next = null;
    }

    // get y set methods
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
