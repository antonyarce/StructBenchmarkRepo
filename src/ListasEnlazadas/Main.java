package ListasEnlazadas;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Atributos de la insercion aleatoria y las busquedas
		int inicio = 1;
		int fin = 10;
		int tamaño = 10;
		int busqueda = 5;
		int eliminar = 2;
		
		// Prueba de la Lista doblemente enlazada  _______________
		LList dll = new LList();
		
		// Prueba de insercion
        long inicialID = System.nanoTime();
        dll.insertarAleatorio(tamaño, inicio, fin);
        long finalID = System.nanoTime();
        long duracionID = (finalID - inicialID);
        System.out.println("Insercion DLL | Duracion: "+ duracionID);
        dll.list_print();
        
        // Prueba de busqueda
        long inicialBD = System.nanoTime();
        dll.find_node(busqueda);
        long finalBD = System.nanoTime();
        long duracionBD = (finalBD - inicialBD);
        System.out.println("Busqueda DLL | Duracion: "+ duracionBD);
        dll.list_print();
       
        
         // Prueba de eliminacion
        long inicialED = System.nanoTime();
        dll.delete(eliminar);
        long finalED = System.nanoTime();
        long duracionED = (finalED - inicialED);
        System.out.println("Eliminacion DLL | Duracion: "+ duracionED);
        dll.list_print();


	}

}
