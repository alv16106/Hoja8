import static org.junit.Assert.*;

import org.junit.Test;

public class PacientesTest {

	
	/*
	 * revisa que el heap guarde y muestre el paciente correcto
	 */
	@Test
	public void test() {
		VectorHeap<Paciente<String, String, String>> heap = new VectorHeap<Paciente<String, String, String>>();
		Paciente a = new Paciente<String,String,String>("Juan", "Sobredosis de Viagra", "B");
		heap.add(a);
		assertEquals(1, heap.size());
        assertEquals(false, heap.isEmpty());
		Paciente x = heap.remove();
		assertEquals(x,a);
		assertEquals(true, heap.isEmpty());
	}

}
