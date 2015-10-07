/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

/**
 * Se crea la clase AvlTree
 * En esta clase va toda la lógica del árbol.
 * @author cristhian
 * @version 01/10/15
 */
public class AvlTree {
    
   

    private AvlNode root;
    boolean aux = true;
    
    // se crea el construcctor de la clase
    public AvlTree() {
        root = null;
    }

    public AvlTree(AvlNode root) {
        this.root = root;
    }
    
    /**
     * Se crea el método isEmpy
     * @param root, pues necesitamos saber si está vacío.
     * @return null, si lo está.
     */
    public Boolean isEmpty(AvlNode root) {
        return root == null;
    }
    
    /**
     * Se crea el método Insertar.
     * Este método es para cuando el arbol este balanceado.
     * @param data, pues el dato es lo que queremos insertar en el arbol.
     */
    void Insertar(int data) {
        if ((!Existe(data, root))) {
            AvlNode info = new AvlNode(data);
            this.root = InsertarBalanceado(getRoot(), info);
        } else {
            //System.out.println("El elemento ya existe");
        }
    }
    
    /**
     * Se crea el método InsertaBalanceado.
     * Este método es para el caso en que el árbol este degenerado.
     * @param root, que será uno de los datos ya existente en el árbol
     * @param node, seŕa uno de los nuevos datos a insertar
     * @return la nueva raiz del árbol.
     */
    AvlNode InsertarBalanceado(AvlNode root, AvlNode node) {
        AvlNode node1;
        AvlNode info = node;
        if (isEmpty(root)) {
            root = info;
            aux = true;
        } else {
            if (node.data < root.data) {

                root.left = InsertarBalanceado(root.left, node);
                if (aux) {
                    switch (root.balance) {
                        case 1:

                            root.balance = 0;
                            aux = false;
                            break;
                        case 0:

                            root.balance = -1;
                            break;
                        //se reestructura ya que pasaria a valer-2 y se desequilibra a la izq
                        case -1:

                            node1 = root.left;
                            if (node1.balance == -1) {

                                root = RotacionIzqIzq(root, node1);
                            } else {

                                root = RotacionIzqDer(root, node1);
                            }
                            aux = false;
                            break;
                    }
                }
            } else {
                if (node.data > root.data) {
                    root.right = InsertarBalanceado(root.right, node);
                    if (aux) {
                        switch (root.balance) {
                            case -1:
                                root.balance = 0;
                                aux = false;
                                break;
                            case 0:
                                root.balance = 1;
                                break;
                            //se reestructura ya que pasaria a valer 2 y se desequilibra a la derecha
                            case 1:
                                node1 = root.right;
                                if (node1.balance == 1) {
                                    root = RotacionDerDer(root, node1);
                                } else {
                                    root = RotacionDerIzq(root, node1);
                                }
                                aux = false;
                                break;
                        }
                    }
                }
            }
        }
        return root;
    }

    
    /**
     * Se crea el método boolean Existe.
     * Este método sirve para comprobar si un dato esta dentro del árbol, necesario para el método eliminar.
     * @param data, pues se necesita saber si el dato existe.
     * @param root, pues si el dato esta, es porque esta en un nodo.
     * @return 
     */
    boolean Existe(int data, AvlNode root) {
        AvlNode nodoAuxiliar = root;
        boolean existe = false;
        while (nodoAuxiliar != null) {
            if (data == nodoAuxiliar.data) {
                existe = true;
                nodoAuxiliar = null;
            } else {
                if (data > nodoAuxiliar.data) {
                    nodoAuxiliar = nodoAuxiliar.right;
                } else {
                    nodoAuxiliar = nodoAuxiliar.left;
                    if (nodoAuxiliar == null) {
                        existe = false;
                    }
                }
            }
        }
        return existe;
    }

    
    /**
     * Se crea el método MayordeMenores
     * Este método es más que todo para obtener la altura del árbol.
     * @param nodo
     * @return 
     */
    public AvlNode MayordeMenores(AvlNode nodo) {
        AvlNode padre = nodo;
        AvlNode aux = nodo.left;
        try {
            while (aux.right != null) {
                padre = aux;
                aux = aux.right;
            }
            padre.right = aux.left;

        } catch (Exception e) {
        }
        return aux;
    }

    /**
     * Se crea el método Eliminar
     * Este método verifica primero si el dato existe.
     * @param data 
     */
    void Eliminar(int data) {
        if ((!Existe(data, root))) {
            System.out.println("El elemento no existe");
        } else {
            Elimina(data);
        }
    }

