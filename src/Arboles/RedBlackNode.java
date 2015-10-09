package Arboles;

import java.util.Random;



/**
 * Creacion clase RedBlackNode
 * @author Roberto Pereira
 * @version 03.10.2015
 *
 */
public class RedBlackNode {
	RedBlackNode left, right;
    int element;
    int color;

    /**
     * 
     * @param theElement
     */
    public RedBlackNode(int theElement)
    {
        this( theElement, null, null );
    } 
    /**
     * 
     * @param theElement: Se le asigna a una variable el cual sera el elemento
     * @param lt: Se le asigna a una variable el cual representa izquierdo
     * @param rt: Se le asigna a una variable el cual representa derecho
     */
    public RedBlackNode(int theElement, RedBlackNode lt, RedBlackNode rt)
    {
        left = lt;
        right = rt;
        element = theElement;
        color = 1;
    }    
}

/**
 * Esta clase se encarga de formar el arbol y realizar operaciones en el mismo.
 */
class RBTree
{ // Variables necesarias para llevar a cabo el algoritmo
    private RedBlackNode current;
    private RedBlackNode parent;
    private RedBlackNode grand;
    private RedBlackNode great;
    private RedBlackNode header;    
    private static RedBlackNode nullNode;
    // Inicializador estático para nullNode 
    static 
    {
        nullNode = new RedBlackNode(0); 
        nullNode.left = nullNode; // Hoja izquierda
        nullNode.right = nullNode; // Hoja derecha
    }
    // Black(negro) = 1,  RED(rojo) = 0 
    static final int BLACK = 1;    
    static final int RED   = 0;

    /**
     * 
     * @param negInf
     */
    public RBTree(int negInf)
    {
        header = new RedBlackNode(negInf);
        header.left = nullNode; // Hoja izquierda
        header.right = nullNode; // Hoja derecha
    }
    /**
     * Función para comprobar si el árbol está vacío
     */
    public boolean isEmpty()
    {
        return header.right == nullNode; // Returna que la cabecera es una hoja 
    }
    /**
     * Hacer el árbol lógicamente vacío
     */
    public void makeEmpty()
    {
        header.right = nullNode; // Convertir la cabecera en una hoja 
    }
    /**
     * Función para insertar un elemento.
     * @param item: El elemento que se insertara en el arbol
     */
    public void insert(int item )
    {
        current = parent = grand = header;
        nullNode.element = item;
        while (current.element != item)
        {            
            great = grand; 
            grand = parent; 
            parent = current;
            current = item < current.element ? current.left : current.right;
            // Comprueba si dos niños son de color rojo y corregir si es así           
            if (current.left.color == RED && current.right.color == RED)
                handleReorient( item );
        }
        // Inserción falla si ya está presente
        if (current != nullNode)
            return;
        current = new RedBlackNode(item, nullNode, nullNode);
        // Adjuntar a los padres
        if (item < parent.element)
            parent.left = current;
        else
            parent.right = current;        
        handleReorient( item );
    }
    
