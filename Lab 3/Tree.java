public class Tree {         // clase estructura principal arbol

    TreeNode root;   // se declara el nodo root 

    public Tree() {   // se inicializa en vacio
        root = null;
    }

    public boolean isEmpty() {   // metodo para saber si esta el arbol vacio
        return getRoot() == null; // si root es vacio retornara verdadero
    }

    public void AddNode(int value) {  // metodo agregar nodo de forma recursiva, como parametro obtendra el dato a ingresar por el usuario
        if (isEmpty()) {   // si el arbol esta vacio
            setRoot(new TreeNode(value));  // nodo root apuntara al nuevo nodo con el dato ingresado 
        } else {  // sino 
            if (getRoot().getValue() > value) {  // si el valor de la raiz del arbol es superior al valor digitado por el usuario
                getRoot().setLeftS(AddNode(value, getRoot().getLeftS()));  // hacer que el hijo izquierdo de la raiz sea lo que retorne el metodo AddNode 
            } else {   // de distintos parametros

               getRoot().setRightS(AddNode(value, getRoot().getRightS())) ;  // lo mismo que el caso anterior , solo que se aplica para el hijo derecho
            }
        }
    }

    private TreeNode AddNode(int value, TreeNode root) {   // metodo agregar nodo de distintos parametros, para hallar la ubicacion del nodo nuevo
        if (root == null) {                           // si el nodo root retornado en el metodo anterior es vacio entonces
            root = new TreeNode(value);    // el nodo root sera el nuevo nodo
        } else {     // sino
            if (root.getValue() > value) {     // si el valor de la raiz es mayor al valor reciclado 
                root.setLeftS(AddNode(value, root.getLeftS())); // se repite lo del metodo anterior hasta que uno de los punteros llege a vacio
            } else { 
                root.setRightS(AddNode(value, root.getRightS())) ;
            }
        }
        return root;   // retorna el nodo root para volver a ingresar al metodo recursivo , y ubircarlo en una posicion donde no hallan nodos
    }
    
// 

    public void PreOrder(TreeNode n) {   // metodo para mostrar el arbol con la funcion de ordenamiento PreOrden

        if (n != null) {      // mientras el nodo sea distinto de nulo recorrera el arbol de forma recursiva y mostrara segun el metodo definido los datos
            System.out.print("[" + n.getValue() + "]");
            PreOrder(n.getLeftS());
            PreOrder(n.getRightS());
        }

    }

    public boolean Search(int value) {  // metodo para buscar un nodo
        TreeNode route = getRoot();    // se instancia nodo route, el cual apuntara a la raiz del arbol
        while (route != null) {   // mientras la replica del nodo raiz, sea distinto de vacia , realizar
            if (route.getValue() == value) {   // si el valor de la replica es igual al valor ingresado por el usuario retornar verdadero
                return true;
            } else {                            // sino , se recorre el arbol segun el tamaño del dato ingresado hasta encontrarlo
                if (value < route.getValue()) {
                    route = route.getLeftS();
                } else {                            
                    route = route.getRightS();
                }

            }       
        }                           // sino lo encuentra retornara falso
        return false;
    }

    public boolean Delete(int d) {  // metodo para eliminar un nodo
        TreeNode aux = getRoot();  // se instancia nodo aux que apuntara al nodo raiz (nodo base del arbol)
        TreeNode father = getRoot(); // se instancia nodo father que apuntara a raiz 
        boolean Left = true;   // se crea variable de tipo boolean para saber si se encuentra el valor a eleminar en hijo derecho o izquierdo

        while (aux.getValue() != d) { // funcion para recorrer el arbol en busqueda del nodo a eliminar
            father = aux;             // el nodo father cada vez que el nodo aux avanze, sera denominado como tal
            if (d < aux.getValue()) {  // si el valor a eliminar es menor al nodo que recorrera el arbol realizar
                Left = true;    // variable boolean sera verdadero
                aux = aux.getLeftS();  // avanza el nodo aux al siguiente nodo por el lado izquierdo de este
            } else {     // si no es menor, entonces sera mayor o igual (este ultimo no aplica, ya que en clase principal se prohibe ingresar el mismo nodo)
                Left = false;   // la variable left sera falso, lo que implica en este codigo que es derecho
                aux = aux.getRightS();  // el nodo aux avanzara por el lado derecho del arbol
            }
            if (aux == null) {   // si se llega al final y no se encontro el valor , retornara falso 
                return false;
            }
        }

        if (aux.getLeftS() == null && aux.getRightS() == null) {  // si el hijo izquierdo e hijo derecho de aux apuntan a nulo (nodo hoja) realizar lo siquiente

            if (aux == getRoot()) {  // si el nodo aux es igual a la raiz 
                setRoot(null);       // entonces la raiz apuntara a nulo, restableciendo los valores originales (como si nada hubiera pasado) 
            } else if (Left) {     // sino, si el nodo a eliminar es hijo izquierdo, 
                father.setLeftS(null); //entonces este ultimo apuntara a vacio, rompiendo todo vinulo con el arbol
            } else {       // si es derecho 
                father.setRightS(null) ;  // entonces se apunta el nodo derecho a vacio;
            }

        } else if (aux.getRightS() == null) {  // si el nodo a borrar solo posee el hijo izquierdo (hijo derecho apunta a vacio)
            if (aux == getRoot()) {   // y si es raiz 
                setRoot(aux.getLeftS());  // entonces la raiz sera el unico nodo restante, nodo izquierdo
            } else if (Left) {   // si es nodo izquierdo 
                father.setLeftS(aux.getLeftS()) ; // el nodo padre de hijo izquierdo , sera el nodo auxiliar de hijo izquierdo
            } else {
                father.setRightS(aux.getLeftS());  // si no el nodo padre de hijo derecho sera nodo auxiliar de hijo izquierdo;
            }

        } else if (aux.getLeftS() == null) {  // caso semejante al anterior solo que el que apunta a null sera el hijo izquierdo 
            if (aux == getRoot()) {
                setRoot(aux.getRightS());
            } else if (Left) {
                father.setLeftS(aux.getRightS());
            } else {
                father.setRightS(aux.getLeftS()) ;
            }
            
        } else {    // si el nodo tiene dos hijos realizar lo siguiente
           // se instancia nodo reemplazo el cual ingresara al metodo GetReaplaceNode, este ultimo retornara el nodo que reemplaza al eliminado
            TreeNode replace = GetReplaceNode(aux); 
            if (aux == getRoot()) {  // si aux es raiz 
                setRoot(replace);   // se remplaza por el nodo retornado anteriormente, lo mismo con nodo izquierdo y derecho
            } else if (Left) {
                father.setLeftS(replace);  
            } else {
                father.setRightS(replace) ;
            }
            replace.setLeftS(aux.getLeftS());   // el puntero del nodo de reemplazo se apuntara al hijo izquierdo de auxiliar

        }
        return true;    // retornara verdadero
    }

    public TreeNode GetReplaceNode(TreeNode replacenode) { // se ingresa el nodo a analizar (aux)
        TreeNode replaceFather = replacenode;  // se  apunta nodo al nodo retornado anteriormente
        TreeNode replace = replacenode;  // se guarda el nodo retornado en variable replace 
        TreeNode aux = replacenode.getRightS(); // se instancia nodo auxiliar el cual apunta al lado derecho del nodo retornado 
        // se aplicara criterio Menor de los Mayores para la sustitucion de nodos 

        while (aux != null) {  // mientras auxiliar sera disinto a vacio
            replaceFather = replace;  // nodo replace father se convierte en el nodo retornado
            replace = aux;  // el nodo retornado en el auxiliar
            aux = aux.getLeftS(); // se avanza por hijo izquierdo del nodo aux
        }
        if (replace != replacenode.getRightS()) { // mientras el nodo replece sea distinto al hijo derecho del nodo ingresado en metodo anteiror 
            // el hijo del nodo izquierdo del nodo replacefather sera el hijo derecho del nodo retornado (que se ira actualizando en la funcion anterior)
            replaceFather.setLeftS(replace.getRightS());
            // por otro lado el hijo derecho del nodo replace, se reemplara por el hijo derecho del valor actualizado del nodo
            replace.setRightS(replacenode.getRightS()); 

        }
        // retorna el valor que reemplaza al valor eliminado 
        return replace;
    }

    // metodos get y setters
    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

}