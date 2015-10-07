package Arboles;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Prueba del arbol y sus metodos 
		abb arbolBB = new abb();
		arbolBB.insertar(5);
		arbolBB.insertar(3);
		arbolBB.insertar(7);
		arbolBB.insertar(1);
		arbolBB.insertar(2);
		arbolBB.insertar(6);
		arbolBB.insertar(4);
		
		arbolBB.insertarAleatorio(100,10);
		
		abb busqueda = arbolBB.buscar(2);
		busqueda.inOrder();
		arbolBB.eliminar(3);
	
		arbolBB.inOrder();
		
        // Se instancia la clase AvlTree
        
        AvlTree arbolAVL = new AvlTree();
        
        // Se asigna el tipo tiempo para tomar el tiempo de ejecucion
        long tiempo = System.nanoTime();
        System.out.println("Tiempo inicial: " + tiempo);
        
        arbolAVL.Insertar(10);
        arbolAVL.Insertar(5);
        arbolAVL.Insertar(13);
        arbolAVL.Insertar(1);
        arbolAVL.Insertar(6);
        arbolAVL.Insertar(17);
        arbolAVL.preOrden(arbolAVL.getRoot());
        
        arbolAVL.Eliminar(10);
        arbolAVL.preOrden(arbolAVL.getRoot());                
        
        long tiempo2 = System.nanoTime();
        System.out.println("TiempoFinal: " + tiempo2);
        System.out.print("Tiempo tardado: ");
        System.out.println(tiempo2-tiempo);
        

	}
}