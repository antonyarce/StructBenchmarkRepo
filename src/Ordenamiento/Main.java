package Ordenamiento;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Atributos del array aleatorio y las busquedas
		int inicio = 1;
		int fin = 10;
		int tamaño = 10;
		int busqueda = 5;

		// Prueba de QuickSort
		int arreglo[] = arrayAleatorio.llenarArrayAleatorio(inicio, fin, tamaño);
		long inicialQS = System.nanoTime();
		QuickSort.quicksort(arreglo, 0, tamaño - 1);
		long finalQS = System.nanoTime();
		long duracionQS = (finalQS - inicialQS);
		System.out.println("QuickSort: "+ Arrays.toString(arreglo)+ "; Duracion: "+ duracionQS);

		//Prueba de InsertionSort
		int arreglo2[] = arrayAleatorio.llenarArrayAleatorio(inicio, fin, tamaño);
		long inicialIS = System.nanoTime();
		InsertionSort.insertionsort(arreglo2);
		long finalIS = System.nanoTime();
		long duracionIS = (finalIS - inicialIS);
		System.out.println("InsertionSort: "+ Arrays.toString(arreglo2)+ "; Duracion: "+ duracionIS);

		//Prueba de MergeSort
		int arreglo3[] = arrayAleatorio.llenarArrayAleatorio(inicio, fin, tamaño);
		long inicialMS = System.nanoTime();
		int[] mergesort = MergeSort.mergesort(arreglo3);
		long finalMS = System.nanoTime();
		long duracionMS = (finalMS - inicialMS);
		System.out.println("MergeSort: "+ Arrays.toString(mergesort)+ "; Duracion: "+ duracionMS);

		// Prueba del BinarySearch
		long inicialBS = System.nanoTime();
		int busquedaBinaria = BinarySearch.binarysearch(arreglo, busqueda);
		long finalBS = System.nanoTime();
		long duracionBS = (finalBS - inicialBS);
		System.out.println("BinarySearch: El numero "+ busqueda +" se encuentra en la posicion "+ busquedaBinaria + " ; Duracion: "+ duracionBS);
		
		//Prueba del LinearSearch
		long inicialLS = System.nanoTime();
		int busquedaLineal = LinearSearch.linearsearch(arreglo, busqueda);
		long finalLS = System.nanoTime();
		long duracionLS = (finalLS - inicialLS);
		System.out.println("LinearSearch: El numero "+ busqueda +" se encuentra en la posicion "+ busquedaLineal+ " ; Duracion: "+ duracionLS);

	}

}
