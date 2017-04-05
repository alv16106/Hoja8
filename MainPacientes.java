import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
		
		VectorHeap heap = new VectorHeap();
		String cadena;
		
		//Utilizacion de buffered Reader para obtener los datos de un archivo de texto
		FileReader fr = new FileReader("pacientes.txt");
	 	BufferedReader bf = new BufferedReader(fr);
		while ((cadena = bf.readLine()) != null) {
			cadena = cadena.replaceAll("[()]", "");
			String[] datos = cadena.split("\\s*,\\s*");
			heap.add(new Paciente<String, String, String>(datos[0], datos[1], datos[2]));
			System.out.println(heap.toString());
				
			//System.out.println(datos[1]);
		}
		bf.close(); // cierra el txt
		

	}

}
