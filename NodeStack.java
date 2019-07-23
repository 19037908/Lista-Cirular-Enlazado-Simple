public class NodeStack {
    Queue QuequeAddStack;   // se menciona como atributo de la clase nodoPila , una instancia de cola
    NodeStack next;   // se define un puntero de la misma clase 

    public NodeStack() {
        this.QuequeAddStack = null;    // cola y puntero inicializados en null
        next = null;
    }
    // metodos gett and set, clase nodopila
    public Queue getQuequeaddStack() {
        return QuequeAddStack;
    }

    public void setQuequeaddStack(Queue quequeaddStack) {
        this.QuequeAddStack = quequeaddStack;
    }

    public NodeStack getNext() {
        return next;
    }

    public void setNext(NodeStack next) {
        this.next = next;
    }

}