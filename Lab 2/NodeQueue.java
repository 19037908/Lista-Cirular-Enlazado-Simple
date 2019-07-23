public class NodeQueue {
    String name, id;  // se definen los datos que tendra el nodoCola
    int age;        
    NodeQueue next;
    
    public NodeQueue() { // se inicializan en vacio, 0, null segun el tipo de dato
        this.name = "";
        this.id = "";
        this.age = 0;
        next = null;  
    }
    // metodos gett and set, clase NodoCola

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public NodeQueue getNext() {
        return next;
    }

    public void setNext(NodeQueue next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Name: " + name+", "+"ID: "+id + ", " + "Age: " + age;
    }
}