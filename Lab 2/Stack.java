import java.io.IOException;

/**
 *
 * @author morag
 */
public class Stack {

    NodeStack top; // se crea un nodo pila, el cual indicara el valor en la parte superior de esta

    public Stack() {
        top = null;   // se inicializa el nodo en null

    }

    public void AddQueueToStack(Queue queues) {   // Metodo para añadir colas a las pilas
        NodeStack newie = new NodeStack();    // se crea un nodoPila denominado 'novato'
        newie.setQuequeaddStack(queues);      // se añade la cola a la pila
        newie.setNext(top);                 // el puntero de la nueva cola apunta a top 
        top = newie;                    // el puntero top pasa hacer el nuevo nodo
    }

    public void ShowTop() {                 // Metodo para mostrar pila (top)
        NodeStack trav = top;           // se apunta al inicio de la pila 
        NodeQueue traveQueue = top.getQuequeaddStack().getStart(); // se declara variable la cual almacenara al nodoCola que apunta al inicio de cada cola
        System.out.println("Last queue insert on Stack"); 
        while (trav != null) {    // mientras el inicio de la pila sea distinto de nulo ingresa 
            while (traveQueue != null) {    // mientras el inicio de la cola sea distinto de nulo ingresara
                System.out.println(traveQueue);    // ira mostrando el contenido de la ultima cola ingresada, a medida que el puntero avance
                traveQueue = traveQueue.getNext();  // puntero de cola avanza al siguiente nodo
            }
            trav = trav.getNext();      // puntero de pila avanza
        }
    }
// recorre la pila encontrando similitud con rut ingresado por consola, imitando los metodos anteriores 
    public boolean Unique(String id) {   // valor unico 
        NodeStack trav = top;
        NodeQueue traveQueue = top.getQuequeaddStack().getStart();
        while (trav != null) {
            while (traveQueue != null) {
                if (traveQueue.getID().equals(id)) {            
                    return true;
                }
                traveQueue = traveQueue.getNext();
            }
            trav = trav.getNext();
        }
        return false;
    }
    
