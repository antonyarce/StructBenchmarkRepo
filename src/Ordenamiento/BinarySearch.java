package Ordenamiento;

public class BinarySearch {
	
	public static int binarysearch(int  vector[], int dato, int ultimo){

		  int centro;
		  int inf = 0; //primer indice del array
		  int sup = ultimo; //ultimo indice del array
		   
		  while(inf<=sup){ //verifica que el array no este vacio
		     centro=(sup+inf)/2; //saca el indice central del array
		     
		     if(vector[centro] == dato) return centro; //verifica si encontro el dato
		     
		     else if(dato < vector[centro] ){ //verifica si el dato es menor al numero central del vector
		        sup=centro-1; //cambia el indice superior 
		     }
		     else {
		       inf=centro+1; //cambia el indice inferior
		     }
		   }
		   return -1;
	}
	 
	//Es la misma funcion, pero se implementa .length
	 public static int binarysearch(int  vector[], int dato){
		  int n = vector.length;
		  int centro,inf=0,sup=n-1;
		   
		  while(inf<=sup){
		     centro=(sup+inf)/2;
		     
		     if(vector[centro]==dato) return centro;
		     
		     else if(dato < vector[centro] ){
		        sup=centro-1;
		     }
		     else {
		       inf=centro+1;
		     }
		   }
		   return -1;
	 }


}



