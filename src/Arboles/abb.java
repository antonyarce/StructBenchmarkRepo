package Arboles;

import java.util.Random;

public class abb {
 
    private class nodoArbol { //Clase nodo con constructor
        private abb hd;
        private abb hi;
        private int dato;
 
        private void nodoArbol(){
            hd = null;
            hi = null;
            dato = 0;
        }
    }
 
    public nodoArbol raiz;
 
    public void abb(){ //Crea una raiz al instanciar un arbol
        nodoArbol raiz = new nodoArbol();
    }
 
    public boolean esVacio(){ // Revisa si el arbol esta vacio
        return (raiz == null);
    }
 
    public void insertar(int a){ //inserta elemntos al arbol
        if (esVacio()) { //comprueba si es vacio
            nodoArbol nuevo = new nodoArbol(); //Si lo es, crea una raiz
            nuevo.dato = a;
            nuevo.hd = new abb();
            nuevo.hi = new abb();
            raiz = nuevo;
        }
        else {
            if (a > raiz.dato) { // si la insercion es mayor a la busqueda
                (raiz.hd).insertar(a); //aplica insercion de "a" en el hijo derecho
            }
            if (a < raiz.dato){
                (raiz.hi).insertar(a); //aplica insercion de "a" en el hijo izquierdo
            }
        }
    }
    
    public void insertarAleatorio(int elementos, int desde, int hasta){ //inserta elemntos al arbol
    	Random rnd = new Random();
    	int a = rnd.nextInt(hasta - desde + 1) + desde;
    	while (elementos > 0){
	        if (esVacio()) { //comprueba si es vacio
	            nodoArbol nuevo = new nodoArbol(); //Si lo es, crea una raiz
	            nuevo.dato = a;
	            nuevo.hd = new abb();
	            nuevo.hi = new abb();
	            raiz = nuevo;
	        }
	        else {
	            if (a > raiz.dato) { // si la insercion es mayor a la busqueda
	                (raiz.hd).insertar(a); //aplica insercion de "a" en el hijo derecho
	            }
	            if (a < raiz.dato){
	                (raiz.hi).insertar(a); //aplica insercion de "a" en el hijo izquierdo
	            }
	        }
	        elementos = elementos - 1;
	        a = rnd.nextInt(hasta - desde + 1) + desde;
    	}
    	
    }
    

    
 
    public void preOrder(){
        if (!esVacio()) {
            System.out.print( raiz.dato + ", "  );
            raiz.hi.preOrder();
            raiz.hd.preOrder();
        }
    }
 
    public void inOrder(){ // Ordena los nodos de menor a mayor
        if (!esVacio()) {
            raiz.hi.inOrder();
            System.out.print( raiz.dato + ", "  );
            raiz.hd.inOrder();
        }
    }
 
    public void posOrder(){
        if (!esVacio()) {
            raiz.hd.posOrder();
            raiz.hi.posOrder();
            System.out.print( raiz.dato + ", "  );
 
        }
    }
 
    public abb buscar(int a){ // Busca un valor int y lo devuelve como un arbol de un solo nodo
        abb arbolito = null;
        if (!esVacio()) { //si no es vacio
            if (a == raiz.dato) { //si el valor a es igual al dato de la raiz
            return this; //retorna la raiz
            }
            else {
                if (a < raiz.dato) { //si el valor a es menor al dato de la raiz
                    arbolito = raiz.hi.buscar(a); // busca en el hijo izquierdo de la raiz
                }
                else {  //si el valor a es mayor al dato de la raiz
                    arbolito = raiz.hd.buscar(a); // busca en el hijo derecho de la raiz
                }
            }
        }
        return arbolito;
    }
 
    public boolean existe(int a){ //Comprueba si existe el valor a en un arbol
    if (!esVacio()) { //si no es vacio
            if (a == raiz.dato) { //si el valor de a es igual al dato de la raiz
            return true;
            }
            else {
                if (a < raiz.dato) { //si el valor de a es menor al dato de la raiz
                    raiz.hi.existe(a); // busca en el hijo derecho de la raiz
                }
                else { //si el valor de a es mayor al dato de la raiz
                    raiz.hd.existe(a); // busca en el hijo derecho de la raiz
                }
            }
        }
        return false;
    }
 
    public int cantidad(){ //retorna la cantidad de nodos de un arbol
        if (esVacio()) { // Si esta vacio
            return 0;
        }
        else {
            return (1 + raiz.hd.cantidad() + raiz.hi.cantidad()); //cuenta 1 y cuenta los hijos derechos e izquierdos
        }
    }
 
    public int altura() { // Retorna los niveles del arbol
        if (esVacio()) {
            return 0;
        }
        else {
            return (1 + Math.max(((raiz.hi).altura()), ((raiz.hd).altura())));
        }
    }
 
    public int buscarMin() { //Busca una hoja sin hijos
        abb arbolActual = this;
        while( !arbolActual.raiz.hi.esVacio() ) {
            arbolActual = arbolActual.raiz.hi;
        }
        int devuelvo= arbolActual.raiz.dato;
        arbolActual.raiz=null;
        return devuelvo;
    }
 
    public int buscarMan() {
        abb arbolActual = this;
        while( !arbolActual.raiz.hd.esVacio() ) {
            arbolActual = arbolActual.raiz.hd;
        }
        int devuelvo= arbolActual.raiz.dato;
            arbolActual.raiz=null;
        return devuelvo;
    }
 
    public boolean esHoja() { //comprueba si es hoja
        boolean hoja = false;
        if( (raiz.hi).esVacio() && (raiz.hd).esVacio() ) {
            hoja = true;
        }
        return hoja;
    }
 
    public void eliminar(int a) { // elimina nodos 
        abb paraEliminar = buscar(a); //crea un arbol para eliminar
        if (!paraEliminar.esVacio()) { // si el arbol no es vacio
            if (paraEliminar.esHoja()) { // si es hoja
                paraEliminar.raiz = null; // elimina el arbol convirtiendo la raiz en nula
            }
            else {
                if (!paraEliminar.raiz.hi.esVacio() && !paraEliminar.raiz.hd.esVacio()) { // si los hijos no son vacios
                    paraEliminar.raiz.dato = paraEliminar.raiz.hd.buscarMin(); // busca el minimo del hijo derecho y lo convierte en raiz
                }
                else {
                    if (paraEliminar.raiz.hi.esVacio()) { //si el hijo izquierdo de la raiz es vacio
                        paraEliminar.raiz = paraEliminar.raiz.hd.raiz; //aplica eliminar en la raiz del hijo derecho de la raiz
                    }else{
                        paraEliminar.raiz = paraEliminar.raiz.hi.raiz; //aplica eliminar en la raiz del hijo izquierdo de la raiz
                    }
                }
            }
        }
    }
}