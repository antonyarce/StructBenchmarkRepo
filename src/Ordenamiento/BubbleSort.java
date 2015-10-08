package Ordenamiento;

public class BubbleSort {
	
	/**
	 * Ordena el arreglo adecuadamente
	 * @param array: El arreglo el cual desea ordenar.
	 */
	public static void bubblesort(int [] array) {
		int aux; // Variable Auxiliar
		boolean cambios = false; // Cambia a verdadera cada vez que se efectua un cambio
		
		
		while(true){
			cambios = false; 
			for(int i=1; i<array.length; i++){ // i es el indice el cual recorrera el arreglo para realizar comparaciones
				// Si el numero de la izquierda es mayor al de la derecha se realiza "swap"
				if(array[i]<array[i-1]){ 
					aux = array[i];
					array[i] = array[i-1];
					array[i-1] = aux;
					cambios = true; // Al ser verdadera indica que se realizo "swap" y permanece en el ciclo
					
				}
			}
			
			if(cambios == false) // Sino se realiza un cambio se detiene.
				break;
		}
	}

}
