package structbenchmark;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arreglo[] = {2,6,8,1,7,4,5,9,3};
		int izq = 0;
		int der = 8;
		QuickSort.quicksort(arreglo, izq, der);
		System.out.println(Arrays.toString(arreglo));

	}

}