    // Valga la redundancia, metodo (refactorizado) para verificar si el rut cumple el formato 
    public boolean IDFormat(String id) throws IOException { // parametro valor de tipo String
        String auxID;     // usado para guardar el rut sin modificaciones
        int aux, IDAux;     // aux guardara el tamaño del rut , la variable restante se encargara de guardar el simbolo antes del digito verificador
        int Lcount = 0, Pcount = 0;  // cuenta los guiones y puntos del rut   
        auxID = id; // copia original del rut

        for (int f = 0; f < id.length(); f++) { // este ciclo sirve para recorrer el string, desde el primer caracter hasta el ultimo
            if (id.charAt(f) == 46) {      // si en alguna de las posiciones encuentra el numero 46 (que en el codigo ASCCI implica 
                                          // que encontro el simbolo '.') la variable utilizada como contador aumentara en 1
                Pcount++;                 // metodo 'charAt' de la clase String, devuelve un valor correspondiente al codigo ASSCI  
            }
        }
        for (int x = 0; x < id.length(); x++) { // en esta funcion se realiza lo mismo que en la funcion anterior, salvo que este cuenta los giones (-)
            if (id.charAt(x) == 45) {      
                Lcount++;
            }
        }
        for (int a = 0; a < id.length(); a++) {     // recorre el rut desde la posicion 0 hasta la ultima    
            for (int i = 97; i < 123; i++) {      // simula el Abcedario segun el codigo ASSCI (97=a,98=b.... z=122)
                if (id.charAt(a) == i || id.charAt(a) == 241) {  // si uno de los caracteres del rut es una letra 'o' es el simbolo ñ (241 ASSCI), ingresa
                    if (id.charAt(id.length() - 1) == 107) {   // si el codigo ASSCI del rut en la ultima - 1 (digito verificador), es la letra 'k',
                        System.out.println("Replace 'k' with zero");   // muestra el siguiente mensaje por consola
                    }
                    return false; // retorna falso
                }
            }
        }
        id = id.replace(".", "");  // se remplazan todos los simbolos iguales a '.' del rut por vacio (los quita)

        if (id.charAt(0) == 48 || id.charAt(0) == 45 || id.length() == 1||id.charAt(0) == 46 ) { // si en la primera posicion se encuentra el simbolo 
            return false;                                                                  // '.' o '-' o bien el numero entero 0 (48), retorna falso 
            
        }
        IDAux = id.codePointAt(id.length() - 2);  // se guarda en la variable mencionada el simbolo que se encuenta antes del digito verificador
        id = id.replace("-", "");               // se reemplaza el caracter '-' por nada
        aux = id.length();                  // se le asigna el tamaño del rut sin puntos ni gion a la variable aux
        
        return IDFormat1(aux, IDAux, Lcount, Pcount, auxID);   // se llama al metodo IDFormat1, entregando los atributos rescatados en el actual metodo
    }
    private boolean IDFormat1(int aux, int IDAux, int Lcount, int Pcount, String auxID) { // se insertan las variables rescatadas del metodo anterior
        if (aux >= 1 && aux <= 4 && IDAux == 45 && Lcount == 1) {    // si el tamaño del rut esta entre 1 y 4 y ademas el simbolo '-' 
            if (Lcount != 1) {      // esta en su posicion (longitud total - 1)y por ultimo si el contador de giones es 1
                return false;    // ingresa a la siguiente condicion que establece que si el numero de giones 
            }                 // es distinto de 1, retornara falso, si ninguna de las anteriores condiciones se cumplen
            return true;  // retorna verdadero
        } else {
            if (IDAux != 45 || Lcount != 1) { // si no se cumple la primera comparacion, se pregunta si el simbolo guardado en IDaux es diferente de 45 (-)
                return false;          // o el contador de giones es diferente de 1, retorna falso (rut invalido)
            } else {
                int five = 5, six = 6, seven = 7;   // sino, se crean variables, las cuales guardaran valores constantes, estas variables son creadas para 
                int auxFive = five, auxSix = six, auxSeven = seven; // determinar las posiciones exactas de los puntos en el rut segun el tamaño de este.
            // se declara una variable de tipo boolean      // tamaño 5- posicion 1; tamaño 6-posicion 2; tamaño 7-posicion 3 , el cual presenta un
                boolean flag = false;               // patron exacto( secuencia numerica de 3 en 3), aumentando en cada secuancia un punto (.)
                return IDFormat2(flag, aux, auxFive, auxSix, auxSeven, Pcount, auxID); // se llama al metodo IDFOrmat2, otorgando los atributos rescatados
            }                                                                        
        }
    }
    private boolean IDFormat2(boolean flag, int aux, int auxFive, int auxSix, int auxSeven, int Pcount, String auxID) { // recibe parametros
        int PPcount = 1; // declara variable PPcount, la cual contara el numero de puntos que DEBERIA tener el rut, se inicializa en 1, ya que se tomara
                     // en cuenta que el primer punto de cada secuencia, ya se encuentra en su posicion
        while (flag == false) { // mientras la variable flag sea false (estado original) realizar:
            if (aux == auxFive) {  // si el tamaño es 5 ingresar , sino seguir 
                for (int x = 1; x < aux; x = x + 4) { // se define la ubicacion de cada punto segun secuencia numerica (3 en 3)
                    if (auxID.charAt(x) != 46 || PPcount != Pcount) { // si la posicion donde deberia existir el simbolo '.' no existe o el contador 
                        return false;//de numeros segun la secuencia es distinto al contador de numeros segun la funcion definida en IDFormat,retorna falso 
                    } else {  // sino , retorna verdadero (rut valido)                      
                        return true;
                    }
                }
            } else {    // si el tamaño no es 5 , revisara la siguiente comparacion
                if (aux == auxSix) { // si el tamaño es 6 , ingresara
                    for (int x = 2; x < aux; x = x + 4) { // se repite la secuancia anterior solo que parte en la posicion 2 
                        if (auxID.charAt(x) != 46 || PPcount != Pcount) {
                            return false;    // rechaza el rut
                        } else {
                            return true;     // acepta el rut
                        }
                    }
                } else {
                    if (aux == auxSeven) {    // si el tamaño es 7
                        for (int x = 3; x < aux; x = x + 4) {
                            if (auxID.charAt(x) != 46 || PPcount != Pcount) {
                                return false;
                            } else {
                                return true;
                            }
                        }
                    } else { // si no se cumplen ninguna de las comparaciones de los tamaños anteriores, la secuencia seguira avazando hasta retornar
                        auxFive = auxFive + 3;  // un valor verdadero o falso
                        auxSix = auxSix + 3;
                        auxSeven = auxSeven + 3;
                        PPcount++;    // se suma uno al contador segun secuencia
                    }
                }
            }
        }
        return false;  // retorna falso 
    }
  
// metodos gett and set, clase pila
    public NodeStack getTop() {   
        return top;
    }

    public void setTop(NodeStack top) {
        this.top = top;
    }
}