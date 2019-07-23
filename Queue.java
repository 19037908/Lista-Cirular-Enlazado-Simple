public class Queue {

    NodeQueue start, end; // se crea un Nodo simulando un punteros en C , inicio y fin

    public Queue() {
        start = end = null;  // se inicializan los atributos en el constructor
    }

    public boolean Empty() {  // funcion que sirve para determinar si esta vacia la cola
        return start == null;
    }

    public void AddNodeToQueue(String name, String id, int age) {   // añade un nodo en cola en la ultima posicion 
        NodeQueue newie = new NodeQueue();  // se crea un nodoCola llamado novato
        newie.setName(name);     // se le asigna el nombre
        newie.setID(id);      // rut
        newie.setAge(age); // y edad
        if (Empty()) {  // se pregunta si esta vacia la cola, de ser asi ingresa
            start = newie;  // el puntero inicio ahora apunta al nuevo nodo
        } else {   // si no esta vacia entra
            end.setNext(newie);  // el puntero fin del ultimo nodo, apuntara al nuevo nodo
        }
        end = newie;   // se actualiza el ultimo nodo, apuntandolo con end
    }

    public boolean Unique(String id) { // valor unico
        NodeQueue traveler = start;  // se instancia un nococola, apuntandolo al inicio de esta
        while (traveler != null) {  // mientras el nodo sea distinto a vacio recorrer
            if (traveler.getID().equals(id)) { // si el nodo viajero encuentra un id igual 
                return true;        // retornara un verdadero
            }
            traveler = traveler.getNext();  // continua avanzando el puntero hasta llegar a vacio
        }                    
        return false;   // si no retornara un falso
    }
// metodos gett and set, clase cola
    public NodeQueue getStart() {
        return start;
    }

    public void setStart(NodeQueue start) {
        this.start = start;
    }

    public NodeQueue getEnd() {
        return end;
    }

    public void setEnd(NodeQueue end) {
        this.end = end;
    }
}