
package Ordenamiento;

public class LinearSearch {
	
	/**
	 * Se crea el método de busqueda lineal.
	 * @param arreglo, pues es la estructura de datos donde se buscar.
	 * @param elemento, pues es el dato a buscar, que esta dentro de la estructura de datos.
	 * @return 
	 */
	    public static int linearsearch( int arreglo[], int elemento) {
	        int i;
	        boolean encontrado = false;
	        
	        for ( i = 0; i < arreglo.length && encontrado == false; i++) {
	            
	            if (elemento == arreglo[i]) {
	                
	                encontrado = true;
	                return i;
	            }
	            
	        } return -1;
	    }


}
