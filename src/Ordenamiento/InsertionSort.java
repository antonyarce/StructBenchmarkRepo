package Ordenamiento;

public class InsertionSort {
	
	/**
     * Se crea el método de ordenamiento InsertionSort.
     * @param array, pues es lo que se necesita ordenar.
     */
    public static void insertionsort(int[] array) {
        int aux;
        int cont1;
        int cont2;
        for(cont1 = 1; cont1 < array.length; cont1 ++){
            
            aux = array[cont1];
            for(cont2 = cont1 - 1; cont2 >= 0 && array[cont2] > aux; cont2 --) {
                
                array[cont2 +1] = array[cont2];
                array[cont2] = aux;
            }
        }
    }

}
