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
		PriorityQueue<Paciente<String, String, String>> ss = new PriorityQueue<Paciente<String, String, String>>();
		VectorHeap<Paciente<String, String, String>> heap = new VectorHeap<Paciente<String, String, String>>();
		String cadena;
		
		//Utilizacion de buffered Reader para obtener los datos de un archivo de texto
		FileReader fr = new FileReader("pacientes.txt");
	 	BufferedReader bf = new BufferedReader(fr);
		while ((cadena = bf.readLine()) != null) {
			cadena = cadena.replaceAll("[()]", "");
			String[] datos = cadena.split("\\s*,\\s*");
			if (a==1){
				heap.add(new Paciente<String, String, String>(datos[0], datos[1], datos[2]));
			}else{
				ss.add(new Paciente<String, String, String>(datos[0], datos[1], datos[2]));
			}
			
			System.out.println(heap.toString());
				
			//System.out.println(datos[1]);
		}
		bf.close(); // cierra el txt
		if(a==1){
			while (heap.size()!=0){
				System.out.println(heap.remove().toString());
			}
		}else{
			while (ss.size()!=0){
				System.out.println(ss.remove().toString());
			}
		}
		

	}

}