    /**
     * Se crea el método elimina.
     * Si el dato existe, se procede a eliminarlo con este método.
     * @param data, pues es lo que se necesita eliminar.
     */
    void Elimina(int data) {
        if (data == getRoot().data && getRoot().right == null && getRoot().left == null) {
                root = null;
        } else {
            AvlNode nodoAEliminar = nodoAEliminar(data, getRoot());
            System.out.println("Nodo a eliminar " + nodoAEliminar.data);
            if (nodoAEliminar.data == data && nodoAEliminar.right == null && nodoAEliminar.left == null) {
                System.out.println("Nodo eliminar " + getRoot().left.data);
                root.left = null;
            }
            if (nodoAEliminar.left != null) {
                AvlNode mayordemenores = MayordeMenores(nodoAEliminar);
                System.out.println("el mayor de menores es " + mayordemenores.data);
                if (mayordemenores.data == data) {
                    System.out.println("Se eliminara el " + getRoot().left.data);
                    root.left = null;
                }
            } else {
            }
        }
    }

    private AvlNode nodoAEliminar(int data, AvlNode root) {
        AvlNode raiz = root;
        while (data != raiz.data) {
            if (data > raiz.data) {
                raiz = raiz.right;
            } else {
                raiz = raiz.left;
            }
        }
        return raiz;
    }

    //   Desequilibrio Interno
    //     A- Rotacion Derecha - Izquierda
    private AvlNode RotacionDerIzq(AvlNode root, AvlNode node1) {
        AvlNode node2;
        node2 = node1.left;
        root.right = node2.left;
        node2.left = root;
        node1.left = node2.right;
        node2.right = node1;
        if (node2.balance == 1) {
            root.balance = -1;
        } else {
            root.balance = 0;
        }
        if (node2.balance == -1) {
            node1.balance = 1;
        } else {
            node1.balance = 0;
        }
        node2.balance = 0;
        root = node2;
        return root;
    }
    //B- Rotacion Izquierda - Derecha

    private AvlNode RotacionIzqDer(AvlNode root, AvlNode node1) {

        AvlNode node2;
        node2 = node1.right;
        root.left = node2.right;
        node2.right = root;
        node1.right = node2.left;
        node2.left = node1;
        if (node2.balance == 1) {
            node1.balance = -1;
        } else {
            node1.balance = 0;
        }
        if (node2.balance == -1) {
            root.balance = 1;
        } else {
            root.balance = 0;
        }
        node2.balance = 0;
        root = node2;
        return root;
    }

    // Desequilibrio Externo
    // A- Rotacion Izquierda -Izquierda
    private AvlNode RotacionIzqIzq(AvlNode root, AvlNode node1) {
        root.left = node1.right;
        node1.right = root;
        if (node1.balance == -1) {

            root.balance = 0;
            node1.balance = 0;
        } else {

            root.balance = -1;
            node1.balance = 1;
        }
        root = node1;
        return root;
    }
    //B- Rotacion Derecha - Derecha

    private AvlNode RotacionDerDer(AvlNode root, AvlNode node1) {
        root.right = node1.left;
        node1.left = root;
        if (node1.balance == 1) {
            root.balance = 0;
            node1.balance = 0;
        } else {
            root.balance = 1;
            node1.balance = -1;
        }
        root = node1;
        return root;
    }

    int size() {
        return AvlNode.size(getRoot());
    }

    
    // Los siguiente métodos son los diferentes tipos de recorrido por el árbol.
    
    void inOrden() {
        inOrden(this.getRoot());
    }

    void inOrden(AvlNode root) {
        if (root != null) {
            inOrden(root.left);
            //System.out.println(root.data);
            String hex = Integer.toHexString(root.data);
            System.out.print(hex+" -- ");
            inOrden(root.right);
        }
    }

    void postOrden() {
        postOrden(this.getRoot());
    }

    void postOrden(AvlNode root) {
        if (root != null) {
            postOrden(root.left);
            postOrden(root.right);
            String hex = Integer.toHexString(root.data);
            System.out.print(hex+" -- ");
            //System.out.println(root.data);
        }
    }

    void preOrden() {
        preOrden(this.getRoot());
    }

    void preOrden(AvlNode root) {
        if (root != null) {
            String hex = Integer.toString(root.data);
            System.out.print(hex + " -- ");
            preOrden(root.left);
            preOrden(root.right);
        }

    }
    // por si se desea gráficar el arbol, se utiliza las listas simples.
    // para este trabajo no es necesario hacerlo.
    private SLL nvo = new SLL(); 
    void nodos() {
        nodos_(this.getRoot());
    }

   SLL nodos_(AvlNode root) {
        if (root != null) {
            nodos_(root.left);
            SLLNode temp = new SLLNode(root.data, null);
            nvo.addNode(temp);
            nodos_(root.right);
        }
        return nvo;
    }
    public AvlNode getRoot() {
        return root;
    }
}    

