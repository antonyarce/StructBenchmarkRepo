
package ListasEnlazadas;

import java.util.Random;

public class LList {
    private int size;
    private Node _head;
    private Node _tail;
	
    //constructor
    public LList() {
            size=0;

    }
    
    private class Node {
        int element;
        Node next;
        Node prev;
 
        public Node(int element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }
    
    //inserta nuevos nodos a la lista en un orden acendente
    public void insert_orden(int d) {
        //verifica si el head esta vacio para crear el nodo inicial
        if (_head == null) {
            _head = new Node(d);
            return;
        }
        //comprueba si el head es mayor que el nuevo nodo,
        //si el nuevo es menos este pasa a ser la nueva head
        if (_head.element > d) {
            Node holder = _head;
            Node newNode = new Node(d);
            _head = newNode;
            _head.next = holder;
            holder.prev = newNode;
            return;
        }

        Node tmpNode = _head;
        //recorre la lista para encontrar la pocicion correpondiente del nodo
        while (tmpNode.next != null && tmpNode.next.element < d) {
            tmpNode = tmpNode.next;
        }

        Node prevTmp = tmpNode;         
        Node insertedNode = new Node(d);
        //si no se encuentra en la lista este va a ser el ultimo nodo de la lista
        if (tmpNode.next != null) {
            Node nextTmp = tmpNode.next;
            insertedNode.next = nextTmp;
            nextTmp.prev = insertedNode;
        } 
        prevTmp.next = insertedNode;
        insertedNode.prev = prevTmp;    
    }
    
    public void insertarAleatorio(int elementos, int desde, int hasta){
    	Random rnd = new Random();
    	int d = rnd.nextInt(hasta - desde + 1) + desde;
    	while (elementos > 0){
	        elementos = elementos - 1;
	        d = rnd.nextInt(hasta - desde + 1) + desde;
    	    //verifica si el head esta vacio para crear el nodo inicial
            if (_head == null) {
                _head = new Node(d);
                insertarAleatorio(elementos,  desde, hasta);
                return;
            }
            //comprueba si el head es mayor que el nuevo nodo,
            //si el nuevo es menos este pasa a ser la nueva head
            if (_head.element > d) {
                Node holder = _head;
                Node newNode = new Node(d);
                _head = newNode;
                _head.next = holder;
                holder.prev = newNode;
                insertarAleatorio(elementos,  desde, hasta);
                return;
            }

            Node tmpNode = _head;
            //recorre la lista para encontrar la pocicion correpondiente del nodo
            while (tmpNode.next != null && tmpNode.next.element < d) {
                tmpNode = tmpNode.next;
            }

            Node prevTmp = tmpNode;         
            Node insertedNode = new Node(d);
            //si no se encuentra en la lista este va a ser el ultimo nodo de la lista
            if (tmpNode.next != null) {
                Node nextTmp = tmpNode.next;
                insertedNode.next = nextTmp;
                nextTmp.prev = insertedNode;
            } 
            prevTmp.next = insertedNode;
            insertedNode.prev = prevTmp; 
            

    		
    	}
    }
    
    public void delete(int d) {
        //verifica que la lista no se encuentre vacia
        if (_head == null) {
            System.out.println("Esta vacia");
            return;
        }
        //verifica que sea el primer elemento de la lista para eliminarlo   
        if (_head.element == d) {
            _head = _head.next;
            if (_head != null) {
                _head.prev = null;
            }
            return;
        }

        Node tmpNode = _head;
        //recorre la lista para encontrar el elemento a eliminar
        while (tmpNode != null && tmpNode.element != d) {
            tmpNode = tmpNode.next;
        }
        //en caso de que no se encuentre el elemento no existe
        if (tmpNode == null) {
            System.out.println("Nodo no existe");
            return;
        }
        //si es encontrado es eliminado reacomodando sus relaciones
        if (tmpNode.element == d) {
            tmpNode.prev.next = tmpNode.next;
            if (tmpNode.next != null) {
                tmpNode.next.prev = tmpNode.prev;
            }
        }
    }
    
    public boolean find_node(int d){
        Node tmpNode = _head;
        
        //recorre la lista para encontrar la pocicion correpondiente del nodo
        while (tmpNode.next != null && tmpNode.element != d) {
            System.out.println("--> "+tmpNode.element);
            tmpNode = tmpNode.next;
        }
        if (tmpNode.next==null && tmpNode.element !=d ){
            return false;
        }
        System.out.println("Encontrado: "+tmpNode.element);
        return true;
    }
    
    public void list_print(){
         
        System.out.println("Recorrer la lista");
        Node tmp = _head;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.next;
        }
    }
  
}
