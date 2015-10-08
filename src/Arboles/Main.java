package Arboles;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Prueba del arbol y sus metodos 
		abb arbolBB = new abb();

		
		arbolBB.insertarAleatorio(100,10);
		
		//abb busqueda = arbolBB.buscar(2);
		//busqueda.inOrder();
		//arbolBB.eliminar(3);
	
		arbolBB.inOrder();
		
        // Se instancia la clase AvlTree
        
        AvlTree arbolAVL = new AvlTree();
        
        /*arbolAVL.Insertar(10);
        arbolAVL.Insertar(5);
        arbolAVL.Insertar(13);
        arbolAVL.Insertar(1);
        arbolAVL.Insertar(6);
        arbolAVL.Insertar(17);*/
        arbolAVL.preOrden(arbolAVL.getRoot());
        arbolAVL.InsertarAleatorio(10, 10);
        
        arbolAVL.Eliminar(10);
        arbolAVL.preOrden(arbolAVL.getRoot());
        
        //Prueba RedBlackTree
        
        // Creación de objetos de RedBlack tree
        RBTree rbt = new RBTree(Integer.MIN_VALUE); 
        System.out.println("Red Black Tree Test\n");          
        
        rbt.insertarAleatorio(10, 1);
        
        System.out.println ("RedBlackTree In order: ");
 	    rbt.inorder();
        

        

	}
}