    void insertarAleatorio(int elementos, int desde, int hasta){
    	Random rnd = new Random();
    	int item = rnd.nextInt(hasta - desde + 1) + desde;
    	while (elementos > 0){
            current = parent = grand = header;
            nullNode.element = item;
            while (current.element != item)
            {            
                great = grand; 
                grand = parent; 
                parent = current;
                current = item < current.element ? current.left : current.right;
                // Comprueba si dos niños son de color rojo y corregir si es así           
                if (current.left.color == RED && current.right.color == RED)
                    handleReorient( item );
            }
            // Inserción falla si ya está presente
            if (current != nullNode)
                return;
            current = new RedBlackNode(item, nullNode, nullNode);
            // Adjuntar a los padres
            if (item < parent.element)
                parent.left = current;
            else
                parent.right = current;        
            handleReorient( item );
	        elementos = elementos - 1;
	        item = rnd.nextInt(hasta - desde + 1) + desde;
    	}
    }
    /**
     * Se encarga de rotar de una manera adecuada  
     * @param item: el elemento el cual se rotara
     */
    private void handleReorient(int item)
    {
        // Asignar colores al dar la vuelta
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;

        if (parent.color == RED)   // Si el padre es un nodo rojo
        {
            // Tener que girar
            grand.color = RED; //El abuelo es un nodo rojo
            if (item < grand.element != item < parent.element) // Si el numero a insertar es menor al abuelo y menor al padre
                parent = rotate( item, grand );  // empieza a rotar 
            	current = rotate(item, great );
            	current.color = BLACK; // El actual es un nodo negro 
        }
        // Hacer la raíz negra
        header.right.color = BLACK; 
    }      
    /**
     * Rota
     * @param item: El elemento
     * @param parent: El nodo al cual se le asigno un miembro de la familia
     * @return
     */
    private RedBlackNode rotate(int item, RedBlackNode parent)
    {
        if(item < parent.element)
            return parent.left = item < parent.left.element ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;  
        else
            return parent.right = item < parent.right.element ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);  
    }
    /**
     * Girar nodo del árbol binario con hijo izquierdo
     */
    private RedBlackNode rotateWithLeftChild(RedBlackNode k2)
    {
        RedBlackNode k1 = k2.left; 	
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }
    /**
     * Girar nodo del árbol binario con hijo derecho
     */
    private RedBlackNode rotateWithRightChild(RedBlackNode k1)
    {
        RedBlackNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }
    /**
     * Funcion para contar el número de nodos
     */
    public int countNodes()
    {
        return countNodes(header.right);
    }
    /**
     * Funcion para contar el número de nodos
     * @return el contador de nodos
     */
    private int countNodes(RedBlackNode r)
    {
        if (r == nullNode) // Si la cabacera es nulo entonces no hay nodos
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.left); // Aumenta contador cada nodo a la izquierda
            l += countNodes(r.right);  // Aumenta contador cada nodo a la derecha
            return l;
        }
    }
    /**
     * Funcion de búsqueda de un elemento
     * @param val: El valor del elemento
     */
    public boolean search(int val)
    {
        return search(header.right, val);
    }
    /**
     * Funcion de búsqueda de un elemento
     * @param r: Representa el nodo
     * @param val: El valor del elemento
     * @return: True si lo encontro, false si no.
     */
    private boolean search(RedBlackNode r, int val)
    {
        boolean found = false;
        while ((r != nullNode) && !found)
        {
            int rval = r.element;
            if (val < rval) // si el elemento es menor va hacia el camino izquierdo
                r = r.left;
            else if (val > rval) // si el elemento es mayor va hacia el camino derecho
                r = r.right;
            else
            {
                found = true; // Si lo encuentra la variable found es true 
                break;
            }
            found = search(r, val);
        }
        return found; // Retorna true or false
    }
    /**
     * Función para el recorrido en orden 
     */
    public void inorder()
    {
        inorder(header.right);
    }
    /**
     * Función para el recorrido en orden
     * @param r: Representa el nodo
     */
    private void inorder(RedBlackNode r)
    {
        if (r != nullNode) // Si el nodo no es una hoja
        {
            inorder(r.left);
            char c = 'B'; // Esta variable puede ser un string, numero, en este caso ser "B" es color negro
            if (r.color == 0) // Si el nodo es color rojo
                c = 'R'; // Nodo es color rojo
            System.out.print(r.element +""+c+" "); // imprime el elemento y el color de su nodo
            inorder(r.right); // Su nodo derecho
        }
    }
    /**
     * Función para el recorrido preorden
     */
    public void preorder()
    {
        preorder(header.right);
    }
    /**
     * Función para el recorrido preorden
     * @param r: Representa el nodo
     */
    private void preorder(RedBlackNode r)
    {
        if (r != nullNode) // Si el nodo no es una hoja
        {
            char c = 'B'; // Esta variable puede ser un string, numero, en este caso ser "B" es color negro
            if (r.color == 0) // Si el nodo es color rojo
                c = 'R'; // Nodo es color rojo
            System.out.print(r.element +""+c+" ");  // imprime el elemento y el color de su nodo
            preorder(r.left); // Su nodo izquierdo
            preorder(r.right); // Su nodo drecho
        }
    }
    /**
     * Función de recorrido postorden
     */
    public void postorder()
    {
        postorder(header.right);
    }
    /**
     * Función de recorrido postorden
     * @param r: Representa el nodo
     */
    private void postorder(RedBlackNode r)
    {
        if (r != nullNode)
        {
            postorder(r.left); // Su nodo izquierdo         
            postorder(r.right); // Su nodo drecho
            char c = 'B'; // Esta variable puede ser un string, numero, en este caso ser "B" es color negro
            if (r.color == 0)  // Si el nodo es color rojo
                c = 'R'; // Nodo es color rojo 
            System.out.print(r.element +""+c+" "); // imprime el elemento y el color de su nodo 
        }
    }     
}