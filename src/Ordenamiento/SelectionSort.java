package Ordenamiento;

/**
 * Creacion clase SelectionSort
 * @author Roberto Pereira
 * @version 03.10.2015
 *
 */

public class SelectionSort {
	
	/**
	 * Ordena el arreglo adecuadamente
	 * @param array: El arreglo el cual se ordenara
	 */
	public static void selectionsort(int[] array){
		

			for(int i=0; i<array.length-1; i++){ // i es el indice el cual recorrera el arreglo para realizar comparaciones
				int minIndex = i; // Variable para mantener el elemento actual y poder compararlo con los demas 
				for(int j = i + 1; j<array.length; j++){ //j aumenta con respecto al actual para realizar la comparacion
					if(array[j]<array[minIndex]){ // Evalua si el actual es mayor con alguno de su derecha
						minIndex = j; // //Cambia de posicion
		
					}
				}
				
				int	 temp = array[minIndex]; // Guarda la posicion del elemento menor y se aplica "swap"
				array[minIndex] = array[i]; 
				array[i] = temp;	
				
			}		
	}

}
