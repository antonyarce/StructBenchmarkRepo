package structbenchmark;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Prueba de QuickSort
		int arreglo[] = {2,6,8,1,7,4,5,9,3};
		int izq = 0;
		int der = 8;
		QuickSort.quicksort(arreglo, izq, der);
		System.out.println(Arrays.toString(arreglo));

		//Prueba del BinarySearch
		int arreglo2[] = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(BinarySearch.binarysearch(arreglo2, 5, 9));
		
		//Prueba del arbol y sus metodos 
		abb arbol = new abb();
		arbol.insertar(5);
		arbol.insertar(3);
		arbol.insertar(7);
		arbol.insertar(1);
		arbol.insertar(2);
		arbol.insertar(6);
		arbol.insertar(4);
		
		abb busqueda = arbol.buscar(2);
		busqueda.inOrder();
		arbol.eliminar(3);
	
		arbol.inOrder();

	}
}