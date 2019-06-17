/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularlistlabone;

import javax.swing.JOptionPane;

/**
 *
 * @author morag
 */
public class CircularListLabOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         int opt = 0, pos;
        String el, aux;

        List list = new List();

        list.addToFinal("JUAN");
        list.addToFinal("LUCHO");
        list.addToFinal("PEDRO");
        list.addToFinal("SOFIA");
        list.addToFinal("CASANDRA");
        list.addToFinal("ANIBAL");
        list.addToFinal("JACOB");
        list.addToFinal("INUYASHA");
        list.addToFinal("SEILORMUN");
        list.addToFinal("NOBITA");
        list.ShowAll();
        do {
            try {
                opt = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Add data to the Final\n2. Add data to an specific position\n"
                        + "3. Show list\n4. Delete node for a position\n5. Change data for a position\n6. Remove all\n7. Looking for a data\n"
                        + "8. Order the list alphabetically\n9. Out "));

            } catch (Exception x) {
                JOptionPane.showInputDialog(null, "Please choice a valid answer");
            }

            switch (opt) {
                case 1:
                    Node node = list.start;
                    

                    el = JOptionPane.showInputDialog(null, "Enter data");

                    aux = el.toUpperCase();

                    do {
                        if (node.getValue().equals(aux)) {

                            el = JOptionPane.showInputDialog(null, "Please choice Another data (just unique data)");

                            aux = el.toUpperCase();

                        }
                        node = node.getNext();
                    } while (node != list.start);

                    list.addToFinal(aux);

//                        
                    break;
                case 2:

                    try {
                        el = JOptionPane.showInputDialog(null, "Enter data");

                        aux = el.toUpperCase();
                        pos = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter position"));
                        if (pos <= list.Long()) {

                            node = list.start;

                            aux = el.toUpperCase();

                            do {
                                if (node.getValue().equals(aux)) {

                                    el = JOptionPane.showInputDialog(null, "Enter unique element");

                                    aux = el.toUpperCase();

                                }
                                node = node.getNext();
                            } while (node != list.start);

                            list.InsertforPos(pos, aux);
                        } else {

                            while (pos > list.Long()) {
                                pos = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a valid position"));

                            }
                            list.InsertforPos(pos, aux);
                        }

                    } catch (StringIndexOutOfBoundsException s) {
                        JOptionPane.showInputDialog(null, "Fail\nPosition: " + s.getMessage() + "invalid");
                    }

                    break;
                case 3:
                    list.ShowAll();
                    break;
                case 4:

                    try {
                        pos = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter position of the node, will you want delete"));
                        while (pos >= list.Long() || pos < 0) {
                            pos = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter a valid position"));
                        }

                        list.RemoveForPos(pos);
                    } catch (Exception e) {

                        JOptionPane.showInputDialog(null, "Invalid position ");
                    }

                  
                    break;
                case 5:

                    try {
                        el = JOptionPane.showInputDialog(null, "Enter an element");

                        aux = el.toUpperCase();
                        pos = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter position"));
                        if (pos <= list.Long()) {

                            node = list.start;

                            aux = el.toUpperCase();

                            do {
                                if (node.getValue().equals(aux)) {

                                    el = JOptionPane.showInputDialog(null, "Please choice an unique element");

                                    aux = el.toUpperCase();

                                }
                                node = node.getNext();
                            } while (node != list.start);

                            list.ChangeDataForPos(pos, aux);
                        } else {

                            while (pos > list.Long() || pos < 0) {
                                pos = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter valid position"));

                            }
                            list.ChangeDataForPos(pos, aux);
                        }

                    } catch (StringIndexOutOfBoundsException s) {
                        JOptionPane.showInputDialog(null, "Fail\nPosition: " + s.getMessage() + "invalid");
                    }

                   
                    break;
                case 6:
                    list.DeleteAll();
                    System.out.println("Successfully deleted list");
                 
                    break;
                case 7:
                    el = JOptionPane.showInputDialog(null, "Enter an element");
                    aux = el.toUpperCase();

                    list.Find(aux);
               
                    break;
                case 8:
                    list.Order(list);
                    break;
                case 9:
                default:

            }

        } while (opt != 9);
      
       
    }
    
}
