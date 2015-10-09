
package Ordenamiento;
import java.util.Arrays;

public class HeapSort 
{     
    public static int heapSize;
    public static int LEFT(int i)
    {
        //devuelve índice izquierdo de una matriz basada en el índice cero
        return 2*i+1;
    }

    public static int RIGHT(int i)
    {
        //devuelve índice derecho de una matriz basada en el índice cero
        return 2*i+2;
    }


    public static void Build_Max_Heap(int A[])
    {
        heapSize = A.length;//tamaño del heap inicializado 
        for(int i=A.length/2; i>=0;i--)//desde n / 2 , n / 2 + 1 ... son hojas podemos comenzar desde n / 2 pasos hacia abajo
        {
            //llama a max_heap en cada nodo de la raíz a partir de n / 2
            Max_Heap(A, i);
        }
    }


    public static void Max_Heap(int A[],int i)
    {
        int l=LEFT(i);//índice del elemento de la izquierda , que es 2 * i + 1
        int r=RIGHT(i);//índice derecho = 2 * i + 2 ;
        int Large = -1;//índice no puede ser negativo así inicializar el índice más grande , que se utilizará más adelante
        //heapSize es el tamaño actual de la pila que se está trabajando
        //comprueba si el índice a la izquierda se encuentra dentro de la pila.
        //si el elemento en el índice izquierdo es mayor que la raíz (A [ i ] ) elemento, propiedad del montículo máximo es regresada
        //copia el índice del elemento regresados en largestElementIndex
        if(l<heapSize && A[l]>A[i]){
            Large = l;
        }
        else //si la propiedad max heap no se regresada copia el índice de la raíz en largestElementIndex
        {
            Large=i;
        }
        //compruebe el subárbol derecho para el max heap
        //Aquí el largestElementIndex se calcula a partir del paso anterior
        if(r<heapSize && A[r]>A[Large])
        {
            Large = r;
        }
        //entonces, si la raíz no tiene el índice más grande de cambiar el elemento más grande con el elemento raíz

        if(Large!=i)
        {
            int temp = A[i];
            A[i]=A[Large];
            A[Large]=temp;
            //después del swap, de forma recursiva llamar al MAX_HEAPIFY en el mayor índice ( elemento raíz )
            Max_Heap(A, Large);
        }
    } 
    
    public static void HeapSort(int A[])
    {
        //max heap se construye con HEAPSIZE inicializado
        Build_Max_Heap(A);
        //starting from end loop through entire array
        for(int i=A.length-1;i>=0;i--)
        {
            //el primer elemento de la matriz es la raíz del max heap
            //intercambiarlo con el elemento extremo de la matriz es decir, 
            //estableciendo el elemento más grande hasta el final de la matriz
            int temp = A[0];
            A[0]=A[i];
            A[i]=temp;
            //reduce el heapSize -1
            heapSize  = heapSize-1;
            //llama a max heapify de forma recurciva
            Max_Heap(A,0);
        }
    }


}