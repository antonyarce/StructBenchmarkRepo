package Ordenamiento;

/**
 *Se crea el algoritmo de ordenamiento MergeSort.
 * @author cristhian
 * @version 02/10/15
 */

public class MergeSort {
	
    /**
     * Se crea el método de ordenamiento MergeSort.
     * @param arreglo, pues es lo que se necesita ordenar.
     * @return el arreglo  ordenado
     */
	
    public static int [] mergesort(int [] arreglo) {
        
        int i, j ,k;
        
        //Esta condición y los siguientes dos ciclos for, se encargan de partir el arreglo en sublistas.
        if(arreglo.length > 1) {
            int nElementosIzq = arreglo.length/2;
            int nElementosDer = arreglo.length - nElementosIzq;
            int arregloIzq[] = new int[nElementosIzq];
            int arregloDer[] = new int[nElementosDer];
            
            //Copiando los elementos de la primera parte al arreglo izq.
            for(i = 0; i < nElementosIzq; i++){
                
                arregloIzq[i] = arreglo[i];
            }
            
            //Copiando los elementos de la parte segunda al arreglo der.
            for(i = nElementosIzq; i < nElementosIzq + nElementosDer; i++) {
                arregloDer[i - nElementosIzq] = arreglo[i];
            }
            
            //Recurividad
            arregloIzq = mergesort(arregloIzq);
            arregloDer = mergesort(arregloDer);
            i = 0;
            j = 0;
            k = 0;
            
            //Este while se encarga de ordenar el arreglo
            while (arregloIzq.length != j && arregloDer.length != k) {
                
                if(arregloIzq[j] < arregloDer[k]) {
                    arreglo[i] = arregloIzq[j];
                    i++;
                    j++;
                } else {
                    arreglo[i] = arregloDer[k];
                    i++;
                    k++;
                }
            }
            
            //Arreglo Final; son los encargados de unir las sublistas ordenadas.
            while (arregloIzq.length != j){
                arreglo[i] = arregloIzq[j];
                i++;
                j++;
            }
            
            while (arregloDer.length != k) {
                arreglo[i] = arregloDer[k];
                i++;
                k++;
            } //Fin del
        }
        return arreglo;
    }

}
