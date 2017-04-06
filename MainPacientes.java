import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Yasmin Chavez     16101
 * @author Rodrigo Alvarado  16106
 *
 */
public class MainPacientes {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Desea usar el (1)'Vector Heap' o el (2)'PriorityQueue'?");
		int a = s.nextInt();
		
		// Creacion de las clases a mplementar
		PriorityQueue<Paciente<String, String, String>> ss = new PriorityQueue<Paciente<String, String, String>>();
		VectorHeap<Paciente<String, String, String>> heap = new VectorHeap<Paciente<String, String, String>>();
		String cadena;
		
		//Utilizacion de buffered Reader para obtener los datos de un archivo de texto
		FileReader fr = new FileReader("pacientes.txt");
	 	BufferedReader bf = new BufferedReader(fr);
	 	// Guardar los pacientes en el metodo seleccionado
		while ((cadena = bf.readLine()) != null) {
			cadena = cadena.replaceAll("[()]", "");
			String[] datos = cadena.split("\\s*,\\s*");
			// Guarda e el vector heap
			if (a==1){
				heap.add(new Paciente<String, String, String>(datos[0], datos[1], datos[2]));
			}
			// Guarda en el JCF
			else{
				ss.add(new Paciente<String, String, String>(datos[0], datos[1], datos[2]));
			}
			
			System.out.println(heap.toString());
		}
		bf.close(); // cierra el txt}
		
		//Mostrar los pacientes del VectorHeap
		if(a==1){
			while (heap.size()!=0){
				System.out.println(heap.remove().toString());
			}
		// Mostrar los pacientes del JCF
		}else{
			while (ss.size()!=0){
				System.out.println(ss.remove().toString());
			}
		}
		

	}

}
