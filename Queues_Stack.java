import javax.swing.JOptionPane;

/**
 *
 * @author morag
 */
public class Queues_Stack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack stack = new Stack();                              // se instancia y crea una pila.
        Queue queue1 = new Queue();                             // se instancia y crea una cola con rango determinado.
        Queue queue2 = new Queue();                             // segunga cola con disinto rango.
        String name, id, auxID;                                 // se definen variables a utilizar.
        int age = 0, auxWithoutVerificationDigit, opt = 0;
        // Se agregan 5 nodos nuevos a la cola de rango 1 - 999.999 con diferentes atributos, respetando el Ingreso FIFO (añadidas al ultimo) 
        queue1.AddNodeToQueue("Javier", "12.123-4", 12);
        queue1.AddNodeToQueue("Felipe", "123.123-3", 13);
        queue1.AddNodeToQueue("Constanza", "523.223-1", 14);     
        queue1.AddNodeToQueue("Maria", "993.193-9", 15);
        queue1.AddNodeToQueue("Juan", "123.123-0", 16);
        //Se agregan 5 nodos a la cola de rango 1.000.000 - 1.999.999
        queue2.AddNodeToQueue("Gaston", "1.234.234-4", 17);
        queue2.AddNodeToQueue("Ignacio", "1.999.993-2", 18);   
        queue2.AddNodeToQueue("David", "1.000.002-8", 19);
        queue2.AddNodeToQueue("Jhon", "1.000.000-3", 20);
        queue2.AddNodeToQueue("Lucas", "1.890.000-4", 21);
        //Se añaden a la pila respetando el ingreso de esta, LIFO (se añaden al comienzo)
        stack.AddQueueToStack(queue1);
        stack.AddQueueToStack(queue2);

do {           // hacer mientras se respete la condicion
    try {
        opt = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Ingresar Nodo\n2. Imprimir Lista\n3. Salir")); // menu mostrado en ventana emergente
        //si la variable opt es uno de los valores (case 1 = 1) digitados, ingresara, realizando lo que esta dentro
        switch (opt) {
        case 1:  
            name = JOptionPane.showInputDialog(null, "Ingrese Nombre"); // se le pide al usuario ingresar un nombre
            id = JOptionPane.showInputDialog("Ingrese Rut");            // usuario ingresa el rut
            auxID = id;      // variable auxiliar de rut para guardar el original tras modificar la variable id
            
            // mientras el rut sea invalido(repetido o sin formato), se pedira un nuevo rut
            while (!stack.IDFormat(id) || stack.Unique(id) || queue1.Unique(id) || queue2.Unique(id)) {
                id = JOptionPane.showInputDialog("Ingrese Rut Valido y Unico");    // se solicida un nuevo rut       
                auxID = id;    // variable para guardar rut original
                
            }
            try {
                age = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Edad"));  // solicita la edad
                
            } catch (Exception e) {
                JOptionPane.showInputDialog("Edad Invalida " + e.getMessage());    // si la edad no pertenece a un numero entero, muestra un error
                
            }
            
            id = id.replace(".", "");  // se reemplazan todos los caracteres de rut que sean '.' por un espacio en blanco
            id = id.replace("-", "");  // se reemplazan todos los caracteres de rut que sean '-' por un espacio en blanco 
            // convierte a valor entero sin el digito verificador y se guarda en la variable designada
            auxWithoutVerificationDigit = Integer.parseInt(id.substring(0, id.length() - 1)); 

            if (auxWithoutVerificationDigit >= 1 && auxWithoutVerificationDigit <= 999999) { // verifica si el rut ingresado esta dentro del rango 1-999.999
                queue1.AddNodeToQueue(name, auxID, age);    // si lo esta, se agrega el nuevo nodo a la cola con sus respectivos atributos
                stack.AddQueueToStack(queue1);              // se llama al metodo 'añadir cola a la pila' y se le agrega la cola anteriormente definida
                stack.ShowTop();                            // Se muestra la Pila(top), cada vez que se inserta un nuevo nodo a las colas 
                
            } else {
                if (auxWithoutVerificationDigit >= 1000000 && auxWithoutVerificationDigit <= 1999999) {
                queue2.AddNodeToQueue(name, auxID, age);
                stack.AddQueueToStack(queue2);   
                stack.ShowTop();

                } else {
                    // si no cimple con los rangos anteriores mencionados, se crea una nueva cola , añadiendola al inicio de la pila
                    Queue nueva = new Queue();                  
                    nueva.AddNodeToQueue(name, auxID, age);
                    stack.AddQueueToStack(nueva);
                    stack.ShowTop();
                    
                }
            }   
        break;
        
        case 2:
            stack.ShowTop();   // en el caso de que el usuario digita un 2, se muestra la pila 
        break;
        
        case 3:        // 3 , para salir
        default:
        break;
        
        }
                // si el usuario ingresa un caracter ajeno a un numero entero, se muestra el mensaje 
            } catch (Exception e) {
                JOptionPane.showInputDialog(null, "Ingrese Opcion Valida");   

            }
        } while (opt != 3);
    }

}