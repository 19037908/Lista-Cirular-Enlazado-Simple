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
public class List {

    Node start; // start of the list

    Node last; // pointer that indicates the end of the list

    public void List() {   // constructor
        start = null;
        last = null;

    }

    public boolean Empty() {   // ask if the list is empty
        return start == null;
    }

    public int Long() {     // method will be calculated the long of te list
        int count = 0;

        if (!Empty()) {     // check if there are items in the list

            Node aux = start; // copy of de list

            do {

                aux = aux.getNext();  // go to the next node
                count++;
            } while (aux != start);      // while aux is different to inicio, cause that was happened , tell us the list is in the last position

        }
        return count;
    }

    public void addToFinal(String value) {  //  to the final of the list

        Node ne = new Node();  //  create a new node

        ne.setValue(value);  //  add the value to the node

        if (Empty()) {

            start = ne;        // this algorithm tries to identify if there are nodes in the list, 
            // if they dont exist the new node will be indicated by the start and end pointers
            last = ne;

            last.setNext(start);   // and the pointer of the last one must be pointer to the start like a circular list right

        } else {

            last.setNext(ne);     //We point with the last node of the list to the new one

            ne.setNext(start); // we point with the new node at the beginning of the list

            last = ne;   // as now, the new node is the last updated last variable

        }

    }

    public void InsertforPos(int position, String value) {

        if (position >= 0 && position <= Long()) {    // check if the entered position is in the range
            Node ne = new Node();
            ne.setValue(value);

            if (position == 0) {   //check if the new node to be entered goes to the beginning of the list

                ne.setNext(start); // join the new node with the existing list

                start = ne;// rename the new node as the start of the list

                last.setNext(start); //the pointer of the last one must point to the first one
            } else {

                if (position == Long()) {  // add node to the end

                    last.setNext(ne);  // pointer with the las node to the new

                    ne.setNext(start); // pointer with the new node to the start of the list

                    last = ne; // update variable
                } else {

                    Node aux = last;

                    for (int i = 0; i < (position - 1); i++) {   // Scroll through the list until you reach the previous node
                        // to the position in which the new node will be inserted
                        aux = aux.getNext();
                    }

                    Node next = aux.getNext();       //save the next node to the node in the position
                    // in which you are going to insert the new node

                    aux.setNext(ne); // add to the new node at the position previusly suplier

                    ne.setNext(next);  // join the new node with the rest of the list.
                }
            }

        }
    }

    public void ShowAll() {

        if (!Empty()) {

            Node aux = start;

            System.out.print("-> ");

            do {                                                 //  Scroll through the list until you reach the beginning of the list again.

                System.out.print("[ " + aux.getValue() + " ]" + " ->  "); // print the value of the node

                aux = aux.getNext();     // keep going to the next node  

            } while (aux != start);
            System.out.println("");
        }
    }

    public void DeleteAll() {     // reestart the pointer(see the constructor) of start and last one

        start = null;

        last = null;

    }

    public void RemoveForPos(int position) { //check the insert for position method

        if (position >= 0 && position < Long()) {
                                                   //this is the same, only you have to deviate the pointer of the value that you want to erase 
            if (position == 0) {

                start = start.getNext();

                last.setNext(start);
            } else {

                Node aux = start;

                for (int i = 0; i < position - 1; i++) {
                    aux = aux.getNext();
                }
                if (aux.getNext() == last) {
                    aux.setNext(start);
                    last = aux;
                } else {

                    Node siguiente = aux.getNext();

                    aux.setNext(siguiente.getNext());

                }
            }

        }
    }

    public void ChangeDataForPos(int position, String value) {
      
        if (position >= 0 && position < Long()) {
           
            if (position == 0) {
             
                start.setValue(value);
            } else {
              
                Node aux = start;
           
                for (int i = 0; i < position; i++) {
                    aux = aux.getNext();
                }
              
                aux.setValue(value);
            }
        }
    }

    public void Find(String reference) {
        
        Node aux = start;
        int cont = 0;
        boolean flag = false;      // flag declare for know if has been an a coicidence
     
        do {
          
            if (reference.equals(aux.getValue())) {
                
                flag = true;

            } else {
                
                aux = aux.getNext();   
                cont++;               // count the nodes between the start to the reference

            }
        } while (aux != start);
        if (flag == true) {
            System.out.println("Dato encontrado a " + cont + " posiciones del inicio");
        } else {
            System.out.println("Dato no encontrado");
        }

    }

    public void Order(List l) {
        Node aux = start;
        String aux2, let;
        int pos = 0;

        char a;

        do {
            for (int j = 97; j < 123; j++) {
                a = (char) j;                      // ASCI 
                String aux1 = aux.getValue();
                aux1 = aux1.toLowerCase();
                let = aux1.substring(0, 1);

                if (let.charAt(0) == a) {                   // INCOMPLETE
                    l.ChangeDataForPos(pos, aux1);

                    pos++;
                }

            }
            aux = aux.getNext();
        } while (aux != start);
        l.ShowAll();
    }
}
