public  class TreeNode {  

         TreeNode LeftS, RightS;    // se declaran los punteros LeftS y RightS (hijo izquierdo e hijo Derecho respectivamente)
         int value;         // se declara el tipo de valor a ingresar al nodo

        public TreeNode(int value) {  // construcctor recibe como parametro el dato a ingresar 
            LeftS = null;   // el puntero LeftS apunta a vacio
            RightS = null; // el puntero RightS apunta a vacio
            this.value = value;  // el valor se inicia en el entregado por el usuario
        }
        
        // metodos get y setters

    public TreeNode getLeftS() {
        return LeftS;
    }

    public void setLeftS(TreeNode LeftS) {
        this.LeftS = LeftS;
    }

    public TreeNode getRightS() {
        return RightS;
    }

    public void setRightS(TreeNode RightS) {
        this.RightS = RightS;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

  

    }
