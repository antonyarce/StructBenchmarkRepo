package Arboles;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Atributos de la insercion aleatoria y las busquedas
		int inicio = 1;
		int fin = 1000;
		int tamaño = 10;
		int busqueda = 5;
		int eliminar = 8;
		

        // Prueba del arbol AVL _______________________________
        AvlTree arbolAVL = new AvlTree();
        System.out.println ("Prueba AVL: ");
        
        // Prueba de insercion
        long inicialAI = System.nanoTime();
        arbolAVL.InsertarAleatorio(tamaño, inicio, fin);
        long finalAI = System.nanoTime();
        long duracionAI = (finalAI - inicialAI);
        System.out.println("Insercion AVL | Duracion: "+ duracionAI );
        arbolAVL.preOrden(arbolAVL.getRoot());
        System.out.println ("");
        
        // Prueba de busqueda
        long inicialAB = System.nanoTime();
        arbolAVL.Existe(busqueda, arbolAVL.getRoot());
        long finalAB = System.nanoTime();
        long duracionAB = (finalAB - inicialAB);
        System.out.println("Busqueda AVL | Duracion: "+ duracionAB);
        //arbolAVL.preOrden(arbolAVL.getRoot());

        // Prueba de eliminacion
        long inicialAE = System.nanoTime();
        arbolAVL.Eliminar(eliminar);
        long finalAE = System.nanoTime();
        long duracionAE = (finalAE - inicialAE);
        System.out.println("Eliminacion AVL | Duracion: "+ duracionAE);
        arbolAVL.preOrden(arbolAVL.getRoot());
        System.out.println ("");
        
        //Prueba del RedBlackTree ___________________________
        
        RBTree rbt = new RBTree(Integer.MIN_VALUE); 
        System.out.println ("Prueba del RedBlackTree: ");

        // Prueba de insercion
        long inicialIR = System.nanoTime();
        rbt.insertarAleatorio(tamaño, inicio, fin);

        long finalIR = System.nanoTime();
        long duracionIR = (finalIR - inicialIR);
        System.out.println("Insercion RedBlackTree | Duracion: "+ duracionIR);
        rbt.inorder();
        System.out.println ("");
        
        // Prueba de busqueda
        long inicialBR = System.nanoTime();
        boolean busquedaRBT = rbt.search(busqueda);
        long finalBR = System.nanoTime();
        long duracionBR = (finalBR - inicialBR);
        System.out.println("Busqueda RedBlackTree | Duracion: "+ duracionBR+ "; Se encontro el valor: "+ busquedaRBT);

        // Prueba del arbol Splay _______________________________
        SplayTree arbolSplay = new SplayTree();
        System.out.println ("Prueba SplayTree: ");
        
        // Prueba de insercion
        long inicialSI = System.nanoTime();
        arbolSplay.insert(1);
        long finalSI = System.nanoTime();
        long duracionSI = (finalSI - inicialSI);
        System.out.println("Insercion Splay | Duracion: "+ duracionSI );
        arbolSplay.inorder();
        System.out.println ("");
        
        // Prueba de busqueda
        long inicialSB = System.nanoTime();
        arbolSplay.find(busqueda);
        long finalSB = System.nanoTime();
        long duracionSB = (finalSB - inicialSB);
        System.out.println("Busqueda Splay | Duracion: "+ duracionSB);


        // Prueba de eliminacion
        long inicialSE = System.nanoTime();
        arbolSplay.remove(eliminar);
        long finalSE = System.nanoTime();
        long duracionSE = (finalSE - inicialSE);
        System.out.println("Eliminacion Splay | Duracion: "+ duracionSE);
        arbolSplay.inorder();
        System.out.println ("");
        


	}
}