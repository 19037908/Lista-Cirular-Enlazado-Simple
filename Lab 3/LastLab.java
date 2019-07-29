import javax.swing.JOptionPane;

public class LastLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tree tree = new Tree();        // se crea objeto de tipo arbol
        int value, search, deleting, opt = 0;  // se declaran variables a utilizar

        do {       // mientras la condicion se cumple, se realiza lo siguiente
            try {
                // la variable opt guarda el valor digitado por el usuario, haciendo referencia a una de las opciones dispuestas
                opt = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Input node\n2. Find node\n3. Delete node\n4. Out "));

                switch (opt) { 
                    case 1: // si el valor digitado es 1
                        try {
                            value = Integer.parseInt(JOptionPane.showInputDialog(null, "Input data ")); // se le asigna el valor ingresado a value
                          
                            while (tree.Search(value) == true) {  // se recicla metodo buscar, si es verdadero
                                value = Integer.parseInt(JOptionPane.showInputDialog(null, "Already exist!, Input new data")); //mostrara un mensaje error

                            }
                            tree.AddNode(value); // si no es igual a uno de los valores ya ingresados, se inserta al arbol
                            System.out.println("");  // salto de linea para mejorar la visualizacion de los nodos
                            tree.PreOrder(tree.root);  // se muestra el arbol en base al metodo de ordenamiento "PreOrden"

                        } catch (Exception e) {
                            JOptionPane.showInputDialog(null, "Invalid option"); // mensaje de error por si el usuario ingresa un valor distinto a un numero
                        }
                        break;// vuelve al menu

                    case 2:
                        search = Integer.parseInt(JOptionPane.showInputDialog(null, "Input data for find ")); // se guarda el valor a buscar en search

                        if (tree.Search(search) == false) {
                            JOptionPane.showInputDialog(null, "Dont exist! ");   // si el valor no se encuentra, arroja el mensaje de error

                        } else {
                            JOptionPane.showInputDialog(null, " Succesful Search! ");  // mensaje por si lo encuentra

                        }
                        break; // volver al menu

                    case 3:
                        deleting = Integer.parseInt(JOptionPane.showInputDialog(null, "Input value to delete "));  // se ingresa el valor a eliminar
                        
                        if (tree.Search(deleting)) {   // si el valor a eliminar se encuentra en el arbol realizar lo siguiente
                            tree.Delete(deleting);    // eliminar el nodo mediante el metodo Delete
                            System.out.println("");   // saltar linea
                            tree.PreOrder(tree.root);  // mostrar arbol actualizado

                        } else {
                            JOptionPane.showInputDialog(null, "Dont exist! ");  // de lo contrario el valor no ha sido insertado al arbol

                        }
                        break; // volver al menu
                        
                    case 4:    // sale
                    default:
                        break;  

                }
            } catch (Exception e) {
                JOptionPane.showInputDialog(null, "Invalid option");
            }
        } while (opt != 4);  // si el valor digitado es 4, finaliza el programa
    }

}